import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("=== CONVERSOR DE MONEDAS ===");

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Ver historial");
            System.out.println("3. Actualizar tasas");
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");

            String option = scanner.nextLine();

            try {
                switch (option) {
                    case "1":
                        convertCurrency(scanner, converter);
                        break;
                    case "2":
                        converter.showHistory();
                        break;
                    case "3":
                        converter.updateRates();
                        System.out.println("Tasas actualizadas!");
                        break;
                    case "4":
                        System.out.println("Adiós!");
                        return;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    private static void convertCurrency(Scanner scanner, CurrencyConverter converter) {
        System.out.println("\nMonedas disponibles: USD, EUR, GBP, JPY, ARS, BOB, BRL, CLP, COP");

        System.out.print("Moneda origen (ej. USD): ");
        String from = scanner.nextLine().toUpperCase();

        System.out.print("Moneda destino (ej. EUR): ");
        String to = scanner.nextLine().toUpperCase();

        System.out.print("Cantidad a convertir: ");
        double amount = Double.parseDouble(scanner.nextLine());

        try {
            double result = converter.convert(from, to, amount);

            // Mostrar siempre con 2 decimales
            System.out.printf("\nResultado: %.2f %s = %.2f %s%n",
                    amount, from,
                    result, to);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}