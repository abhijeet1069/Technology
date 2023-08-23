package ch2.statelessServlet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StatelessFactorizerClient {

    public static void main(String[] args) {
        String servletUrl = "http://localhost:8080/your-app-name/your-servlet-name"; // Replace with actual URL

        try {
            URL url = new URL(servletUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Response from servlet: " + response.toString());
            } else {
                System.out.println("Request failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
