package main.java.com.alura.challenge;


import main.java.com.alura.challenge.client.ImdbClient;
import main.java.com.alura.challenge.model.Movies;
import main.java.com.alura.challenge.service.ParseMovieService;

import java.util.ArrayList;
import java.util.List;


public class ImdbApplication {

    private static ImdbClient client = new ImdbClient("<apiKey>");


    public static void main(String[] args) {
        ParseMovieService parseMovieService = new ParseMovieService();

        String listMovie = client.callIMDB();
        List<Movies> movies = parseMovieService.parseMovie(listMovie);

        System.out.println(movies);
    }
}
