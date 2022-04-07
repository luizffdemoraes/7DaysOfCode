package main.java.com.alura.challenge;


import main.java.com.alura.challenge.client.ImdbApiClient;
import main.java.com.alura.challenge.model.Movie;
import main.java.com.alura.challenge.service.ImdbMovieJsonParser;
import main.java.com.alura.challenge.web.HtmlGenerator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;


public class ImdbApplication {

    public static void main(String[] args) throws FileNotFoundException {

        ImdbApiClient client = new ImdbApiClient();
        ImdbMovieJsonParser imdbMovieJsonParser = new ImdbMovieJsonParser();

        String listMovie = client.requestApiKey();
        List<Movie> movies = (List<Movie>) imdbMovieJsonParser.parse(listMovie);

        System.out.println("Gerando HTML");
        PrintWriter writer = new PrintWriter("movie.html");
        new HtmlGenerator(writer).generate(movies);
        writer.close();
    }
}
