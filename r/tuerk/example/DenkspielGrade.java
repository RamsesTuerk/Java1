package r.tuerk.example;

import java.util.Scanner;

public class DenkspielGrade {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int punkte = 0;
        int misstakes = 0;

        do {

            long zufallszahl = Math.round(Math.random() / (1.0 / (100.0 - 1.0)) + 1.0);

            System.out.println("Ist die Zufalszahl: " + zufallszahl + " 0) Grade oder 1) Ungrade");

            while (true) {
                int playerAwnser = konsoleneingabeInt();

                if (zufallszahl % 2 == playerAwnser) {
                    punkte += 1;
                    break;
                } else if (playerAwnser > 1) {
                    System.out.println("Bitte eine Valide Zahl angeben");
                } else {
                    misstakes += 1;
                    break;
                }
            }

            System.out.println("Du hast " + punkte + " Punkte und " + misstakes + " Fehler!");
        }
        while (misstakes <= 3);

        System.out.println("Du hast Verloren...... Pech gehabt!");

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
