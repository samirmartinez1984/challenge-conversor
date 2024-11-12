package com.alura.samirm;

import java.io.IOException;
import java.util.Map;

public class ConversorMoneda {
    private final ApiClient apiClient;
    public Map<String, Double> tasasCambio;
    public Menu menu;



    public ConversorMoneda() {
        apiClient = new ApiClient();
        menu = new Menu();
    }

    public void actualizarTasasCambio(String monedaBase) throws IOException, InterruptedException {
        tasasCambio = apiClient.obtenerTasasCambio(monedaBase);
        System.out.println("Tasas de cambio disponibles: " + tasasCambio);
    }

    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        Double tasaOrigen = tasasCambio.get(monedaOrigen);
        Double tasaDestino = tasasCambio.get(monedaDestino);

        if (tasaOrigen == null || tasaDestino == null) {
            throw new IllegalArgumentException("Moneda no encontrada en las tasas de cambio disponibles.");
        }

        return (cantidad / tasaOrigen) * tasaDestino;
    }

    public String seleccionarMonedaOrigen() {
        return menu.ingresarMoneda("origen");
    }

    public String seleccionarMonedaDestino() {
        return menu.ingresarMoneda("destino");
    }
}


