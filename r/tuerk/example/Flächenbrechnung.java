package r.tuerk.example;

import java.util.Scanner;

public class Flächenbrechnung {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        EinAusgabe();
        closeScanner();
    }

    public static void EinAusgabe(){

        System.out.println("Bitte gebe a an.");
        int a = konsoleneingabeInt();

        System.out.println("Bitte gebe b an.");
        int b = konsoleneingabeInt();

        System.out.println("Flächeninhalt: " + Flächeninhalt(a,b) + "  Umfang: " + Umfang(a,b));
    }

    public static int Umfang(int a, int b){
        return a*2 + b*2;
    }

    public static int Flächeninhalt(int a, int b){
        return a * b;
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

    public static void closeScanner() {
        scanner.close();
    }
}