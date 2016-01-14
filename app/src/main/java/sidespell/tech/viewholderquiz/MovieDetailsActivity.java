package sidespell.tech.viewholderquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import sidespell.tech.viewholderquiz.constants.Constants;
import sidespell.tech.viewholderquiz.controllers.MoviesController;
import sidespell.tech.viewholderquiz.entities.Movie;

public class MovieDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        // check intent data passed
        Intent intent = getIntent();
        if (intent == null) {
            throw new RuntimeException("MovieDetailsActivity is expecting an int extra passed by Intent");
        }

        // checks if a movie is present
        int position = intent.getIntExtra(Constants.EXTRA_POSITION, -1);
        if (position == -1) {
            throw new IllegalArgumentException("position passed is invalid.");
        }

        MoviesController controller = new MoviesController();
        Movie movie = controller.getMovies().get(position);

        if (movie == null) {
            throw new NullPointerException("No movie found at the passed position.");
        }

        // find all views
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(movie.getName());
        }

        ImageView imgMovie = (ImageView) findViewById(R.id.imgMovie);
        TextView tvGenre = (TextView) findViewById(R.id.tvMovieGenre);
        TextView tvSummary = (TextView) findViewById(R.id.tvSummary);

        imgMovie.setImageResource(movie.getImageId());
        tvGenre.setText(movie.getGenre());
        tvSummary.setText(movie.getSummary());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
