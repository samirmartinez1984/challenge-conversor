package com.alura.samirm;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public String ingresarMoneda(String tipo) {
        System.out.print("Ingrese la moneda de " + tipo + " (Ejemplo: USD, EUR, JPY): ");
        return scanner.next().toUpperCase();
    }

    public boolean deseaContinuar() {
        System.out.print("¿Desea realizar otra conversión? (s/n): ");
        String respuesta = scanner.next().trim().toLowerCase();
        return respuesta.equals("s");
    }
}
