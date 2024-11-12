package com.alura.samirm;

public class Moneda {
    private final String codigo;
    private final double tasaCambio;

    public Moneda(String codigo, double tasaCambio) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código de la moneda no puede estar vacío.");
        }
        if (tasaCambio <= 0) {
            throw new IllegalArgumentException("La tasa de cambio debe ser mayor que cero.");
        }
        this.codigo = codigo;
        this.tasaCambio = tasaCambio;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    @Override
    public String toString() {
        return "Moneda{" + "codigo='" + codigo + '\'' + ", tasaCambio=" + tasaCambio + '}';
    }
}
