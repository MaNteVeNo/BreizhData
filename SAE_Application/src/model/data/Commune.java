package model.data;

import java.util.ArrayList;

/**
 * Represente une commune avec son id et son nom
 */
public class Commune {

    /**
     * id de la commune
     */
    private int idCommune;
    /**
     * nom de la commune
     */
    private String nomCommune;
    /**
     * ArrayList des gares
     */
    private ArrayList<Gare> lesGares;
    /**
     * ArrayList des communes voisines
     */
    private ArrayList<Commune> communesVoisines;
    /**
     * Départements de la commune
     */
    private Departement leDepartement;

    /**
     * Constructeur vide de la Commune
     */
    public Commune() {
        this.idCommune = 0;
        this.nomCommune = "";
        this.lesGares = new ArrayList<>();
        this.communesVoisines = new ArrayList<>();
    }

    /**
     * Constructeur de la Commune
     * 
     * @param id  - id de la commune
     * @param nom - nom de la commune
     * @throws IllegalArgumentException si le nom ou l'adresse est null
     */
    public Commune(int id, String nom) {
        if (id >= 0 && nom != null) {
            this.idCommune = id;
            this.nomCommune = nom;
            this.lesGares = new ArrayList<>();
            this.communesVoisines = new ArrayList<>();
        } else {
            throw new IllegalArgumentException("Commune : un des paramètres est null");
        }
    }

    /**
     * Obtient l'id de la commune
     * 
     * @return l'id de la commune
     */
    public int getIdCommune() {
        return this.idCommune;
    }

    /**
     * Obtient le nom de la commune
     * 
     * @return le nom de la commune
     */
    public String getNomCommune() {
        return this.nomCommune;
    }

    /**
     * Définit l'id de la commune
     * 
     * @param commune l'id de la commune
     */
    public void setIdCommune(int commune) {
        this.idCommune = commune;
    }

    /**
     * Définit le nom de la commune
     * 
     * @param nom le nom de la commune
     */
    public void setNomCommune(String nom) {
        this.nomCommune = nom;
    }

    /**
     * Ajoute une commune voisine à la liste des communes voisines
     * 
     * @param voisine - la commune voisine à ajouter
     */
    public void ajouterCommuneVoisine(Commune voisine) {
        if (voisine != null && !this.communesVoisines.contains(voisine)) {
            this.communesVoisines.add(voisine);
        }
    }

    /**
     * Supprime une commune voisine de la liste des communes voisines
     * 
     * @param voisine - la commune voisine à supprimer
     */
    public void supprimerCommuneVoisine(Commune voisine) {
        this.communesVoisines.remove(voisine);
    }

    /**
     * Retourne la liste des noms des communes voisines
     * 
     * @return une liste de noms des communes voisines
     */
    public ArrayList<String> listerCommunesVoisines() {
        ArrayList<String> nomsVoisines = new ArrayList<>();
        for (Commune voisine : this.communesVoisines) {
            nomsVoisines.add(voisine.getNomCommune());
        }
        return nomsVoisines;
    }

    /**
     * Ajoute une gare à la liste des gares
     * 
     * @param gare - la gare à ajouter
     */
    public void ajouterGare(Gare gare) {
        if (gare != null && !this.lesGares.contains(gare)) {
            this.lesGares.add(gare);
        }
    }

    /**
     * Supprime une gare de la liste des gares
     * 
     * @param gare - la gare à supprimer
     */
    public void supprimerGare(Gare gare) {
        this.lesGares.remove(gare);
    }

    /**
     * Retourne la liste des noms des gares
     * 
     * @return une liste de noms des gares
     */
    public ArrayList<String> listerGares() {
        ArrayList<String> nomsGares = new ArrayList<>();
        for (Gare gare : this.lesGares) {
            nomsGares.add(gare.getNomGare()); // Assurez-vous que Gare a une méthode getNomGare()
        }
        return nomsGares;
    }

    /**
     * Vérifie si une commune est voisine
     * 
     * @param voisine - la commune à vérifier
     * @return true si la commune est voisine, false sinon
     */
    public boolean estVoisine(Commune voisine) {
        return this.communesVoisines.contains(voisine);
    }

    /**
     * Retourne le nombre de communes voisines
     * 
     * @return le nombre de communes voisines
     */
    public int nombreCommunesVoisines() {
        return this.communesVoisines.size();
    }

    /**
     * Retourne le nombre de gares
     * 
     * @return le nombre de gares
     */
    public int nombreGares() {
        return this.lesGares.size();
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de idCommune,
     * nomCommune
     * 
     * @return une représentation sous forme de chaîne de caractères de idCommune,
     *         nomCommune
     */
    @Override
    public String toString() {
        String idCommune = "idCommune : " + this.idCommune;
        String nomCommune = "nomCommune : " + this.nomCommune;

        return idCommune + "\n" + nomCommune + "\n";
    }
}
