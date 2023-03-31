import java.awt.Color;
import java.awt.Font;

public class App {
    public static void main(String[] args) throws Exception {
        String endpoint = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-12";
        try {
            // 1. get all the movies
            var json = Request.makeRequest(endpoint);
            var extractor = new NASAContentExtractor();
            var content = extractor.extractContent(json);
            // 3. return the response
            for (int i = 0; i < 1; i++) {
                Content con = content.get(i);
                String outfile = "public/" + con.getTitle() + ".png";
                // create a new sticker for every item
                StickerFactory.createSticker(con.getUrl(), outfile,
                        "my pussy taste like pepsi cola",
                        Font.SANS_SERIF,
                        Font.BOLD,
                        24, Color.pink);
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
        }
    }
}
