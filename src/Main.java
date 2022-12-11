import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String[] buches = {"Buche Chocolat Tradition", "Buche Agrume", "Buche Pommes-Speculos", "Buche Chocolat-Tonka", "Nougat glacé"};
        int nbPersonnes;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Combien de personnes vont voter? : ");
        nbPersonnes = scanner.nextInt();
        int[][] choix = {{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}};
        int indexTab = 0;
        for (int[] i : choix) {
            i[0] = indexTab;
            indexTab++;
        }

        //Pour chaque personne
        for (int i = 1; i < nbPersonnes + 1; i++) {
            //3 choix pour chaque personne
            for (int j = 1; j < 4; j++) {

                int nbPoints = switch (j) {
                    case 1 -> 3;
                    case 2 -> 2;
                    case 3 -> 1;
                    default -> throw new IllegalStateException("Unexpected value: " + j);
                };

                System.out.println("Personne N°" + i + ": Quelle est la buche demandée en N°" + j + "?");
                System.out.println(
                        """
                                1 - Buche Chocolat Tradition\s
                                2 - Buche Agrume\s
                                3 - Buche Pommes-Speculos\s
                                4 - Buche Chocolat-Tonka\s
                                5 - Nougat glacé"""
                );
                int index = scanner.nextInt() - 1;
                choix[index][1] += nbPoints;
            }
        }

        //Traitement sur tableau
        int index = 1;
        System.out.println("**********RESULTATS*********");
        for (int[] i : choix) {
            System.out.println(buches[index - 1] + " : " + i[1] + " points");
            index++;
        }

        //TO DO : sorted array considering equals;


    }
}

