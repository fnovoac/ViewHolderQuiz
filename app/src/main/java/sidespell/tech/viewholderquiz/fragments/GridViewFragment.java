package sidespell.tech.viewholderquiz.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import sidespell.tech.viewholderquiz.R;
import sidespell.tech.viewholderquiz.adapters.MoviesAdapter;
import sidespell.tech.viewholderquiz.controllers.MoviesController;

/**
 * A placeholder fragment containing a {@link android.widget.GridView}.
 */
public class GridViewFragment extends Fragment {

    private GridView mGridView;
    private TextView mTvEmpty;

    private MoviesController mController;

    public static GridViewFragment newInstance() {
        return new GridViewFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mController = new MoviesController();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gridview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // find all views
        mGridView = (GridView) view.findViewById(R.id.gridView);
        mTvEmpty = (TextView) view.findViewById(android.R.id.empty);

        // create the adapter
        MoviesAdapter adapter = new MoviesAdapter(getActivity(),
                R.layout.grid_item, mController.getMovies());

        // set the adapter
        mGridView.setAdapter(adapter);

        if (adapter.isEmpty()) {
            mTvEmpty.setVisibility(View.VISIBLE);
        } else {
            mTvEmpty.setVisibility(View.GONE);
        }
    }
}
