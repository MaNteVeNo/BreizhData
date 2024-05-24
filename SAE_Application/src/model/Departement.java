package model;

import view.*;
import control.*;

/**
 * Représente un département avec son id, son nom et son investissement culturel
 * en 2019.
 */
public class Departement {

    /**
     * C'est l'id pour chaque département.
     */
    private int idDep;

    /**
     * Le nom de chaque département.
     */
    private String nomDep;

    /**
     * L'investissement culturel pour l'année 2019.
     */
    private float invesCulturel2019;

    /**
     * Constructeur vide du Département.
     */
    public Departement() {
        this.idDep = 0;
        this.nomDep = "";
        this.invesCulturel2019 = 0;
    }

    /**
     * Constructeur du Département.
     *
     * @param id    l'id de chaque département
     * @param nom   le nom de chaque département
     * @param inves l'investissement culturel pour l'année 2019
     * @throws IllegalArgumentException si le nom est null ou si l'investissement est incorrect
     */
    public Departement(int id, String nom, float inves) {
        if (id >= 0) {
            if (nom != null) {
                if (inves >= 0) {
                    this.idDep = id;
                    this.nomDep = nom;
                    this.invesCulturel2019 = inves;
                } else {
                    throw new IllegalArgumentException("Departement : L'investissement est incorrect !!!");
                }
            } else {
                throw new IllegalArgumentException("Departement : Le nom de département est null !!!");
            }
        } else {
            throw new IllegalArgumentException("Departement : L'identifiant de département est incorrect !!!");
        }
    }

    /**
     * Obtient l'id du département.
     *
     * @return l'id du département
     */
    public int getIdDep() {
        return this.idDep;
    }

    /**
     * Définit l'id du département.
     *
     * @param id le nouvel id du département
     */
    public void setIdDep(int id) {
        this.idDep = id;
    }

    /**
     * Obtient le nom du département.
     *
     * @return le nom du département
     */
    public String getNomDep() {
        return this.nomDep;
    }

    /**
     * Définit le nom du département.
     *
     * @param nom le nouveau nom du département
     */
    public void setNomDep(String nom) {
        this.nomDep = nom;
    }

    /**
     * Obtient l'investissement culturel pour l'année 2019.
     *
     * @return l'investissement culturel pour l'année 2019
     */
    public float getInvestCulturel() {
        return this.invesCulturel2019;
    }

    /**
     * Définit l'investissement culturel pour l'année 2019.
     *
     * @param invest le nouvel investissement culturel pour l'année 2019
     */
    public void setInvestCulturel(float invest) {
        this.invesCulturel2019 = invest;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères du département.
     *
     * @return une représentation sous forme de chaîne de caractères du département
     */
    public String toString() {
        String idDepStr = "Identifiant du département : " + this.idDep;
        String nomDepStr = "Nom du département : " + this.nomDep;
        String investCulturelStr = "Investissement Culturel de 2019 : " + this.invesCulturel2019;

        return idDepStr + "\n" + nomDepStr + "\n" + investCulturelStr;
    }
}
