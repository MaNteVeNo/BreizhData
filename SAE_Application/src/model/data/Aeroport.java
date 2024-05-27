package model.data;


/**
 * Représente un aéroport avec un nom et une adresse.
 */
public class Aeroport {
    private String nom; // nom de l'aéroport
    private String adresse; // adresse de l'aéroport

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
    public Aeroport(String nom, String adresse) throws IllegalArgumentException {
        if (nom != null) {
            if (adresse != null) {
                this.nom = nom;
                this.adresse = adresse;
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

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'aéroport.
     *
     * @return une représentation sous forme de chaîne de caractères de l'aéroport
     */
    public String toString() {
        return ("L'aéroport se nomme : " + this.nom + "\n" + "Et se situe à cette adresse: " + this.adresse);
    }
}
