package day9LabAssignment.java9;

import java.net.URI;
import java.net.http.*;

public class G_HTTP2Client {
    public static void main(String[] args)  throws Exception{
        HttpClient client = HttpClient.newHttpClient();//The HttpClient in Java 9 defaults to HTTP/2 if the server supports it
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String jsonBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());

        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code: " + response1.statusCode());
        System.out.println("Response Body: " + response1.body());
    }
}


