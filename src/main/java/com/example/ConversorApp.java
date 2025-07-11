package com.example;

import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=> Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida:\n****************************\n> ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: convertir("USD", "ARS", scanner); break;
                case 2: convertir("ARS", "USD", scanner); break;
                case 3: convertir("USD", "BRL", scanner); break;
                case 4: convertir("BRL", "USD", scanner); break;
                case 5: convertir("USD", "COP", scanner); break;
                case 6: convertir("COP", "USD", scanner); break;
                case 7: System.out.println("¡Gracias por usar el conversor!"); break;
                default: System.out.println("Opción no válida.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    private static void convertir(String from, String to, Scanner scanner) {
        System.out.print("Ingrese el monto a convertir: ");
        double monto = scanner.nextDouble();

        double tasa = ExchangeRateService.obtenerTasa(from, to);
        if (tasa != -1) {
            double resultado = monto * tasa;
            System.out.printf("%.2f %s = %.2f %s\n", monto, from, resultado, to);
        } else {
            System.out.println("No se pudo realizar la conversión.");
        }
    }
}
