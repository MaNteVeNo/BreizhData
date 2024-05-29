package model.data;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


/**
 * Représente une année avec son taux d'inflation.
 */
public class Annee {

    private int annee; // année
    private float tauxInflation; // taux d'inflation

    // Map pour stocker les taux d'inflation par année
    private Map<Integer, Float> tauxInflationParAnnee = new HashMap<>();

    /**
     * Constructeur par défaut qui initialise l'année et le taux d'inflation à zéro.
     */
    public Annee() {
        this.annee = 0;
        this.tauxInflation = 0;
        this.tauxInflationParAnnee = new HashMap<>();
    }

    /**
     * Constructeur avec paramètres qui initialise l'année et le taux d'inflation
     * donnés.
     *
     * @param annee     l'année
     * @param inflation le taux d'inflation
     * @throws IllegalArgumentException si l'année ou le taux d'inflation est
     *                                  incorrect
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

    // Méthode pour ajouter un taux d'inflation pour une année donnée
    public void ajouterTauxInflation(int annee, float tauxInflation) {
        tauxInflationParAnnee.put(annee, tauxInflation);
    }

    // Méthode pour récupérer le taux d'inflation pour une année donnée
    public float tauxInflationParAnnee(int annee) {
        Float tauxInflation = tauxInflationParAnnee.get(annee);
        if (tauxInflation == null) {
            // Si aucun taux d'inflation n'est trouvé pour cette année, renvoie 0
            return 0;
        }
        return tauxInflation;
    }

    /**
     * Calcule le taux d'inflation moyen sur une période donnée.
     * 
     * @param debut Année de début de la période.
     * @param fin   Année de fin de la période.
     * @return Le taux d'inflation moyen sur la période donnée.
     */
    public float tauxInflationMoyen(int debut, int fin) {
        int nbAnnees = fin - debut + 1;
        float sommeTaux = 0;
        for (int annee = debut; annee <= fin; annee++) {
            sommeTaux += tauxInflationParAnnee(annee);
        }
        return nbAnnees > 0 ? sommeTaux / nbAnnees : 0;
    }

    /**
     * Récupère la liste des années avec le taux d'inflation le plus élevé et le
     * plus faible.
     * 
     * @return Une liste contenant l'année avec le taux d'inflation le plus élevé en
     *         première position,
     *         et l'année avec le taux d'inflation le plus faible en deuxième
     *         position.
     */
    public List<Integer> anneesAvecPlusFaibleEtPlusElevéTaux() {
        List<Integer> result = new ArrayList<>();
        int anneeMax = 0, anneeMin = 0;
        float tauxMax = Float.MIN_VALUE, tauxMin = Float.MAX_VALUE;
        for (Map.Entry<Integer, Float> entry : tauxInflationParAnnee.entrySet()) {
            int annee = entry.getKey();
            float taux = entry.getValue();
            if (taux > tauxMax) {
                tauxMax = taux;
                anneeMax = annee;
            }
            if (taux < tauxMin) {
                tauxMin = taux;
                anneeMin = annee;
            }
        }
        result.add(anneeMax);
        result.add(anneeMin);
        return result;
    }

    /**
     * Vérifie si une année est répertoriée dans les données d'inflation.
     * 
     * @param annee L'année à vérifier.
     * @return true si l'année est répertoriée, sinon false.
     */
    public boolean anneeEstPresente(int annee) {
        return tauxInflationParAnnee.containsKey(annee);
    }

    /**
     * Supprime le taux d'inflation pour une année spécifique.
     * 
     * @param annee L'année pour laquelle supprimer le taux d'inflation.
     * @return true si le taux d'inflation a été supprimé avec succès, sinon false.
     */
    public boolean supprimerTauxInflation(int annee) {
        if (tauxInflationParAnnee.containsKey(annee)) {
            tauxInflationParAnnee.remove(annee);
            return true;
        }
        return false;
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
     * Retourne une représentation sous forme de chaîne de caractères de l'année et
     * de son taux d'inflation.
     *
     * @return une représentation sous forme de chaîne de caractères de l'année et
     *         de son taux d'inflation
     */
    public String toString() {

        String annee = "L'année : " + this.annee;
        String tauxInflation = "TauxInflation : " + this.tauxInflation;

        return annee + "\n" + tauxInflation + "\n";
    }
}
