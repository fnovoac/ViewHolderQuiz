package sidespell.tech.viewholderquiz.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import sidespell.tech.viewholderquiz.R;
import sidespell.tech.viewholderquiz.adapters.MoviesAdapter;
import sidespell.tech.viewholderquiz.controllers.MoviesController;

/**
 * A placeholder fragment containing a {@link android.widget.ListView}.
 */
public class ListViewFragment extends Fragment {

    private ListView mListView;
    private TextView mTvEmpty;

    private MoviesController mController;

    public static ListViewFragment newInstance() {
        return new ListViewFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mController = new MoviesController();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // find all the views
        mListView = (ListView) view.findViewById(R.id.listView);
        mTvEmpty = (TextView) view.findViewById(android.R.id.empty);

        // create a new instance of adapter
        MoviesAdapter adapter = new MoviesAdapter(getActivity(),
                R.layout.list_item, mController.getMovies());

        // set the adapter
        mListView.setAdapter(adapter);

        if (adapter.isEmpty()) {
            mTvEmpty.setVisibility(View.VISIBLE);
        } else {
            mTvEmpty.setVisibility(View.GONE);
        }
    }
}
