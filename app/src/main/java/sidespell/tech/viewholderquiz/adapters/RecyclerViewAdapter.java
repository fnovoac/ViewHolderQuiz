package sidespell.tech.viewholderquiz.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sidespell.tech.viewholderquiz.MovieDetailsActivity;
import sidespell.tech.viewholderquiz.R;
import sidespell.tech.viewholderquiz.constants.Constants;
import sidespell.tech.viewholderquiz.entities.Movie;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MovieViewHolder> {

    private Context     mContext;
    private int         mLayoutId;
    private List<Movie> mMovies;

    public RecyclerViewAdapter(Context context, int layoutId, List<Movie> movies) {
        mContext = context;
        mLayoutId = layoutId;
        mMovies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = mMovies.get(position);

        if (movie != null) {
            if (holder.imgMovie != null) {
                holder.imgMovie.setImageResource(movie.getImageId());
            }
            if (holder.tvName != null) {
                holder.tvName.setText(movie.getName());
            }
            if (holder.tvGenre != null) {
                holder.tvGenre.setText(movie.getGenre());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public CardView  cardView;
        public ImageView imgMovie;
        public TextView  tvName;
        public TextView  tvGenre;

        public MovieViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cardView);
            imgMovie = (ImageView) view.findViewById(R.id.imgMovie);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvGenre = (TextView) view.findViewById(R.id.tvGenre);

            // once an item view (list item or grid item) is clicked
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent intent = new Intent(context, MovieDetailsActivity.class);

            intent.putExtra(Constants.EXTRA_POSITION, getAdapterPosition());
            context.startActivity(intent);
        }
    }
}
