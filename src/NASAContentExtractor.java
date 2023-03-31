import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NASAContentExtractor implements ContentExtractor {
    public List<Content> extractContent(String json) {
        // 1. extract data from title and url
        var parser = new JsonParser();
        var jsonContent = parser.parse(json);
        // 2. populate a new list and return it
        List<Content> nasaContent = new ArrayList<>();
        for (Map<String, String> content : jsonContent) {
            String title = content.get("title");
            String url = content.get("url");
            var object = new Content(title, url);

            nasaContent.add(object);
        }
        return nasaContent;
    }
}
