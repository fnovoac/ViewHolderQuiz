package sidespell.tech.viewholderquiz.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sidespell.tech.viewholderquiz.R;
import sidespell.tech.viewholderquiz.entities.Movie;

public class MoviesAdapter extends ArrayAdapter<Movie> {

    private Context     mContext;
    private int         mLayoutId;
    private List<Movie> mMovies;

    public MoviesAdapter(Context context, int resource, List<Movie> movies) {
        super(context, resource, movies);

        mContext = context;
        mLayoutId = resource;
        mMovies = movies;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            // Inflate the layout
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

            // create the view holder
            viewHolder = new ViewHolder();
            viewHolder.imgMovie = (ImageView) convertView.findViewById(R.id.imgMovie);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvGenre = (TextView) convertView.findViewById(R.id.tvGenre);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set the movie data
        Movie movie = mMovies.get(position);

        if (movie != null) {
            if (viewHolder.imgMovie != null) {
                viewHolder.imgMovie.setImageResource(movie.getImageId());
            }
            if (viewHolder.tvName != null) {
                viewHolder.tvName.setText(movie.getName());
            }
            if (viewHolder.tvGenre != null) {
                viewHolder.tvGenre.setText(movie.getGenre());
            }
        }

        return convertView;
    }

    private static class ViewHolder {
        public ImageView imgMovie;
        public TextView  tvName;
        public TextView  tvGenre;
    }
}
