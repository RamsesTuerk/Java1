package r.tuerk.example;

import java.util.Scanner;

public class Preisauskunft {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            int barcode = konsoleneingabeInt();

            switch (barcode) {
                case 4613:
                    System.out.println("Bananen für 1,20€");
                    break;
                case 7461:
                    System.out.println("Zahnbürsten für 2,30€");
                    break;
                case 7913:
                    System.out.println("Kartoffel für 0,50€");
                    break;
                default:
                    System.out.println("Die ID ist leider nicht im Systhem");
                    break;
            }
        }
    }

    public static int konsoleneingabeInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Fehler: Bitte geben Sie eine gültige Ganzzahl ein.");
            }
        }
    }



}
