package main.java.com.alura.challenge.web;

import main.java.com.alura.challenge.model.Movie;

import java.io.PrintWriter;
import java.util.List;

public class HtmlGenerator {

    private final PrintWriter printWriter;

    public HtmlGenerator(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void generate(List<Movie> movieList) {

        printWriter.println("""
                <html>
                     <head>
                            	<meta charset=\"utf-8\">
                            	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                            	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\"
                            		+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
                     </head>
                 <body>
                     """);

        for (Movie movie : movieList) {
            printWriter.println("<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;>");
            printWriter.println("<h4 class=\"card-header\">" + movie.getTitle() + "</h4>");
            printWriter.println("<div class=\"card-body\">");
            printWriter.println("<img class\"card-img\" src=\"" + movie.getUrlImage() + "alt=\"" + movie.getUrlImage() + " width=\"200\" height=\"300\">");
            printWriter.println("<p class=\"card-text mt-2\">Nota: " + movie.getRating() + " - Ano: " + movie.getYear() + "</p>");
            printWriter.println("</div>");
            printWriter.println("</div>");
        }

        printWriter.println(
                """
                          </body>
                        </html>
                         """);

    }

}
