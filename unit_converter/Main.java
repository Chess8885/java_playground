import java.util.Scanner;

public class Convertisseur {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choix;
        do {
            // Affichage du menu
            System.out.println("=== CONVERTISSEUR D'UNITÉS ===");
            System.out.println("1. Longueur");
            System.out.println("2. Masse");
            System.out.println("3. Température");
            System.out.println("0. Quitter");

            System.out.print("Votre choix : ");
            choix = sc.nextLine();

            switch (choix) {
                case "1":
                    convertirLongueur(sc);
                    break;
                case "2":
                    convertirMasse(sc);
                    break;
                case "3":
                    convertirTemperature(sc);
                    break;
                case "0":
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (!choix.equals("0"));
    }

    public static void convertirLongueur(Scanner sc) {
        System.out.println("=== CONVERTISSEUR DE LONGUEUR ===");
        System.out.print("Entrez la valeur : ");
        double valeur = sc.nextDouble();
        sc.nextLine(); // Vider le buffer
        System.out.print("Entrez l'unité d'origine (m, cm, mm, km, mi, yd, ft, in) : ");
        String uniteOrigine = sc.nextLine();
        System.out.print("Entrez l'unité de destination (m, cm, mm, km, mi, yd, ft, in) : ");
        String uniteDestination = sc.nextLine();

        double resultat = convertirLongueur(valeur, uniteOrigine, uniteDestination);
        System.out.println("Résultat : " + resultat + " " + uniteDestination);
    }

    public static double convertirLongueur(double valeur, String uniteOrigine, String uniteDestination) {
        double valeurMetres = 0;
        switch (uniteOrigine) {
            case "m":
                valeurMetres = valeur;
                break;
            case "cm":
                valeurMetres = valeur / 100.0;
                break;
            case "mm":
                valeurMetres = valeur / 1000.0;
                break;
            case "km":
                valeurMetres = valeur * 1000.0;
                break;
            case "mi":
                valeurMetres = valeur * 1609.344;
                break;
            case "yd":
                valeurMetres = valeur * 0.9144;
                break;
            case "ft":
                valeurMetres = valeur * 0.3048;
                break;
            case "in":
                valeurMetres = valeur * 0.0254;
                break;
            default:
                System.out.println("Unité d'origine invalide.");
                break;
        }

        double resultat = 0;
        switch (uniteDestination) {
            case "m":
                resultat = valeurMetres;
                break;
            case "cm":
                resultat = valeurMetres * 100.0;
                break;
            case "mm":
                resultat = valeurMetres * 1000.0;
                break;
            case "km":
                resultat = valeurMetres / 1000.0;
                break;
            case "mi":
                resultat = valeurMetres / 1609.344;
                break;
            case "yd":
                resultat = valeurMetres / 0.9144;
                break;
            case "ft":
                resultat = valeurMetres / 0.3048;
                break;
            case "in":
                resultat = valeurMetres / 0.0254;
                break;
            default:
                System.out.println("Unité de destination invalide.");
                break;
        }

        return resultat;
    }

    public static void convertirMasse(Scanner sc) {
        System.out.println("=== CONVERTISSEUR DE MASSE ===");
        System.out.print("Entrez la valeur : ");
        double valeur = sc.nextDouble();
        sc.nextLine(); // Vider le buffer
        System.out.print("Entrez l'unité d'origine (g, kg, lb, oz) : ");
        String uniteOrigine = sc.nextLine();
        System.out.print("Entrez l'unité de destination (g, kg, lb, oz) : ");
        String uniteDestination = sc.nextLine();

        double resultat = convertirMasse(valeur, uniteOrigine, uniteDestination);
        System.out.println("Résultat : " + resultat + " " + uniteDestination);
    }

    public static double convertirMasse(double valeur, String uniteOrigine, String uniteDestination) {
        double valeurGrammes = 0;
        switch (uniteOrigine) {
            case "g":
                valeurGrammes = valeur;
                break;
            case "kg":
                valeurGrammes = valeur * 1000.0;
                break;
            case "lb":
                valeurGrammes = valeur * 453.59237;
                break;
            case "oz":
                valeurGrammes = valeur * 28.34952;
                break;
            default:
                System.out.println("Unité d'origine invalide.");
                break;
        }

        double resultat = 0;
        switch (uniteDestination) {
            case "g":
                resultat = valeurGrammes;
                break;
            case "kg":
                resultat = valeurGrammes / 1000.0;
                break;
            case "lb":
                resultat = valeurGrammes / 453.59237;
                break;
            case "oz":
                resultat = valeurGrammes / 28.34952;
                break;
            default:
                System.out.println("Unité de destination invalide.");
                break;
        }

        return resultat;
    }

    public static void convertirTemperature(Scanner sc) {
        System.out.println("=== CONVERTISSEUR DE TEMPÉRATURE ===");
        System.out.print("Entrez la valeur : ");
        double valeur = sc.nextDouble();
        sc.nextLine(); // Vider le buffer
        System.out.print("Entrez l'unité d'origine (C, F, K) : ");
        String uniteOrigine = sc.nextLine();
        System.out.print("Entrez l'unité de destination (C, F, K) : ");
        String uniteDestination = sc.nextLine();

        double resultat = convertirTemperature(valeur, uniteOrigine, uniteDestination);
        System.out.println("Résultat : " + resultat + " " + uniteDestination);
    }

    public static double convertirTemperature(double valeur, String uniteOrigine, String uniteDestination) {
        double resultat = 0;
        switch (uniteOrigine) {
            case "C":
                switch (uniteDestination) {
                    case "C":
                        resultat = valeur;
                        break;
                    case "F":
                        resultat = (valeur * 1.8) + 32.0;
                        break;
                    case "K":
                        resultat = valeur + 273.15;
                        break;
                    default:
                        System.out.println("Unité de destination invalide.");
                        break;
                }
                break;
            case "F":
                switch (uniteDestination) {
                    case "C":
                        resultat = (valeur - 32.0) / 1.8;
                        break;
                    case "F":
                        resultat = valeur;
                        break;
                    case "K":
                        resultat = (valeur + 459.67) * (5.0 / 9.0);
                        break;
                    default:
                        System.out.println("Unité de destination invalide.");
                        break;
                }
                break;
            case "K":
                switch (uniteDestination) {
                    case "C":
                        resultat = valeur - 273.15;
                        break;
                    case "F":
                        resultat = (valeur * (9.0 / 5.0)) - 459.67;
                        break;
                    case "K":
                        resultat = valeur;
                        break;
                    default:
                        System.out.println("Unité de destination invalide.");
                        break;
                }
                break;
            default:
                System.out.println("Unité d'origine invalide.");
                break;
        }
        return resultat;
    }
}
