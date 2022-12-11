import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        int nbPersonnes;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Combien de personnes vont voter? : ");
        nbPersonnes = scanner.nextInt();
        int[] choix = new int[5];
        System.out.println("nombre de votants : " + nbPersonnes + "\n");

        //Pour chaque personne
        for (int i = 1; i < nbPersonnes + 1; i++) {
            //3 choix pour chaque personne
            for (int j = 1; j < 4; j++) {
                System.out.println("valeur j : " + j + "\n");

                int nbPoints = switch (j) {
                    case 1 -> 3;
                    case 2 -> 2;
                    case 3 -> 1;
                    default -> throw new IllegalStateException("Unexpected value: " + j);
                };

                System.out.println("Personne N°" + i + ": Quelle est la buche demandée en N°" + j + "?");
                System.out.println(
                        """
                                1 - Bunche Chocolat Tradition\s
                                2 - Buche Agrume\s
                                3 - Buche Pommes-Speculos\s
                                4 - Buche Chocolat-Tonka\s
                                5 - Nougat glacé"""
                );
                int index = scanner.nextInt() - 1;
                choix[index] += nbPoints;
            }
        }
        //Traitement sur tableau
        System.out.println("tableau : " + Arrays.toString(choix));

        int choix1 = 0;
        int choix2 = 0;
        int choix3 = 0;

        int index = 0;
        for (int i : choix) {
            if (i > choix3) choix3 = i;
            else if (i > choix2) choix2 = i;
            else if (i > choix1) choix1 = i;
        }
    }
}