package sidespell.tech.viewholderquiz.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sidespell.tech.viewholderquiz.R;
import sidespell.tech.viewholderquiz.adapters.RecyclerViewAdapter;
import sidespell.tech.viewholderquiz.controllers.MoviesController;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewListFragment extends Fragment {

    private MoviesController mController;

    public static RecyclerViewListFragment newInstance() {
        return new RecyclerViewListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mController = new MoviesController();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // Find all the views
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerListView);
        TextView tvEmpty = (TextView) view.findViewById(android.R.id.empty);

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // Unlike a ListView, a RecyclerView needs a LayoutManager to manage the positioning of its
        // items. You could define your own LayoutManager by extending the RecyclerView.LayoutManager
        // class. However, in most cases, you could simply use one of the predefined LayoutManager
        // subclasses. In our case, since we are to create a ListView, we will be using the
        // LinearLayoutManager.
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);

        // Create a new instance of the adapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(),
                R.layout.recycler_list_item, mController.getMovies());

        // Set the Adapter
        recyclerView.setAdapter(adapter);

        if (adapter.getItemCount() == 0) {
            tvEmpty.setVisibility(View.VISIBLE);
        } else {
            tvEmpty.setVisibility(View.GONE);
        }
    }
}
