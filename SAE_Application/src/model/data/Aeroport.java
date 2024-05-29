package model.data;

import java.util.ArrayList;

/**
 * Représente un aéroport avec un nom et une adresse.
 */
public class Aeroport {
    private String nom; // nom de l'aéroport
    private String adresse; // adresse de l'aéroport
    private Departement leDepartement; // departement de l'aéoroport

    /**
     * Constructeur par défaut qui initialise l'aéroport avec un nom et une adresse vides.
     */
    public Aeroport() {
        this.nom = "";
        this.adresse = "";
    }

    /**
     * Constructeur avec paramètres qui initialise l'aéroport avec le nom et l'adresse donnés.
     *
     * @param nom le nom de l'aéroport
     * @param adresse l'adresse de l'aéroport
     * @throws IllegalArgumentException si le nom ou l'adresse est null
     */
    public Aeroport(String nom, String adresse, Departement leDepartement) throws IllegalArgumentException {
        if (nom != null) {
            if (adresse != null) {
                this.nom = nom;
                this.adresse = adresse;
                this.leDepartement = leDepartement;
            } else {
                throw new IllegalArgumentException("L'adresse de l'aéroport est null");
            }
        } else {
            throw new IllegalArgumentException("Le nom de l'aéroport est null");
        }
    }

    /**
     * Obtient le nom de l'aéroport.
     *
     * @return le nom de l'aéroport
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Obtient l'adresse de l'aéroport.
     *
     * @return l'adresse de l'aéroport
     */
    public String getAdresse() {
        return this.adresse;
    }

    public Departement getLeDepartement() {
        return this.leDepartement;
    }

    /**
     * Définit le nom de l'aéroport.
     *
     * @param nom le nouveau nom de l'aéroport
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit l'adresse de l'aéroport.
     *
     * @param adresse la nouvelle adresse de l'aéroport
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setLeDepartement(Departement leDepartement) {
    this.leDepartement = leDepartement;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'aéroport.
     * @return une représentation sous forme de chaîne de caractères de l'aéroport
     */
    public String toString() {

        String nom = "Nom : " + this.nom;
        String adresse = "Adresse : " + this.adresse;
        return nom + "\n" + adresse + "\n";
    }

    /**
     * Méthode qui retourne la commune à laquelle appartient l'aéroport en fonction de son adresse.
     * @param communes la liste des communes disponibles
     * @return la commune à laquelle appartient l'aéroport, ou null si aucune correspondance n'est trouvée
     */
    public Commune findCommune(ArrayList<Commune> communes) {
        Commune res = null;
        for (Commune commune : communes) {
            if (this.adresse.contains(commune.getNomCommune())) {
                res = commune;
            }
        }
        return res;
    }


}
