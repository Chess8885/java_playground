package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue à la réservation de places de concerts de Justin Bieber");

        String prenom = demanderPrenom(sc);
        String nom = demanderNom(sc);
        int age = demanderAge(sc);
        int nbBillets = demanderNbBillets(sc);
        int prix = 40;
        int total = calculerTotal(nbBillets, prix);
        afficherTotal(total);

        if (age < 12) {
            appliquerReduction(total, 50);
        } else if (age >= 12 && age <= 17) {
            appliquerReduction(total, 30);
        } else if (age >= 60) {
            appliquerReduction(total, 60);
        }
    }

    public static String demanderNom(Scanner sc) {
        System.out.println("Entrer votre nom");
        return sc.nextLine();
    }

    public static String demanderPrenom(Scanner sc) {
        System.out.println("Entrer votre prénom");
        return sc.nextLine();
    }

    public static int demanderAge(Scanner sc) {
        System.out.println("Entrer votre âge");
        return sc.nextInt();
    }

    public static int demanderNbBillets(Scanner sc) {
        System.out.println("Entrer le nombre de billets");
        return sc.nextInt();
    }

    public static int calculerTotal(int nbBillets, int prix) {
        return nbBillets * prix;
    }

    public static void afficherTotal(int total) {
        System.out.println("Le total est de " + total + " euros");
    }

    public static void appliquerReduction(int total, int pourcentage) {
        int reduction = total * pourcentage / 100;
        int totalApresReduction = total - reduction;
        System.out.println("Vous avez un tarif réduit de " + pourcentage + "%");
        afficherTotal(totalApresReduction);
    }
}
