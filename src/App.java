public class App {
    public static void main(String[] args) throws Exception {
        // 1. get all the movies
        var request = Request
                .makeRequest("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");
        System.out.println(request);
        // TODO: collect title, description and image

        // TODO: return the response
    }
}
