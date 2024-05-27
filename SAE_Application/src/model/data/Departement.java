package model.data;



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
     * @throws IllegalArgumentException - Si le nom ou l'adresse est null
     */
    public Departement(int id, String nom, float inves) {

        if (idDep >= 0) {
            if (nomDep != null) {
                if (inves >= 0) {
                    this.idDep = id;
                    this.nomDep = nom;
                    this.invesCulturel2019 = inves;
                } else {
                    throw new IllegalArgumentException("Departement : L'investissement est Incorrect !!!");
                }
            } else {
                throw new IllegalArgumentException("Departement : Le nom de département est Null !!!");
            }
        } else {
            throw new IllegalArgumentException("Departement : L'identifiant de département est Null !!!");
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


    

}
