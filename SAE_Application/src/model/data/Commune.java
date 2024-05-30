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
    public Commune(int id, String nom, Departement departement) {
        if (id >= 0 && nom != null) {
            this.idCommune = id;
            this.nomCommune = nom;
            this.leDepartement = departement;
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
     * Obtient le departememt de la commune
     * 
     * @return le departement
     */
    public Departement getLeDepartement() {
        return this.leDepartement;
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
     * Définit le nom de la commune
     * 
     * @param departement le departement
     */
    public void setLeDepartement(Departement departement) {
        this.leDepartement = departement;
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
