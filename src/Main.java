import consoCarbonne.*;
import Utilisateur.*;
//import java.io.IOException;
import Erreurs.*;
import java.util.ArrayList;

//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Collection;
import java.util.Scanner;
import java.lang.*;


public class Main {

    //private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ErrValNeg, ErrTx {

        Scanner scan = new Scanner(System.in);
        boolean finSwitch = false;
        int choice;


        // TEST DU POLYMORPHISME //

        System.out.println("Avant d'initialiser votre utilisateur, entrez 1 si vous souhaitez tester le polymorphisme des méthodes, 0 sinon. ");
        do{
            choice = scan.nextInt();
            switch (choice) {
                case (0) -> finSwitch = true;
                case (1) -> {
                    ConsoCarbonne a = new Alimentation();
                    System.out.println(a.toString());
                    // Nous pouvons remarquer que le toString qui s'affiche est bien celui d'une Alimentation (et pas d'une ConsoCarbonne)
                    // Nous pouvons donc déduire que le polymorphisme fonctionne bien.
                    finSwitch = true;
                }
                default ->
                        System.out.println("Choix incorrect.  entrez 1 si vous souhaitez tester le polymorphisme des méthodes, 0 sinon.");
            }
        }while(!finSwitch);



        System.out.println("\n\n");



        // CREATION D'UN PREMIER UTILISATEUR //

        EntreeSortie e = new EntreeSortie();
        System.out.println("Initialisation du premier utilisateur de la population"  + '\n');
        Utilisateur u1 = e.AffichageUtilisateur();





        // AFFICHAGE DE L IMPACT //

        finSwitch = false;
        System.out.println("Entrez 1 si vous souhaitez voir votre impact de consommation carbonne, 0 sinon");
        do {
            choice = scan.nextInt();
            switch (choice) {
                case (0) -> finSwitch = true;
                case (1) -> {
                    System.out.println("L'impact total est de : " + u1.calculerEmpreinte());
                    System.out.println("\n\n");
                    System.out.println("Le détail de l'impact est le suivant : ");
                    u1.detaillerEmpreinte();
                    finSwitch = true;
                }
                default ->
                        System.out.println("Choix incorrect. Entrez 1 si vous souhaitez voir votre impact de consommation carbonne, 0 sinon");
            }
        }while(!finSwitch);

        System.out.println("\n\n");



        // RECOMMANDATIONS //

        finSwitch = false;
        System.out.println("Entrez 1 si vous souhaitez avoir des conseils pour réduire votre consommation carbonne, O sinon");
        do {
            choice = scan.nextInt();
            switch (choice) {
                case (0) -> finSwitch = true;
                case (1) -> {
                    u1.recommandation();
                    finSwitch = true;
                }
                default -> System.out.println("Choix incorrect. Par défaut, nous considérons que vous avez entré 0.");
            }
        }while(!finSwitch);

        System.out.println("\n\n");


        // CREATION DU SECOND UTILISATEUR //

        System.out.println("Initialisation du second utilisateur de la population"  + '\n');
        Utilisateur u2 = e.AffichageUtilisateur();




        // CREATION DE LA POPULATION COMPOSEE DES DEUX UTILISATEURS //

        ArrayList<Utilisateur> liste_utilisateur = new ArrayList();
        liste_utilisateur.add(u1);
        liste_utilisateur.add(u2);
        Population p = new Population(liste_utilisateur);


        // APPLICATION D'UNE MESURE POLITIQUE (ARTICLE 145)

        System.out.println("L'Article 145 (voté en 2020) est un loi interdisant les trajets en Avion ui peuvent se faire en moins de 2h30 en TGV");
        System.out.println("En appliquant cet Article sur la population (composée des deux utilisateurs initialisés précédement, nous allons transformer tous les trajets d'Avion de plus de 600km en trajets de TGV \n");
        System.out.println("Entrez 1 si vous souhaitez appliquer l'Article 145 sur la population, O sinon");
        do {
            choice = scan.nextInt();
            finSwitch = false;
            switch (choice) {
                case (0) -> finSwitch = true;
                case (1) -> {
                    p.Article145();
                    finSwitch = true;
                }
                default ->
                        System.out.println("Choix incorrect. Entrez 1 si vous souhaitez appliquer l'Article 145 sur la population, O sinon");
            }
        }while(!finSwitch);
        System.out.println("\n\n");


        scan.close();



    }


}
