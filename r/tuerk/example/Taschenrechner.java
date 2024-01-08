package r.tuerk.example;
import java.util.Scanner;

public class Taschenrechner {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        EingabeWerte();
        closeScanner();
    }

    public static void EingabeWerte() {

        while (true) {
            System.out.println("Bitte gebe Zahl a an.");
            int a = konsoleneingabeInt();

            System.out.println("Bitte gebe Zahl b an.");
            int b = konsoleneingabeInt();

            System.out.println("Welche funktion Möchtest du benutzen?");

            EingabeFunktion(a, b);
        }
    }

    public static void EingabeFunktion(int a, int b){
        String[] rechenoperationen = {"1) Umfang", "2) Flächeninhalt", "3) Addition", "4) Subtraktion", "5) Division", "6) Multiplikation"};

        for(int i = 0; i < rechenoperationen.length ; i++){
            System.out.println(rechenoperationen[i]);
        }

        Ausgabe(konsoleneingabeInt(),a,b);
    }

    public static void Ausgabe(int funktion, int a, int b){

        switch (funktion){
            case 1:
                System.out.println("Umfang: " + Umfang(a, b));
                break;
            case 2:
                System.out.println("Flächeninhalt: " + Flächeninhalt(a, b));
                break;
            case 3:
                System.out.println("Addition: " + Addition(a, b));
                break;
            case 4:
                System.out.println("Subtraktion: " + Subtraktion(a, b));
                break;
            case 5:
                System.out.println("Division: " + Division(a, b));
                break;
            case 6:
                System.out.println("Multiplikation: " + Multiplikation(a, b));
                break;
            default:
                System.out.println("Die Funktion Existiert nicht bitte gebe eine andere An;");
                EingabeFunktion(a,b);
                break;
        }
    }

    public static int Umfang(int a, int b) {
        return a * 2 + b * 2;
    }
    public static int Flächeninhalt(int a, int b) {
        return a * b;
    }
    public static int Addition(int a, int b) {
        return a + b;
    }
    public static int Subtraktion(int a, int b) {
        return a - b;
    }
    public static int Division(int a, int b) {
        return a / b;
    }
    public static int Multiplikation(int a, int b) {
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