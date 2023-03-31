import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class Request {
    static String makeRequest(String endpoint) throws IOException {
        try {
            var client = HttpClient.newHttpClient();
            URI uri = URI.create(endpoint);
            var request = HttpRequest.newBuilder(uri).GET().build();
            // the response will be a string
            var response = client.send(request, BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
