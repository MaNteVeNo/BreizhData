package model.data;


/**
 * Représente une année avec son taux d'inflation.
 */
public class Annee{

    private int annee; // année
    private float tauxInflation; // taux d'inflation

    /**
     * Constructeur par défaut qui initialise l'année et le taux d'inflation à zéro.
     */
    public Annee() {
        this.annee = 0;
        this.tauxInflation = 0;
    }

    /**
     * Constructeur avec paramètres qui initialise l'année et le taux d'inflation donnés.
     *
     * @param annee l'année
     * @param inflation le taux d'inflation
     * @throws IllegalArgumentException si l'année ou le taux d'inflation est incorrect
     */
    public Annee(int annee, float inflation) {
        if (annee >= 0) {
            if (inflation >= 0) {
                this.annee = annee;
                this.tauxInflation = inflation;
            } else {
                throw new IllegalArgumentException("Le taux d'inflation est incorrect");
            }
        } else {
            throw new IllegalArgumentException("L'année est incorrecte");
        }
    }

    /**
     * Obtient l'année.
     *
     * @return l'année
     */
    public int getAnnee() {
        return this.annee;
    }

    /**
     * Obtient le taux d'inflation.
     *
     * @return le taux d'inflation
     */
    public float getTauxInflation() {
        return this.tauxInflation;
    }

    /**
     * Définit l'année.
     *
     * @param annee la nouvelle année
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     * Définit le taux d'inflation.
     *
     * @param tauxInflation le nouveau taux d'inflation
     */
    public void setTauxInflation(float tauxInflation) {
        this.tauxInflation = tauxInflation;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'année et de son taux d'inflation.
     *
     * @return une représentation sous forme de chaîne de caractères de l'année et de son taux d'inflation
     */
    public String toString() {
        return "Voici l'année : " + this.annee + " et son taux d'inflation : " + this.tauxInflation;
    }
}
