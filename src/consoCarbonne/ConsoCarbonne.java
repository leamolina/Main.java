/**
 * Ce package permet de regrouper les differentes classes représentant differents poste de consommation carbone.
 */
package consoCarbonne;

import Erreurs.ErrValNeg;

/**
 * La classe ConsoCarbonne represente un poste de consommation carbone generique.
 * Elle est la classe mere de toutes les autres.
 * C'est elle qui nous donne l'empreinte carbone de chaque objet qu'utilise un Francais en fonction de son mode de vie.
 */
public abstract class ConsoCarbonne implements Comparable<ConsoCarbonne>  {


    //Constructeur
    public ConsoCarbonne() throws ErrValNeg {
        ConsoCarbonne.counter += 1;
        setId(ConsoCarbonne.counter);
    }
    private double impact = 0 ;
    private int id = 0;
    private static int counter = 0;

    //Getters

    /**
     * @return l'ID correspondant a un identifiant unique attribue a l'instance ConsoCarbonne.
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return L'impact de chaque poste de consommation.
     */
    public double getImpact() {
        return impact;
    }

    /**
     * Methode permettant de verifier que l'ID existe et de le fixer.
     * @param counter est un compteur qui permet d'incrementer l'ID
     */

    //Setters
    public void setId(int counter) throws ErrValNeg {
        if(counter<0) throw new ErrValNeg("La valeur ID n'est pas possible, elle ne peut pas être négative. Fin du programme.");
        else this.id = counter;
    }

    /**
     *Methode permerttant de fixer l'impact
     * @param impact represente l'empreinte carbonne d'une ConsoCarbonne
     */
    public void setImpact(double impact) {
        this.impact = impact;
    }


    /**
     * @return une chaine contenant les informations de la classe ConsoCarbonne en affichant l'ID  attribue a l'instance ConsoCarbonne associe ainsi que son impact
     */
    @Override
    public String toString() {
        return "ConsoCarbonne{" +
                "id=" + id +
                ", impact=" + impact +

                "}";
    }

    /**
     * @param c est l'objet a comparer.
     * @return -1 si la valeur placee en argument est inferieur a c, 0 si elles sont egales, 1 sinon
     */
    @Override
    public int compareTo(ConsoCarbonne c) {
        return Double.compare(this.impact, c.impact);
    }
}
