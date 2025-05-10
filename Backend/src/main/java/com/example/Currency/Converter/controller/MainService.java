package com.example.Currency.Converter.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class MainService {

    public String convert(String from, String to, String amount) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String urlString = "https://api.frankfurter.dev/v1/latest?base=" + from + "&symbols=" + to +"&amount=" + amount;

        // Make the GET request and map response to ApiResponse
//        ResponseEntity<ApiResponse> response = restTemplate.getForEntity(urlString, ApiResponse.class);
        ResponseEntity<ApiResponse> response = restTemplate.exchange(urlString, HttpMethod.GET, null, ApiResponse.class);

        ApiResponse apiResponse = response.getBody();
        System.out.println("Base: " + apiResponse.getBase());
        System.out.println("Amount: " + apiResponse.getAmount());

        // Print each rate dynamically
        Map<String, Double> rates = apiResponse.getRates();
        if (rates != null) {
            for (Map.Entry<String, Double> entry : rates.entrySet()) {
                String currency = entry.getKey();
                Double rate = entry.getValue();
                System.out.println("Currency: " + currency + ", Rate: " + rate);
                return currency + ": " + rate;
            }
        }
        return null;
    }
}







