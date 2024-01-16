package r.tuerk.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Rechenprogramm {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        double fullPrice = 0;

        System.out.println("Wie viele Produkte sind im Warenkorb?");
        double ammount = konsoleneingabeInt();
        double[] price = new double[(int) ammount];

        for(int i = 0; ammount > i; i++){
            System.out.println("Bitte gebe den Preis für Produkt Nr" + (i+1) + " an");
            price[i] = konsoleneingabeInt();
        }

        for (double j : price) {
            fullPrice += j;
        }
        System.out.println("Es kostet " + Math.round(fullPrice) + "€!");

    }

    public static double konsoleneingabeInt() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Fehler: Bitte geben Sie eine gültige Ganzzahl ein.");
            }
        }
    }



}
