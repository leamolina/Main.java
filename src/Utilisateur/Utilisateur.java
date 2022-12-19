package Utilisateur;
import consoCarbonne.*;

import java.io.Serializable;
import java.util.*;

public class Utilisateur implements Serializable {

    public Utilisateur(){}

    /**
     * @param alimentation 
     * @param bienConso
     * @param collection_logement
     * @param collection_voiture
     * @param collection_avion
     * @param collection_bus
     * @param collection_tgv
     * @param service
     */

    //Constructeur :
    public Utilisateur(Alimentation alimentation, BienConso bienConso, Collection<Logement> collection_logement, Collection<Voiture> collection_voiture,Collection<Avion> collection_avion, Collection<Bus> collection_bus, Collection<TGV> collection_tgv, ServicesPublic service) {
        setAlimentation(alimentation);
        setBienConso(bienConso);
        setCollection_logement(collection_logement);
        setCollection_voiture(collection_voiture);
        setCollection_avion(collection_avion);
        setCollection_bus(collection_bus);
        setCollection_tgv(collection_tgv);
        setService(service);
    }

    private Alimentation alimentation;
    private BienConso bienConso;

    private Collection<Logement> collection_logement;
    private Collection<Voiture> collection_voiture;
    private Collection<Avion> collection_avion;
    private Collection<Bus> collection_bus;
    private Collection<TGV> collection_tgv;
    private ServicesPublic service;


    //Setters :

    /**
     * @param alimentation 
     */
    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }

    /**
     * @param bienConso 
     */
    public void setBienConso(BienConso bienConso) {
        this.bienConso = bienConso;
    }

    /**
     * @param collection_logement
     */
    public void setCollection_logement(Collection<Logement> collection_logement) {
        this.collection_logement = collection_logement;
    }


    /**
     * @param collection_voiture
     */
    public void setCollection_voiture(Collection<Voiture> collection_voiture) {
        this.collection_voiture = collection_voiture;

    }
    /**
     * @param collection_avion
     */
    public void setCollection_avion(Collection<Avion> collection_avion) {
        this.collection_avion = collection_avion;

    }

    /**
     * @param collection_bus
     */
    public void setCollection_bus(Collection<Bus> collection_bus) {
        this.collection_bus = collection_bus;
    }

    /**
     * @param collection_tgv
     */
    public void setCollection_tgv(Collection<TGV> collection_tgv) {
        this.collection_tgv = collection_tgv;

    }

    /**
     * @param service 
     */
    public void setService(ServicesPublic service) {
        this.service = service;
    }


    /**
     * @return Le poste de consommation carbone de l'utilisateur.rice concernant son alimentation.
     */
    //Getters :
    public Alimentation getAlimentation() { return this.alimentation; }

    /**
     * @return Le poste de consommation carbone de l'utilisateur.rice concernant ses depenses en biens de consommation.
     */
    public BienConso getBienConso() {return this.bienConso; }

    /**
     * @return Le poste de consommation carbone de l'utilisateur.rice concernant son logement.
     */
    public Collection<Logement> getCollection_logement() { return this.collection_logement; }

    /**
     * @return Le poste de consommation carbone de l'utilisateur.rice concernant ses deplacements.
     */
    public Collection<Voiture> getCollection_voiture() { return this.collection_voiture; }
    public Collection<Avion> getCollection_avion() { return this.collection_avion; }
    public Collection<Bus> getCollection_bus() { return this.collection_bus; }

    public Collection<TGV> getCollection_tgv() { return this.collection_tgv; }

    /**
     * @return Le poste de consommation carbone de l'utilisateur.rice concernant son utilisation des services publics.
     */
    public ServicesPublic getService() { return this.service; }



    /**
     * Methode qui calcule la somme de tous les impacts des differentes logements  de la liste de logements.
     * @param collection_logement
     * @return La somme de tous les impacts des differentes logements  de la liste de logements.
     */

    public double calculImpactLogement (Collection<Logement> collection_logement){
        double somme = 0.0;
        for (Logement l : collection_logement){
            somme += l.getImpact();
        }
        return (somme);
    }

    /**
     * Methode qui calcule la somme de tous les impacts des differentes voitures  de la liste de voitures.
     * @param collection_voiture
     * @return La somme de tous les impacts des differentes voitures  de la liste de voitures.
     */
    public double calculImpactVoiture (Collection<Voiture> collection_voiture){
        double somme = 0.0;
        for (Voiture v : collection_voiture){
            somme += v.getImpact();
        }
        return (somme);
    }

    /**
     * Methode qui calcule la somme de tous les impacts des differentes avions  de la liste d'avions.
     * @param collection_avion
     * @return La somme de tous les impacts des differentes avions  de la liste d'avions.
     */
    public double calculImpactAvion (Collection<Avion> collection_avion){
        double somme = 0.0;
        for (Avion a : collection_avion){
            somme += a.getImpact();
        }
        return (somme);
    }

    /**
     * Methode qui calcule la somme de tous les impacts des differentes bus  de la liste de bus.
     * @param collection_bus
     * @return la somme de tous les impacts des differentes bus  de la liste de bus.
     */

    public double calculImpactBus (Collection<Bus> collection_bus){
        double somme = 0.0;
        for (Bus b : collection_bus){
            somme += b.getImpact();
        }
        return (somme);
    }

    /**
     * Methode qui calcule la somme de tous les impacts des differentes TGV  de la liste de TGV.
     * @param collection_tgv
     * @return la somme de tous les impacts des differentes TGV  de la liste de TGV.
     */
    //Pour une liste de TGV :
    public double calculImpactTgv (Collection<TGV> collection_tgv){
        double somme = 0.0;
        for (TGV t : collection_tgv){
            somme += t.getImpact();
        }
        return (somme);
    }


    /**
     * Cette methode renvoie renvoie la somme des impacts de chaque catégorie.
     * @return L'empreinte carbonne calculee de l'utilsateur.rice.
     */
    
    public double calculerEmpreinte(){
        return(this.alimentation.getImpact() + this.bienConso.getImpact() + calculImpactLogement(this.collection_logement) + calculImpactVoiture(this.collection_voiture) + calculImpactBus(this.collection_bus) + calculImpactTgv(this.collection_tgv) + this.service.getImpact());
    }



    /**
     * Methode qui compare l'empreinte carbonne moyenne de l'alimentation d'un utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareAlimentation() {
        double moyenneAlimentation = 2.353;
        if (this.alimentation.getImpact() < moyenneAlimentation) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'alimentation d'un Francais ");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'alimentation d'un Francais ");
        }
    }


    /**
     * Methode qui compare l'empreinte carbonne moyenne des depenses de l'utilisateur-rice.seur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareBienConso() {
        double moyenneBienConso = 2.625;
        if (this.bienConso.getImpact() < moyenneBienConso) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Bien conso d'un Francais ");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Bien conso d'un Francais ");
        }
    }

    /**
     * Methode qui compare l'empreinte carbonne moyenne du logement de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareLogement() {
        double moyenneLogement = 2.706;
        if (calculImpactLogement(this.collection_logement)  < moyenneLogement) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Logement d'un Francais ");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Logement d'un Francais ");
        }
    }

    /**
     * Methode qui comparent l'empreinte carbonne moyenne de la voiture de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareVoiture() {
        double moyenneVoiture = 1.972;
        if (calculImpactVoiture(this.collection_voiture) < moyenneVoiture) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'une voiture d'un Francais ");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'une voiture d'un Francais ");
        }
    }

    /**
     * Methode qui comparent l'empreinte carbonne moyenne d'un trajet en avion de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareAvion() {
        double moyenneAvion = 0.48;
        if (calculImpactVoiture(this.collection_voiture) < moyenneAvion) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Francais en ce qui concerne les trajets en Avion");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Francais en ce qui concerne les trajets en Avion");
        }
    }

    /**
     * Methode qui comparent l'empreinte carbonne moyenne d'un trajet en bus de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareBus() {
        double moyenneBus = 0.48;
        if (calculImpactBus(this.collection_bus) < moyenneBus) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Francais en ce qui concerne les trajets en Bus");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Francais en ce qui concerne les trajets en Bus ");
        }
    }

    /**
     * Methode qui comparent l'empreinte carbonne moyenne d'un trajet en TGV de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareTgv() {
        double moyenneTgv = 0.48;
        if (calculImpactTgv(this.collection_tgv) < moyenneTgv) {
            System.out.println("L'impact calculé est plus petit que la moyenne d'un Francais en ce qui concerne les trajets en TGV");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Francais en ce qui concerne les trajets en TGV ");
        }
    }


    /**
     * Methode qui comparent l'empreinte carbonne moyenne induit par les services publics de l'utilisateur avec la valeur moyenne d'un Français.
     * Les valeurs ont été trouvees sur Internet.
     */
    public void CompareService() {
        double moyenneService = 1.489;
        if (this.service.getImpact() < moyenneService) {
            System.out.println("L'impact des services est plus petit que la moyenne d'un Service d'un Francais ");
        } else {
            System.out.println("L'impact calculé est plus élévé que la moyenne d'un Service d'un Francais ");
        }
    }

    /**
     * Cette methode affiche sur la console une description detaillee de l'empreinte carbonne de l'utilsateur.rice.
     * Nous avons compare l'empreinte de l'utilisateur avec l'empreinte moyenne d'un français.
     */
    public void detaillerEmpreinte(){
        System.out.println("Impact de l'alimentation : "+ this.alimentation.getImpact() );
        CompareAlimentation();

        System.out.println("Impact de bienConso : "+ this.bienConso.getImpact() );
        CompareBienConso();

        System.out.println("Impact du logement : "+ calculImpactLogement(this.collection_logement) );
        CompareLogement();

        System.out.println("Impact de la voiture : "+ calculImpactVoiture(this.collection_voiture));
        CompareVoiture();

        System.out.println("Impact de l'avion : "+ calculImpactAvion(this.collection_avion));
        CompareAvion();

        System.out.println("Impact du bus : "+ calculImpactBus(this.collection_bus));
        CompareBus();

        System.out.println("Impact du tgv : "+ calculImpactTgv(this.collection_tgv));
        CompareVoiture();

        System.out.println("Impact du service publique : "+ this.service.getImpact() );
        CompareService();

    }


    /**
     * Cette methode ordonne les consommations carbone de l’utilisateur.rice dans une liste, présente l’information obtenue à ce.tte dernier.e.
     * Et fait des recommendations pour obtenir un mode de vie plus durable.
     * Nous avons fait une methode qui, lorsqu'on lui donne un double, retourne le type.
     * Nous avons décide de ne pas donner de recommandation sur les services publiques, sachant que la valeur est unique, et qu'aucun parametre ne pourra modifier cet impact.
     * En d'autres termes, l'utilisateur ne peut rien faire pour diminuer l'impact de cette catégorie.
     * si celui ci est plus eleve que la moyenne, nous affichons une recommandation.
     * @param i
     */
    public void recommandationImpact(double i) {
        //Alimenation :
        if (i == this.alimentation.getImpact()) {
            System.out.println("L'impact de l'alimentation est de :" + i);
            if (i >= 2.353) {
                System.out.println("Il est superieur à la moyenne d'un Français dans cette catégorie");
                System.out.println("Recommandation : privilégier les fruits, légumes et les aliments d'origine végétale par rapport à la viande.");
            }
        } else if (i == this.bienConso.getImpact()) {
            System.out.println("L'impact des biens conso est de :" + i);
            if (i >= 2.625) {
                System.out.println("Il est superieur à la moyenne d'un Français dans cette catégorie");
                System.out.println(" Recommandations : Éviter les achats impulsifs. Emprunter et louer. ");
            }
        } else if (i == calculImpactLogement(this.collection_logement)) {
            System.out.println("L'impact du logement est de :" + i);
            if (i >= 2.706) {
                System.out.println("Il est superieur à la moyenne d'un Français dans cette catégorie");
                System.out.println(" Recommandations : Privilegier un logement de bonne classe energetique ");
            }
        } else if (i == calculImpactVoiture(this.collection_voiture)) {
            System.out.println("L'impact de la voiture est de :" + i);
            if (i >= 1.972) {
                System.out.println("Il est superieur à la moyenne d'un Français dans cette catégorie");
                System.out.println(" Recommandations : Eviter les trajets en voiture. Privilegier les transports en communs ");
            }

        } else if(i == calculImpactAvion(this.collection_avion)){
            System.out.println("L'impact de l'avion est de : " + i);
            if (i >= 0.48) {
                System.out.println("Il est superieur à la moyenne d'un Français dans cette catégorie");
                System.out.println(" Recommandations : Eviter les trajets courts en Avion. Privilegier le TGV ");
            }
        } else if (i == calculImpactBus(this.collection_bus)){
            System.out.println("L'impact du bus est de : " + i);
            if (i >= 0.48) {
                System.out.println("Il est superieur à la moyenne d'un Français dans cette catégorie");
                System.out.println(" Recommandations : Eviter les trajets courts en Bus. Privilegier la marche à pieds si possible, ou les Bus éléctriques. ");
            }
        } else if (i == calculImpactTgv(this.collection_tgv)){
            System.out.println("L'impact du TGV est de : " + i);
            if(i >= 0.01) {
                System.out.println("Il est superieur à la moyenne d'un Français dans cette catégorie");
                System.out.println(" Recommandations : Eviter  les trajets inutiles. ");
            }
        } else if (i == this.service.getImpact()) {
            System.out.println("L'impact des services publiques est de :" + i);
        }
    }

    /**
     * Methode qui ordonne les consommations carbonne de l'utilisateur.rice dans une liste, et qui appelle la fonction recommandationImpact pour faire des recommendations a l'utilisateur.
     */
    public void recommandation() {
        double[] impacts = {this.alimentation.getImpact(), this.bienConso.getImpact(), calculImpactLogement(this.collection_logement), calculImpactVoiture(this.collection_voiture), calculImpactAvion(this.collection_avion), calculImpactBus(this.collection_bus), calculImpactTgv(this.collection_tgv), this.service.getImpact()};
        //Affichage de l'array :
        for (int i = 0; i < 8; i++) {
            recommandationImpact(impacts[i]);
            System.out.println(impacts[i]);
        }
    }

    /**
     * @return une chaîne contenant les informations relatives a la classe Utilisateur.
     */
    @Override
    public String toString() {
        return "Utilisateur{" +
                "alimentation=" + alimentation +
                ", bienConso=" + bienConso +
                ", collection_logement=" + collection_logement +
                ", collection_voiture=" + collection_voiture +
                ", collection_avion=" + collection_avion +
                ", collection_bus=" + collection_bus +
                ", collection_tgv=" + collection_tgv +
                ", service=" + service +
                '}';
    }
}

