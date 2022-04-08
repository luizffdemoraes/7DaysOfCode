package main.java.com.alura.challenge.model;

import main.java.com.alura.challenge.interfaces.Content;

public class Movie implements Content {
    private String title;
    private String urlImage;
    private String rating;
    private String year;

    public Movie(String titles, String urlImage, String rating, String year) {
        this.title = titles;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public String title() {
        return this.title;
    }

    @Override
    public String urlImage() {
        return this.urlImage;
    }

    @Override
    public String rating() {
        return this.rating;
    }

    @Override
    public String year() {
        return this.year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", rating='" + rating + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    @Override
    public int compareTo(Content c) {
        return this.rating.compareTo(c.rating());
    }
}
