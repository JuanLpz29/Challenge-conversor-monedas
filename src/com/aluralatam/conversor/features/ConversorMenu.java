package com.aluralatam.conversor.features;

import java.util.Scanner;

public class ConversorMenu {
    private final CurrencyConverterService service;
    private final Scanner scanner;

    public ConversorMenu(CurrencyConverterService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("************************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println();
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println();
            System.out.print("Elija una opción válida:\n************************************************************\n");

            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("Ingrese el monto a convertir: ");
                double monto = scanner.nextDouble();

                try {
                    String from = obtenerMonedaOrigen(opcion);
                    String to = obtenerMonedaDestino(opcion);
                    double resultado = service.convert(from, to, monto);
                    System.out.printf("%.2f %s son %.2f %s\n\n", monto, from, resultado, to);
                } catch (Exception e) {
                    System.out.println("Error en la conversión: " + e.getMessage());
                }
            } else if (opcion != 7) {
                System.out.println("Opción inválida. Intente nuevamente.\n");
            }

        } while (opcion != 7);

        System.out.println("Gracias por usar el conversor. ¡Hasta pronto!");
    }

    private String obtenerMonedaOrigen(int opcion) {
        return switch (opcion) {
            case 1, 3, 5 -> "USD";
            case 2 -> "ARS";
            case 4 -> "BRL";
            case 6 -> "COP";
            default -> "";
        };
    }

    private String obtenerMonedaDestino(int opcion) {
        return switch (opcion) {
            case 1 -> "ARS";
            case 2 -> "USD";
            case 3 -> "BRL";
            case 4 -> "USD";
            case 5 -> "COP";
            case 6 -> "USD";
            default -> "";
        };
    }
}
