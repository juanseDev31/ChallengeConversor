package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExchangeRateService {
    private static final String API_KEY = "750e08b35416d9888cd49a98";  // aqui esta mi api key
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static double obtenerTasa(String from, String to) {
        try {
            String urlStr = BASE_URL + API_KEY + "/pair/" + from + "/" + to;
            URL url = new URL(urlStr);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            JsonObject json = JsonParser.parseString(response.toString()).getAsJsonObject();
            return json.get("conversion_rate").getAsDouble();

        } catch (Exception e) {
            System.out.println("Error al obtener la tasa: " + e.getMessage());
            return -1;
        }
    }
}
