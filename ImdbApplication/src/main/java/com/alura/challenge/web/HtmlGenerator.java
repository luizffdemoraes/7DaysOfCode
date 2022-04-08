package main.java.com.alura.challenge.web;

import main.java.com.alura.challenge.interfaces.Content;
import main.java.com.alura.challenge.model.Movie;

import java.io.PrintWriter;
import java.util.List;

public class HtmlGenerator {

    private final PrintWriter printWriter;

    public HtmlGenerator(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public void generate(List<? extends Content> contentList) {

        printWriter.println("""
                 <html>
                      <head>
                <meta charset=\"utf-8\">
                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">
                      </head>
                      
                 <body class="container" style="background-color: #6c7278">
                     <div class="row">
                      """);

        contentList.forEach(movie -> {
            printWriter.println("<div class=\"card text-white bg-dark mb-3 ml-5 col-md-4\" style=\"max-width: 18rem;\">" +
                    "<h4 class=\"card-header\">" + movie.title() + "</h4><div class=\"card-body\">" +
                    "<img class\"card-img\" src=\"" + movie.urlImage() + "alt=\"" + movie.urlImage() + " width=\"200\" height=\"300\">" +
                    "<p class=\"card-text mt-2\">Nota: " + movie.rating() + " - Ano: " + movie.year() + "</p></div></div>");

        });

        printWriter.println(
                """ 
                          </div>
                          </body>
                        </html>
                         """);

    }

}
