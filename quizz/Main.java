import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Questionnaire {

    // Méthode pour lire le fichier texte
    public static ArrayList<String[]> lireFichier(String nomFichier) {
        ArrayList<String[]> questions = new ArrayList<>();
        try {
            BufferedReader lecteur = new BufferedReader(new FileReader(nomFichier));
            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                String[] elements = ligne.split(",");
                questions.add(elements);
            }
            lecteur.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    public static void main(String[] args) {
        // Lecture du fichier texte
        ArrayList<String[]> questions = lireFichier("questions.txt");
        int score = 0; // Initialisation du score

        // Boucle pour afficher les questions et les choix de réponse
        for (int i = 0; i < questions.size(); i++) {
            String[] question = questions.get(i);
            System.out.println((i + 1) + ". " + question[0]);
            for (int j = 1; j < 4; j++) {
                System.out.println("   " + j + ") " + question[j]);
            }

            // Lecture de la réponse de l'utilisateur
            Scanner sc = new Scanner(System.in);
            String reponse;
            boolean isInteger = false;
            do {
                System.out.print("Votre réponse: ");
                reponse = sc.nextLine().trim(); // Supprimer les espaces blancs
                try {
                    // Essayer de convertir la réponse en entier
                    Integer.parseInt(reponse);
                    isInteger = true;
                } catch (NumberFormatException e) {
                    // Si la réponse n'est pas un entier, isInteger reste à false
                }

                if (isInteger) {
                    System.out.println("La réponse doit être une chaîne de caractères, pas un entier.");
                }
            } while (isInteger);

            // Vérification de la réponse
            if (reponse.equalsIgnoreCase(question[4].trim())) {
                System.out.println("Bonne réponse !");
                score++; // Incrémenter le score
            } else {
                System.out.println("Mauvaise réponse...");
                System.out.println("La réponse correcte est : " + question[4].trim());
            }
        }

        // Affichage du score final de l'utilisateur
        System.out.println("Votre score final est : " + score + "/" + questions.size());
    }
}
