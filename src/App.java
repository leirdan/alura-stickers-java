public class App {
    public static void main(String[] args) throws Exception {
        // 1. get all the movies
        var request = Request
                .makeRequest("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");
        System.out.println(request);
        // 2. collect title, description and image
        var parser = new JsonParser();
        var movies = parser.parse(request);
        System.out.println(movies.get(2));

        // TODO: return the response
    }
}
