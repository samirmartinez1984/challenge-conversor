package com.alura.samirm;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ApiClient {
    private static final String API_KEY = "2228011b81ffbe65e1375f91d0ec1170";
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public Map<String, Double> obtenerTasasCambio(String monedaBase) throws IOException, InterruptedException {
        String urlConMoneda = API_URL + monedaBase + "?apikey=" + API_KEY;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlConMoneda))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Error en la solicitud a la API. Código de estado: " + response.statusCode());
        }

        Gson gson = new Gson();
        Type jsonMapType = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> jsonMap = gson.fromJson(response.body(), jsonMapType);

        if (!jsonMap.containsKey("rates")) {
            throw new IllegalStateException("La respuesta de la API no contiene la clave 'rates'");
        }

        // Extraer tasas de cambio como Map<String, Double>
        Type tasasType = new TypeToken<Map<String, Double>>(){}.getType();
        Map<String, Double> tasasCambio = gson.fromJson(gson.toJson(jsonMap.get("rates")), tasasType);

        return tasasCambio;
    }
}
