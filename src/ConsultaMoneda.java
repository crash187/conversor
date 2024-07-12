import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda requestAPI(String base , String interes , double cantidad) throws IOException, InterruptedException {
        URI URL =URI.create( "https://v6.exchangerate-api.com/v6/ac52d87bb2de6544e304dd1a/pair/"+ base + "/" + interes + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URL)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (NullPointerException e) {
                throw new RuntimeException("No encontre la pelicula.");
            }


            }

        }

