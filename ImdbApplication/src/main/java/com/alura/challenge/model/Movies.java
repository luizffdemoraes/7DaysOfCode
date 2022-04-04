package main.java.com.alura.challenge.model;

public class Movies {
    private String titles;
    private String urlImages;
    private String year;
    private String imDbRating;

    public Movies() {

    }

    public Movies(String titles, String urlImages, String year, String imDbRating) {
        this.titles = titles;
        this.urlImages = urlImages;
        this.year = year;
        this.imDbRating = imDbRating;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getUrlImages() {
        return urlImages;
    }

    public void setUrlImages(String urlImages) {
        this.urlImages = urlImages;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public void setImDbRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "titles='" + titles + '\'' +
                ", urlImages='" + urlImages + '\'' +
                ", year='" + year + '\'' +
                ", imDbRating='" + imDbRating + '\'' +
                '}';
    }
}
