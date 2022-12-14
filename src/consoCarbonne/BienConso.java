package consoCarbonne;
import Erreurs.*;

/**
 * La classe BienConso represente l'impact de chaque depenses en fonction du montant des depenses annuelles de l'utilisateur.
 * Nous avons suppose qu'une tonne de CO2eq est equivalente a 1750 euros de depenses.
 */
public class BienConso extends ConsoCarbonne{

    //Constructeur
    public BienConso() throws ErrValNeg {
        super();
    }

    /**
     * @param montant represente le montant des depenses annuelles.
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    public BienConso(double montant) throws ErrValNeg {
        setMontant(montant);
        setCalculImpact();
    }
    private double montant = 0.0;

    //Getters
    /**
     * @return Le montant des depenses annuelles de l'utilsateur.
     */
    public double getMontant() {
        return montant;
    }

    //Setters
    /**
     * Methode permettant de verifier que le montant est bien positif et de le fixer.
     * @param montant represente le montant annuel des depenses.
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    public void setMontant(double montant) throws ErrValNeg {
        if( montant < 0) throw new ErrValNeg ("Erreur : le montant ne peut etre negatif. Fin du programme.");
        else {
            this.montant = montant;
            setCalculImpact();
        }
    }

    /**
     * Methode permettant de calculer l'impact des depenses de l'utilisateur, avec l'hypothese qu’une tonne de CO2eq est equivalente à 1750€ de dépenses.
     */
    public void setCalculImpact (){
        super.setImpact((1.0/1750.0)*this.montant);
    }

    /**
     * Methode detaillant l'empreinte carbonne moyenne d un francais de chaque depenses de l'utilisateur.
     */
    public static void EmpreinteBienConso(){
        int habillement = 763;
        int autres = 682 ;
        int achatInternetTech = 1180;
        int sum = habillement + autres + achatInternetTech;
        System.out.println("Details de l empreinte carbonne moyenne d'un francais (BienConso) : ");
        System.out.println("Habillement : " + habillement);
        System.out.println("Autres biens et services : " + autres);
        System.out.println("Achats et usages Internet et technologies: " + achatInternetTech);
        System.out.println("Somme: " + sum + "\n");
    }

    /**
     * @return Une chaine contenant les informations sur la classe BienConso en indiquant le montant des depenses annuelles.
     */
    @Override
    public String toString() {
        return "BienConso{" +
                "montant=" + montant +
                "  " +super.toString() +
                "}\n";
    }
}
