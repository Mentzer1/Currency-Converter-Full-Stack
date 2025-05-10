package com.example.Currency.Converter.controller;

import org.springframework.cache.annotation.Cacheable;

import java.util.Map;


public class ApiResponse {
    private String base;
    private Map<String, Double> rates; // Changed to Map to handle dynamic currency codes
    private double amount;

    public ApiResponse(String base, Map<String, Double> rates, double amount) {
        this.base = base;
        this.rates = rates;
        this.amount = amount;
    }

    public ApiResponse() {
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "base='" + base + '\'' +
                ", rates=" + rates +
                ", amount=" + amount +
                '}';
    }
}
