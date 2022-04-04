package main.java.com.alura.challenge;


import main.java.com.alura.challenge.client.ImdbClient;
import main.java.com.alura.challenge.model.Movie;
import main.java.com.alura.challenge.service.ParseMovieService;
import main.java.com.alura.challenge.web.HtmlGenerator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;


public class ImdbApplication {

    private static ImdbClient client = new ImdbClient("<apiKey>");


    public static void main(String[] args) throws FileNotFoundException {
        ParseMovieService parseMovieService = new ParseMovieService();

        String listMovie = client.callIMDB();
        List<Movie> movies = parseMovieService.parseMovie(listMovie);

        System.out.println("Gerando HTML");
        PrintWriter writer = new PrintWriter("movie.html");
        new HtmlGenerator(writer).generate(movies);
        writer.close();
    }
}
