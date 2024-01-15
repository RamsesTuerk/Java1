package r.tuerk.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Rechenprogramm {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int fullPrice = 0;

        System.out.println("Wie viele Produkte sind im Warenkorb?");
        int ammount = konsoleneingabeInt();
        int[] price = new int[ammount];

        for(int i = 0; ammount > i; i++){
            System.out.println("Bitte gebe den Preis für Produkt Nr" + (i+1) + " an");
            price[i] = konsoleneingabeInt();
        }

        for (int j : price) {
            fullPrice += j;
        }
        System.out.println("Es kostet " + fullPrice + "€!");

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
