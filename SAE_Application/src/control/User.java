package control;

public class User {
    private String prenom;
    private String nom;
    private String email;
    private String mdp;

    public User(String prenom, String nom, String email, String mdp) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }
}
