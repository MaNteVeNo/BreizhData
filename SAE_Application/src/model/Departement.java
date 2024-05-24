package model;

import view.*;
import control.*;

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
     * Constructeur vide du Departement
     */
    public Departement() {
        this.idDep = 0;
        this.nomDep = "";
        this.invesCulturel2019 = 0;
    }

    /**
     * Constructeur du Departement
     * 
     * @param id    - L'id de chaque departement
     * @param nom   - La nom de chaque département
     * @param inves - Investissement culturel pour l'année 2019
     * @throws IllegalAgumentException - Si le nom ou l'adresse est null
     */
    public Departement(int id, String nom, float inves) {

        if (idDep >= 0) {
            if (nomDep != null) {
                if (inves >= 0) {
                    this.idDep = id;
                    this.nomDep = nom;
                    this.invesCulturel2019 = inves;
                } else {
                    throw new IllegalAgumentException("Departement : L'investissement est Incorrect !!!");
                }
            } else {
                throw new IllegalAgumentException("Departement : Le nom de département est Null !!!");
            }
        } else {
            throw new IllegalArgumentException("Departement : L'identifiant de département est Null !!!");
        }
    }

    public int setIdDep(){
        return this.idDep;
    }

    public String setNomDep (){
        return this.nomDep;
    }

    public float setInvestCulturel (){
        return this.invesCulturel2019;
    }

    public void getIdDep(int id){
        this.idDep = id;
    }

    public void getNomDep(String nom){
        this.nomDep
    }
}