package main.java.com.alura.challenge.service;

import main.java.com.alura.challenge.model.Movies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseMovieService {

    public List<Movies> parseMovie(String responseIMDB) {

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
        List<Movies> moviesList = constructMovie(title, year, image, imdbRating);

        return moviesList;
    }

    private List<Movies> constructMovie(List<String> title, List<String> year, List<String> image, List<String> imdbRating) {
        List<Movies> moviesList = new ArrayList<>();

        for (int i = 0; i < title.size(); i++) {

            Movies movie = new Movies();
            movie.setTitles(title.get(i));
            movie.setYear(year.get(i));
            movie.setUrlImages(image.get(i));
            movie.setImDbRating(imdbRating.get(i));
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
