import java.awt.Color;
import java.awt.Font;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // 1. get all the movies
        var request = Request
                .makeRequest("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");
        System.out.println(request);
        // 2. collect title, description and rating
        var parser = new JsonParser();
        var movies = parser.parse(request);
        System.out.println(movies.get(2));

        // 3. return the response
        for (Map<String, String> item : movies) {
            String url = item.get("image");
            String outfile = item.get("title") + ".png";
            // create a new sticker for every item
            StickerFactory.createSticker(url, outfile, "CHUU DA LOONA", Font.SANS_SERIF, Font.BOLD,
                    24, Color.green);
        }
    }
}
