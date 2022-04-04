package main.java.com.alura.challenge;


import main.java.com.alura.challenge.client.ImdbClient;
import main.java.com.alura.challenge.model.Movie;
import main.java.com.alura.challenge.service.ParseMovieService;

import java.util.List;


public class ImdbApplication {

    private static ImdbClient client = new ImdbClient("k_7phe7j4o");


    public static void main(String[] args) {
        ParseMovieService parseMovieService = new ParseMovieService();

        String listMovie = client.callIMDB();
        List<Movie> movies = parseMovieService.parseMovie(listMovie);

        System.out.println(movies);
    }
}
