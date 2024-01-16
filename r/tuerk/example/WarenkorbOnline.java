package r.tuerk.example;
import java.util.Scanner;
public class WarenkorbOnline {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double warenkorb = 0;
        int ammount = 0;
        double rabatt = 0;
        double smallesPrice = 0;

        while(true){
            System.out.println("Produkt Hinzufügen!");
            double price = konsoleneingabeInt();

            if(price == 0){ break;}

            warenkorb += price;
            ammount++;

            if(smallesPrice == 0){
                smallesPrice = price;
            }

            if(smallesPrice > price) {
                smallesPrice = price;
            }

            if( warenkorb >= 100 && ammount >= 10){
                rabatt = smallesPrice;
                warenkorb -= rabatt;
            }

            System.out.println("Warenkorb Preis: "+ warenkorb + " Rabatt: " + rabatt + " Menge: " + ammount);
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
