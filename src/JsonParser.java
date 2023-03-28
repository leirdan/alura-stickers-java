import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_VALUES_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    // map is an interface to describe an object
    public List<Map<String, String>> parse(String json) {
        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Não encontrou items.");
        }

        String[] items = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> data = new ArrayList<>();

        for (String item : items) {

            Map<String, String> itemValues = new HashMap<>();

            Matcher matcherAttributeJson = REGEX_VALUES_JSON.matcher(item);
            while (matcherAttributeJson.find()) {
                String attribute = matcherAttributeJson.group(1);
                String value = matcherAttributeJson.group(2);
                itemValues.put(attribute, value);
            }

            data.add(itemValues);
        }

        return data;
    }
}
