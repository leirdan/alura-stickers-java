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
            System.out.println(item.get("title"));
            System.out.println(item.get("image"));
            System.out.println(item.get("imDbRating"));
            System.out.println();
            /**
             * output:
             * The Shawshank Redemption
             * https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg
             * 9.2
             * 
             * The Godfather
             * https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_2.jpg
             * 9.2
             * 
             * The Dark Knight
             * https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_3.jpg
             * 9.0
             * 
             * The Godfather: Part II
             * https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_4.jpg
             * 9.0
             * 
             * 12 Angry Men
             * https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_5.jpg
             * 8.9
             * 
             * Schindler's List
             * https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_6.jpg
             * 8.9
             * 
             * The Lord of the Rings: The Return of the King
             * https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_7.jpg
             * 8.9
             * 
             * Pulp Fiction
             * https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_8.jpg
             * 8.9
             * 
             * The Lord of the Rings: The Fellowship of the Ring
             * https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_9.jpg
             * 8.8
             * 
             * The Good, the Bad and the Ugly
             * https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_10.jpg
             * 8.8
             */
        }
    }
}
