package model.data;
import java.util.ArrayList;

/**
 * Represente une commune avec son id et son nom
 */
public class Commune{

    /**
     * id de la commune
     */
    private int idCommune;
    /**
     * nom de la commune
     */
    private String nomCommune;
    /**
     * ArraList des gares
     */
    private ArrayList<Gare>lesGares;
    /**
     * ArrayList des communes voisines
     */
    private ArrayList<Commune>communesVoisines;
    /**
     * Départements de la commune
     */
    private Departement leDepartement;


    /**
     * Constructeur vide de la Commune
     */
    public Commune(){

        this.idCommune = 0;
        this.nomCommune = "";
    }

    /**
     * Constructeur de la Commune
     * @param id - id de la commune
     * @param nom - nom de la commune
     * @throws IllegalArgumentException si le nom ou l'adresse est null
     */
    public Commune(int id, String nom){

        if(idCommune >= 0 && nomCommune != null){

            this.idCommune = id;
            this.nomCommune = nom;
        }
        else{
            throw new IllegalArgumentException("Commune : un des paramètres est null");
        }
    }

    public int getIdCommune(){
        return this.idCommune;
    }

    public String getNomCommune(){
        return this.nomCommune;
    }

    public void setIdCommune(int commune){
        this.idCommune = commune;
    }

    public void setNomCommune(String nom){
        this.nomCommune = nom;
    }

    public String toString(){

        String idCommune = "idCommune : " + this.idCommune;
        String nomCommune = "nomCommune : " + this.nomCommune;

        return idCommune + "\n" + nomCommune + "\n";
    }
}