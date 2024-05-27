package model.data;

/**
 * Représente la gare par son code, son nom, et si c'est une gare de commerce ou
 * de voyageur.
 */
public class Gare {

    /**
     * Code de la gare.
     */
    private int codeGare;

    /**
     * Nom de la gare.
     */
    private String nomGare;

    /**
     * Indique si la gare est une gare de commerce.
     */
    private boolean estFret;

    /**
     * Indique si la gare est une gare de voyageur.
     */
    private boolean estVoyageur;
    /**
     * Commune pour les gares
     */
    private Commune laCommune;

    /**
     * Constructeur vide de la Gare.
     */
    public Gare() {
        this.codeGare = 0;
        this.nomGare = "";
        this.estFret = false;
        this.estVoyageur = false;
    }

    /**
     * Constructeur de la Gare.
     *
     * @param code     le code donné pour une gare
     * @param nom      le nom de la gare
     * @param fret     si la gare est une gare de commerce
     * @param voyageur si la gare est une gare de voyageur
     * @throws IllegalArgumentException si le nom est null
     */
    public Gare(int code, String nom, boolean fret, boolean voyageur) {
        if (code >= 0) {
            if (nom != null) {
                this.codeGare = code;
                this.nomGare = nom;
                this.estFret = fret;
                this.estVoyageur = voyageur;
            } else {
                throw new IllegalArgumentException("Le nom de la Gare est NULL !!!");
            }
        } else {
            throw new IllegalArgumentException("Le code de la gare est incorrect !!!");
        }
    }

    /**
     * Obtient le code de la gare.
     *
     * @return le code de la gare
     */
    public int getCodeGare() {
        return this.codeGare;
    }

    /**
     * Obtient le nom de la gare.
     *
     * @return le nom de la gare
     */
    public String getNomGare() {
        return this.nomGare;
    }

    /**
     * Indique si la gare est une gare de commerce.
     *
     * @return true si la gare est une gare de commerce, sinon false
     */
    public boolean getEstFret() {
        return this.estFret;
    }

    /**
     * Indique si la gare est une gare de voyageur.
     *
     * @return true si la gare est une gare de voyageur, sinon false
     */
    public boolean getEstVoyageur() {
        return this.estVoyageur;
    }

    /**
     * Définit le code de la gare.
     *
     * @param code le nouveau code de la gare
     */
    public void setCodeGare(int code) {
        this.codeGare = code;
    }

    /**
     * Définit le nom de la gare.
     *
     * @param nom le nouveau nom de la gare
     */
    public void setNomGare(String nom) {
        this.nomGare = nom;
    }

    /**
     * Définit si la gare est une gare de commerce.
     *
     * @param estFret le nouvel état de la gare de commerce
     */
    public void setEstFret(boolean estFret) {
        this.estFret = estFret;
    }

    /**
     * Définit si la gare est une gare de voyageur.
     *
     * @param estVoyageur le nouvel état de la gare de voyageur
     */
    public void setEstVoyageur(boolean estVoyageur) {
        this.estVoyageur = estVoyageur;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la gare.
     *
     * @return une représentation sous forme de chaîne de caractères de la gare
     */
    @Override
    public String toString() {

        String code = "Le code de la gare est : " + this.codeGare;
        String nom = "Le nom de la gare est : " + this.nomGare;
        String estFret = "L'état de estFret est : " + this.estFret;
        String estVoyageur = "L'état de estVoyageur est : " + this.estVoyageur;

        return "CodeGare : " + code + "\n" + "NomGare : " + nom + "\n" + "EstFret : " + estFret + "\n" + "EstVoyageur : " + estVoyageur;
    }
}
