package com.tp.tpunla.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tp.tpunla.R;
import com.tp.tpunla.models.Film;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder>{

    private List<Film> films;
    private OnItemClickListener onItemClickListener;

    public FilmAdapter(List<Film> films, OnItemClickListener onItemClickListener) {
        this.films = films;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemExamen = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new FilmViewHolder(itemExamen);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.filmTitle.setText(films.get(position).getTitle());
        holder.filmDirector.setText(films.get(position).getDirector());
        holder.filmReleaseDate.setText(String.valueOf(films.get(position).getReleaseDate()));
        String score = "★ " + films.get(position).getScore();
        holder.filmScore.setText(score);
        Picasso.get().load(films.get(position).getUrlImage()).into(holder.filmImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onItemClickListener.onItemClick(films.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder {
        TextView filmTitle, filmDirector, filmReleaseDate, filmScore;
        ImageView filmImage;

        public FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            filmTitle = itemView.findViewById(R.id.filmTitle);
            filmDirector = itemView.findViewById(R.id.filmDirector);
            filmReleaseDate = itemView.findViewById(R.id.filmReleaseDate);
            filmScore = itemView.findViewById(R.id.filmScore);
            filmImage = itemView.findViewById(R.id.filmImage);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Film film);
    }
}
