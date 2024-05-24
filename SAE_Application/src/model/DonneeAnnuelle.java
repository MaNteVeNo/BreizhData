package model;
import view.*;
import model.*;

/**
 * Represente les donnée annuelles pour une commune
 */
public class DonneeAnnuelle{

    /**
     * nombre de maison dans une commune
     */
    private int nbMaison;
    /**
     * nombre d'appartement dans une commune
     */
    private int nbAppart;
    /**
     * prix moyen pour une commune
     */
    private float prixMoyen;
    /**
     * prix moyen au m2 pour une commune
     */
    private float prixM2Moyen;
    /**
     * surface moyenne d'une commune
     */
    private float surfaceMoy;
    /**
     * depenses culturelles totales d'une commune
     */
    private float depCulturellesTotales;
    /**
     * budget total d'une commune
     */
    private float budgetTotal;
    /**
     * population d'une commune
     */
    private float population;

/**
 * Constructeur vide de DonneAnnuelle
 */
    public DonneeAnnuelle(){
        
        this.nbMaison = 0;
        this.nbAppart = 0;
        this.prixMoyen = 0;
        this.prixM2Moyen = 0;
        this.surfaceMoy = 0;
        this.depCulturellesTotales = 0;
        this.budgetTotal = 0;
        this.population = 0;
    }

/**
 * Constructeur des DonneeAnnuelle
 * @param maison - le nombre de maison par commune
 * @param appart - le nombre d'appartement par commune
 * @param LePrixMoyen - prix moyen par commune
 * @param LePrixM2Moyen - le prix au m2 moyen par commune
 * @param LaSurfaceMoy - La surface moyenne d'une commune
 * @param depenses - Les depenses culturelles totales d'une commune
 * @param budget - Budget total pour une commune
 * @param pop - Population d'une commune
 * @throws IllegalArgumentException si l'année ou le taux d'inflation est incorrect
 */
    public DonneeAnnuelle(int maison, int appart, float LePrixMoyen, float LePrixM2Moyen, float LaSurfaceMoy, float depenses, float budget, float pop){

        if(maison >= 0 && appart >= 0 && LePrixMoyen >= 0 && LePrixM2Moyen >= 0 && LaSurfaceMoy >=0 && depenses >= 0 && budget >= 0 && pop >= 0){

            this.nbMaison = maison;
            this.nbAppart = appart;
            this.prixMoyen = LePrixMoyen;
            this.prixM2Moyen = LePrixM2Moyen;
            this.surfaceMoy = LaSurfaceMoy;
            this.depCulturellesTotales = depenses;
            this.budgetTotal = budget;
            this.population = pop;
        }
        else{
            throw new IllegalArgumentException("DonneAnnuelle : un des paramètres est null");
        }
    }

/**
 * Obtient le nombre de maison
 * @return le nombre de maison
 */
    public int getNbMaison(){
        return this.nbMaison;
    }

/**
 * Obtient le nombre d'appartement
 * @return le nombre d'appartement
 */
    public int getNbAppart(){
        return this.nbAppart;
    } 

/**
 * Obtient le prix moyen
 * @return le prix moyen
 */
    public float getPrixMoyen(){
        return this.prixMoyen;
    }

/**
 * Obtient le prix au m2 moyen
 * @return le prix au m2 moyen
 */
    public float getPrixM2Moyen(){
        return this.prixM2Moyen;
    }

/**
 * Obtient la surface moyenne
 * @return la surface moyenne
 */
    public float getSurfaceMoy(){
        return this.surfaceMoy;
    }

/**
 * Obtient les depenses culturelles totales
 * @return les depenses culturelles totales
 */
    public float getDepCulturellesTotales(){
        return this.depCulturellesTotales;
    }

/**
 * Obtient la population
 * @return la population
 */
    public float getPopulation(){
        return this.population;
    }

    public void setNbMaison(int maison){
        this.nbMaison = maison;
    }

    public void setNbAppart(int appart){
        this.nbAppart = appart;
    }

    public void setPrixMoyen(float LePrixMoyen){
        this.prixMoyen = LePrixMoyen;
    }

    public void setPrixM2Moyen(float LePrixM2Moyen){
        this.prixM2Moyen = LePrixM2Moyen;
    }

    public void setSurfaceMoy(float surface){
        this.surfaceMoy = surface;
    }

    public void setDepCulturellesTotales(float depenses){
        this.depCulturellesTotales = depenses;
    }

    public void setBudgetTotal(float budget){
        this.budgetTotal = budget;
    }

    public void setPopulation(float pop){
        this.population = pop;
    }
}