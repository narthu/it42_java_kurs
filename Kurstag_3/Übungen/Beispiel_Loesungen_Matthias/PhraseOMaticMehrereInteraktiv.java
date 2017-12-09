import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PhraseOMaticMehrereInteraktiv {

    private static List<String> liesWoerterAusDatei(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        PhraseOMaticMehrereInteraktiv.class.getClassLoader().
                                getResourceAsStream(filename)));
        List<String> words = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            words.add(line);
        }
        return words;
    }


    public static void main(String[] args) throws IOException {
        // drei Wortgruppen erstellen, aus denen ausgew�hlt wird
        List<String> wortListeEins = liesWoerterAusDatei("wortliste1.txt");

        List<String> wortListeZwei = liesWoerterAusDatei("wortliste2.txt");

        List<String> wortListeDrei = liesWoerterAusDatei("wortliste3.txt");

        // ermitteln, wie viele Worte sich in jeder Liste befinden
        int einsL�nge = wortListeEins.size();
        int zweiL�nge = wortListeZwei.size();
        int dreiL�nge = wortListeDrei.size();

        // drei Zufallszahlen generieren, um W�rter aus den Listen herauszuziehen

        BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println();
            System.out.println("Wieviele Phrasen soll ich labern? (0 = Abbruch)");
            String eingabe = inReader.readLine();
            int anzahlPhrasen = Integer.parseInt(eingabe);
            if (anzahlPhrasen == 0) {
                break;
            }
            for (int i = 0; i < anzahlPhrasen; i++) {
                int rand1 = (int) (Math.random() * einsL�nge);
                int rand2 = (int) (Math.random() * zweiL�nge);
                int rand3 = (int) (Math.random() * dreiL�nge);

                // eine Phrase zusammenbauen
                String phrase = wortListeEins.get(rand1) + " " + wortListeZwei.get(rand2) + " " + wortListeDrei.get(rand3);

                // eine Phrase ausgeben
                System.out.println("Was wir brauchen ist eine " + phrase);
            }
        }
    }
}   

