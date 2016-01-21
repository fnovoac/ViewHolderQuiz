package sidespell.tech.viewholderquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import sidespell.tech.viewholderquiz.fragments.GridViewFragment;
import sidespell.tech.viewholderquiz.fragments.ListViewFragment;
import sidespell.tech.viewholderquiz.fragments.RecyclerViewGridFragment;
import sidespell.tech.viewholderquiz.fragments.RecyclerViewListFragment;

public class MainActivity extends AppCompatActivity {

    private ListViewFragment         mListViewFragment;
    private GridViewFragment         mGridViewFragment;
    private RecyclerViewListFragment mRecyclerViewListFragment;
    private RecyclerViewGridFragment mRecyclerViewGridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create new instances of the fragment
        mListViewFragment = ListViewFragment.newInstance();
        mGridViewFragment = GridViewFragment.newInstance();
        mRecyclerViewListFragment = RecyclerViewListFragment.newInstance();
        mRecyclerViewGridFragment = RecyclerViewGridFragment.newInstance();

        // Set the main content view to the listview fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, mListViewFragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        Fragment fragment = null;

        if (id == R.id.action_listview) {
            fragment = mListViewFragment;
        } else if (id == R.id.action_gridview) {
            fragment = mGridViewFragment;
        } else if (id == R.id.action_recyclerList) {
            fragment = mRecyclerViewListFragment;
        } else if (id == R.id.action_recyclerGrid) {
            fragment = mRecyclerViewGridFragment;
        }

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
