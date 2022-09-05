package com.tp.tpunla.models;

public class Film {
    private Integer id;
    private String title;
    private String urlImage;
    private String director;
    private Integer score;
    private Integer releaseDate;

    public Film(Integer id, String title, String urlImage, String director, Integer releaseDate, Integer score) {
        this.id = id;
        this.title = title;
        this.urlImage = urlImage;
        this.director = director;
        this.score = score;
        this.releaseDate = releaseDate;
    }

    public Film() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }
}
