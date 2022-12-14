package consoCarbonne;
import Erreurs.*;

/**
 * La classe Alimentation represente l'empreinte carbonne moyenne de l'alimentation d'un Francais en fonction du taux de repas a base de boeuf, et le taux de repas vegetariens.
 * Cette empreinte carbonne est calculée selon la formule suivante: 8 × txBoeuf + 1.6 × (1 − txVege − txBoeuf) + 0.9 × txVege (selon l’hypothèse qu’un repas ni végétarien, ni à base de boeuf est à base de volaille).
 */
public class Alimentation extends ConsoCarbonne {

    //Constructeur par défaut
    public Alimentation() throws ErrValNeg {
        super();
    }

    /**
     * @param txBoeuf  represente le taux de repas a base de boeuf par repas
     * @param txVege  represente le taux de repas a base de legumes par repas
     * @throws ErrTx Exception en cas de taux non compris entre 0 et 1.
     * @throws ErrSommeTx Exception en cas de somme de taux non egale a 1.
     */
    public Alimentation(double txBoeuf, double txVege) throws ErrTx, ErrSommeTx, ErrValNeg {
        super();
        if(txBoeuf + txVege >1) {
            throw new ErrSommeTx("Erreur : la somme des taux doit être comprise entre 0 et 1. Fin du programme. ");
        }
        else{
            setTxBoeuf(txBoeuf);
            setTxVege(txVege);
            setTxVolaille(txBoeuf, txVege);
            setCalculImpact();
        }
    }
    private double txBoeuf = 0.0;
    private double txVege = 0.0;
    private double txVolaille = 0.0;

    //Setters
    /**
     * Methode permettant de verifier que le taux de repas a base de boeuf est bien compris entre 0 et 1 et de le fixer.
     * @param tb represente le taux de repas a base de boeuf
     * @throws ErrTx Exception en cas de taux non compris entre 0 et 1.
     */
    public void setTxBoeuf (double tb) throws ErrTx, ErrSommeTx{
        if(tb + this.txVege > 1) {
            throw new ErrSommeTx("Erreur : la somme des taux doit être comprise entre 0 et 1. Fin du programme. ");
           }
        else {
            if (tb >= 0 && tb <= 1) {
                this.txBoeuf = tb;
                setTxVolaille(tb, this.txVege);
                setCalculImpact();
            } else throw new ErrTx("Erreur : le taux de repas a base de boeuf doit etre compris entre 0 et 1. Fin du programme.");

        }
    }

    /**
     * Methode permettant de verifier que le taux de repas vegetariens est bien compris entre 0 et 1 et de le fixer.
     * @param tv represente le taux de repas a base de volaille
     * @throws ErrTx Exception en cas de taux non compris entre 0 et 1.
     */
    public void setTxVege (double tv)throws ErrTx, ErrSommeTx{
        if(tv + this.txBoeuf > 1) {
            throw new ErrSommeTx("Erreur : la somme des taux doit être comprise entre 0 et 1. Fin du programme. ");
        }
        else {
            if (tv >= 0 && tv <= 1) {
                this.txVege = tv;
                setTxVolaille(this.txBoeuf, tv);
                setCalculImpact();
            } else throw new ErrTx("Erreur : le taux de repas a base de legumes doit etre compris entre 0 et 1. Fin du programme.");

        }
    }

    /**
     * Methode permettant de calculer le taux de repas a base de volaille.
     * @param tb  represente le taux de repas a base de boeuf
     * @param tv  represente le taux de repas a base de legumes
     * @throws ErrTx Exception en cas de taux non compris entre 0 et 1.
     */
    public void setTxVolaille (double tb, double tv)throws ErrTx{
        if((tb + tv) == 1) {
            this.txVolaille = 0.0;
            setCalculImpact();
        }
        else {
            double tVo = 1.0 - tb - tv;
            if (tVo >= 0 && tVo <= 1) {
                this.txVolaille = tVo;
                setCalculImpact();
            }
            else throw new ErrTx("Erreur : le taux de repas à base de volaille doit etre compris entre 0 et 1. Fin du programme.");
        }

    }

    /**
     * Methode permettant de calculer l'impact avec la formule: 8 × txBoeuf + 1.6 × (1 − txVege − txBoeuf) + 0.9 × txVege
     */
    public void setCalculImpact (){
        double cst1 = 8.0;
        double cst2 = 1.6;
        double cst3 = 0.9;
        super.setImpact(cst1 * this.txBoeuf + cst2 * (1 - this.txVege - this.txBoeuf) + cst3 * this.txVege);
    }

    //Getters

    /**
     * @return  Le taux de repas a base de boeuf
     */
    public double getTxBoeuf (){
        return this.txBoeuf;
    }

    /**
     * @return Le taux de repas vegetariens
     */
    public double getTxVege (){
        return this.txVege;
    }

    /**
     * Le taux de repas a base de volaille a ete calculer avec la formule suivante: taux de repas a base de volaille = 1 - taux de repas a base de boeuf - taux de repas vegetariens
     * @return Le taux de repas a base de volaille
     */
    public double getTxVolaille (){
        return this.txVolaille;
    }


    /**
     * Methode detaillant l'empreinte carbonne moyenne d'un Francais dans le domaine de l'alimentation.
     */
    public static void EmpreinteAlimentation(){
        int viandePoisson = 1144;
        int produitsLaitiersOeuf = 408;
        int boissons = 263;
        int autres = 538 ;
        int sum = viandePoisson + produitsLaitiersOeuf + boissons + autres;
        System.out.println("Details de l empreinte carbonne moyenne d un francais (Alimentation) : ");
        System.out.println("Viande et Poisson : " + viandePoisson);
        System.out.println("Produits laitiers et oeuf : " + produitsLaitiersOeuf);
        System.out.println("Boissons : " + boissons);
        System.out.println("Autres : " + autres);
        System.out.println("Somme: " + sum + "\n");
    }

    /**
     * @return Une chaine contenant les informations sur la classe Alimentation.
     */
    @Override
    public String toString() {
        return "Alimentation{" +
                "txBoeuf=" + txBoeuf +
                ", txVege=" + txVege +
                ", txVolaille=" + txVolaille +
                " " + super.toString() +
                "}\n";
    }
}
