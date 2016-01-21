package sidespell.tech.viewholderquiz.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sidespell.tech.viewholderquiz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewListFragment extends Fragment {

    public static RecyclerViewListFragment newInstance() {
        return new RecyclerViewListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // TODO: Perform logic execution here
    }
}
