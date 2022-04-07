package main.java.com.alura.challenge.service;

import main.java.com.alura.challenge.interfaces.Content;
import main.java.com.alura.challenge.interfaces.JsonParser;
import main.java.com.alura.challenge.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class ImdbMovieJsonParser implements JsonParser {

    @Override
    public List<? extends Content> parse(String responseIMDB) {
        int posicaoInicial = responseIMDB.indexOf("[") + 1;
        int posicaoFinal = responseIMDB.lastIndexOf("]");

        String imdbList = responseIMDB.substring(posicaoInicial, posicaoFinal);

        String[] jsonFilmes = imdbList.split("}");

        List<String> title = extractedValueListImdb(jsonFilmes, 2);
        System.out.println(title);

        List<String> year = extractedValueListImdb(jsonFilmes, 4);
        System.out.println(year);

        List<String> image = extractedValueListImdb(jsonFilmes, 5);
        System.out.println(image);

        List<String> imdbRating = extractedValueListImdb(jsonFilmes, 7);
        System.out.println(imdbRating);

        // Unificando o retorno em um Objeto de filmes
        List<? extends Content> moviesList = constructMovie(title, year, image, imdbRating);
        System.out.println("Lista de Filmes: " + moviesList);

        return moviesList;
    }

    private List<? extends Content> constructMovie(List<String> title, List<String> year, List<String> image, List<String> imdbRating) {
        List<Movie> moviesList = new ArrayList<>();

        for (int i = 0; i < title.size(); i++) {
            Movie movie = new Movie(title.get(i), image.get(i), imdbRating.get(i), year.get(i));
            moviesList.add(movie);
        }

        return moviesList;
    }


    private List<String> extractedValueListImdb(String[] split, int position) {
        List<String> movieValue = new ArrayList<>();

        for (String movie : split) {
            if (movie.charAt(0) == ',') {
                movie = movie.replaceFirst(",", "");
            }

            movie = movie.substring(1);
            movie = movie.split("\",\"")[position];
            movie = movie.split(":\"")[1];

            movieValue.add(movie);
        }

        return movieValue;
    }
}
