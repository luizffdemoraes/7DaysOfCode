package main.java.com.alura.challenge.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ImdbClient {

    String apiKey; // <apiKey>

    public ImdbClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String callIMDB() {

        // HttpResponse é o retorno da requisicao
        try {

            // O construtor pode ser usado para configurar o estado por cliente
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .build();

            // O construtor para configurar o corpo da requisição
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + this.apiKey))
                    .timeout(Duration.ofMinutes(1))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

            // Utilizado para não return statement
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
