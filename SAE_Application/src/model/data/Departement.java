package model.data;

import java.util.ArrayList;

/**
 * Represente un departement avec son id, son nom et son investissement culturel
 * en 2019
 */
public class Departement {

    /**
     * C'est l'id pour chaque departement
     */
    private int idDep;
    /**
     * Le nom de chaque département
     */
    private String nomDep;
    /**
     * L'investissement culturel pour l'année 2019
     */
    private float invesCulturel2019;
    /**
     * ArrayList des aéroports
     */
    private ArrayList<Aeroport> lesAeroports;

    /**
     * Constructeur vide du Departement
     */
    public Departement() {
        this.idDep = 0;
        this.nomDep = "";
        this.invesCulturel2019 = 0;
        this.lesAeroports = new ArrayList<>();
    }

    /**
     * Constructeur du Departement
     * 
     * @param id    - L'id de chaque departement
     * @param nom   - La nom de chaque département
     * @param inves - Investissement culturel pour l'année 2019
     * @throws IllegalArgumentException - Si le nom ou l'adresse est null
     */
    public Departement(int id, String nom, float inves) throws IllegalArgumentException {
        if (id >= 0) {
            if (nom != null) {
                if (inves >= 0) {
                    this.idDep = id;
                    this.nomDep = nom;
                    this.invesCulturel2019 = inves;
                    this.lesAeroports = new ArrayList<>();
                } else {
                    throw new IllegalArgumentException("Departement : L'investissement est incorrect !!!");
                }
            } else {
                throw new IllegalArgumentException("Departement : Le nom du département est null !!!");
            }
        } else {
            throw new IllegalArgumentException("Departement : L'identifiant du département est incorrect !!!");
        }
    }
    
    public int getIdDep(){
        return this.idDep;
    }

    public String getNomDep(){
        return this.nomDep;
    }

    public float getInvesCulturel2019() {
        return this.invesCulturel2019;
    }

    public void setIdDep(int dep){
        this.idDep = dep;
    }

    public void setNomDep(String nom){
        this.nomDep = nom;
    }

    public void setInvesCulturel2019(float inves){
        this.invesCulturel2019 = inves;
    }

    public String toString(){
        
        String idDep = "idDep : " + this.idDep;
        String nomDep = "nomDep : " + this.nomDep;
        String invesCulturel2019 = "investCulturel2019 : " + this.invesCulturel2019;
        String aeroports = "Aéroports : " + this.lesAeroports.toString();

        return idDep + "\n" + nomDep + "\n" + invesCulturel2019 + "\n" + aeroports + "\n";
    }

    public void add(Aeroport aeroport) {
        this.lesAeroports.add(aeroport);
    }
}
