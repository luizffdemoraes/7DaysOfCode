package main.java.com.alura.challenge.oneday;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.*;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ImdbApplication {

    public static void main(String[] args) throws IOException, InterruptedException {

        // O construtor pode ser usado para configurar o estado por cliente
        HttpClient client = HttpClient.newBuilder()
                .version(Version.HTTP_2)
                .build();

        // O construtor para configurar o corpo da requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/<apiKey>"))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        // HttpResponse é o retorno da requisicao
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

    }
}
