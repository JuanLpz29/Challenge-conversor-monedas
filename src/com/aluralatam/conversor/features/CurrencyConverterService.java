package com.aluralatam.conversor.features;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class CurrencyConverterService {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private final String apiKey;
    private final HttpClient client;
    private final Gson gson;

    public CurrencyConverterService(String apiKey) {
        this.apiKey = apiKey;
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public double convert(String from, String to, double amount) throws IOException, InterruptedException {
        String url = BASE_URL + apiKey + "/latest/" + from;
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ExchangeRateResponse data = gson.fromJson(response.body(), ExchangeRateResponse.class);

        if (!"success".equals(data.getResult())) {
            throw new RuntimeException("Error en la respuesta de la API");
        }

        Double rate = data.getConversionRates().get(to);
        if (rate == null) {
            throw new IllegalArgumentException("Moneda destino no encontrada: " + to);
        }

        return amount * rate;
    }
}