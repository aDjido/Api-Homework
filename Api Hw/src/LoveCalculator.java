import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.*;

public class LoveCalculator {

    public static void getLove() {

        String baseUrl= "https://love-calculator.p.rapidapi.com/getPercentage?";
        String name = "fname=John&sname=Alice";
        String apiKey = "963c74c218msh1bb811323f5198dp150282jsneb244a2b1548";
        String urlString = baseUrl+ name;


        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://love-calculator.p.rapidapi.com/getPercentage?fname=John&sname=Alice"))
                    .header("x-rapidapi-key", "963c74c218msh1bb811323f5198dp150282jsneb244a2b1548")
                    .header("x-rapidapi-host", "love-calculator.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            //parsing input stream into a text string.
            JSONObject obj = new JSONObject(response.body());
            //getting first name.
            String firstName = obj.getString("fname");
            //getting second name.
            String secondName = obj.getString("sname");
            //getting compatibility percentage.
            String percentage = obj.getString("percentage");
            //getting the end result.
            String message = obj.getString("result");
            //Printing everything on console
            System.out.println("First name is:" +firstName );
            System.out.println("Second name is:"+secondName);
            System.out.println("The percentage of compatibility:"+ percentage);
            System.out.println("End Message:"+ message);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}


