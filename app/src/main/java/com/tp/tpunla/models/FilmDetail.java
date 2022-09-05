package com.tp.tpunla.models;

import android.annotation.SuppressLint;

public class FilmDetail extends Film {
    private String originalTitle;
    private String sinopsis;
    private String urlImageBanner;
    private Integer duration;

    public FilmDetail() {
    }

    public FilmDetail(Integer id, String title, String urlImage, String director, Integer releaseDate, Integer score, String originalTitle, String sinopsis, String urlImageBanner, Integer duration) {
        super(id, title, urlImage, director, releaseDate, score);
        this.originalTitle = originalTitle;
        this.sinopsis = sinopsis;
        this.urlImageBanner = urlImageBanner;
        this.duration = duration;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getUrlImageBanner() {
        return urlImageBanner;
    }

    public void setUrlImageBanner(String urlImageBanner) {
        this.urlImageBanner = urlImageBanner;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @SuppressLint("DefaultLocale")
    public String getDurationString() {
        int hours = this.duration / 60;
        int minutes = this.duration % 60;
        return String.format("%dH %dM", hours, minutes);
    }
}
