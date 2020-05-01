package com.example.finalmovieapp.views.grid;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalmovieapp.R;
import com.example.finalmovieapp.databinding.MovieCardBinding;
import com.example.finalmovieapp.views.models.MovieCardViewModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieCardViewModel> moviesList;
    private LayoutInflater layoutInflater;

    private OnItemClicked onClick;

    public void setData(List<MovieCardViewModel> moviesList) {
        this.moviesList = moviesList;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        MovieCardBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.movie_card, parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, final int position) {
        holder.binding.setModel(moviesList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (moviesList == null) {
            return 0;
        }
        return moviesList.size();
    }

    public void setOnClick(OnItemClicked onClick) {
        this.onClick = onClick;
    }

    public interface OnItemClicked {
        void onItemClick(int position);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private final MovieCardBinding binding;

        MovieViewHolder(final MovieCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}