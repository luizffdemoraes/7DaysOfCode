package main.java.com.alura.challenge.interfaces;

public interface Content extends Comparable<Content> {
    String title();
    String urlImage();
    String rating();
    String year();
}
