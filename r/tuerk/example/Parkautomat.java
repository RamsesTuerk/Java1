package r.tuerk.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Parkautomat {

    public static final double gebuehr = 1.25;
    public static final double dreissigMin = 1.5;
    public static final double parkZeit = 30;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();
        closeScanner();
    }

    public static void start() {
        LocalDateTime startTime;
        LocalDateTime endTime;
        double preis;

        System.out.println("Willst du jetzt ein Parkschein ziehen?");
        System.out.println("1) Ja");
        System.out.println("2) Nein");


        while (true) {
            int decision = konsoleneingabeInt();

            if (decision == 1) {
                System.out.println("Die Uhr läuft!");
                startTime = getTime();
                break;
            } else if (decision == 2) {
                System.out.println("Dann Frage ich noch mal!!");
            } else {
                System.out.println("Ja oder Nein?");
            }
        }

        System.out.println("Willst du Gehen?");
        System.out.println("1) Ja");
        System.out.println("2) Nein");


        while (true) {
            int decision = konsoleneingabeInt();
            if (decision == 1) {
                endTime = getTime();
                break;
            } else if (decision == 2) {
                System.out.println("Dann komm später wieder!!");
            } else {
                System.out.println("Ja oder Nein?");
            }
        }

        preis = kostenRechner(startTime, endTime);
        bezahlen(preis);
    }

    private static void bezahlen(double preis) {
        String[] rechenoperationen = {"1) 0.05€", "2) 0.10€", "3) 0.20€", "4) 0.50€", "5) 1.00€", "6) 2.00€"};
        double restbetrag = preis;

        for (String s : rechenoperationen) {
            System.out.println(s);
        }
        System.out.println();

        while (true) {
            System.out.println("Restbetrag: " + restbetrag);
            if (restbetrag > 0) {
                int decision = konsoleneingabeInt();
                switch (decision) {
                    case 1:
                        restbetrag = (double) Math.round((restbetrag - 0.05) * 100) / 100;
                        break;
                    case 2:
                        restbetrag = (double) Math.round((restbetrag - 0.10) * 100) / 100;
                        break;
                    case 3:
                        restbetrag = (double) Math.round((restbetrag - 0.20) * 100) / 100;
                        break;
                    case 4:
                        restbetrag = (double) Math.round((restbetrag - 0.50) * 100) / 100;
                        break;
                    case 5:
                        restbetrag = (double) Math.round((restbetrag - 1.00) * 100) / 100;
                        break;
                    case 6:
                        restbetrag = (double) Math.round((restbetrag - 2.00) * 100) / 100;
                        break;
                    default:
                        System.out.println("Dies ist keine Gültige Münze!");
                        break;
                }
            } else {
                System.out.println("vielen Dank dein Wechselgeld beträgt: " + (restbetrag * -1) + "€");
                break;
            }
        }

    }

    private static double kostenRechner(LocalDateTime startTime, LocalDateTime endTime) {
        double minutes = ChronoUnit.SECONDS.between(startTime, endTime); /// Eigentlich Minuten zum Testen Sekunden

        return (gebuehr + Math.ceil((minutes+1) / parkZeit) * dreissigMin); // + 1 um bei der 0 min 0 sec +1 zu rechnen. ungenauigkeit von 1 Sekunde anstatt 1 min
    }

    private static LocalDateTime getTime() {
        return LocalDateTime.now();
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
