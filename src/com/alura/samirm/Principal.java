package com.alura.samirm;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConversorMoneda conversor = new ConversorMoneda();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Seleccione la moneda base. (Ejemplo: USD): ");
            String monedaBase = scanner.next().toUpperCase();
            conversor.actualizarTasasCambio(monedaBase);


            boolean continuar = true;
            while (continuar) {
                String monedaOrigen = conversor.seleccionarMonedaOrigen();
                String monedaDestino = conversor.seleccionarMonedaDestino();

                System.out.print("Ingrese la cantidad en " + monedaOrigen + ": ");
                double cantidad = scanner.nextDouble();

                try {
                    double cantidadConvertida = conversor.convertir(monedaOrigen, monedaDestino, cantidad);
                    System.out.println(cantidad + " " + monedaOrigen + " son " + cantidadConvertida + " " + monedaDestino);
                } catch (IllegalArgumentException e) {
                    System.err.println("Error en la conversión: " + e.getMessage());
                }

                continuar = conversor.menu.deseaContinuar();
            }

            System.out.println("Gracias por usar el conversor de monedas.");
            System.out.println("**********************************************");

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al obtener las tasas de cambio: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
