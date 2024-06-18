package model.data;

public class User {
    private String prenom;
    private String nom;
    private String mail;
    private String mdp;
    private boolean estAdmin;

    public User(String prenom, String nom, String mail, String mdp, boolean estAdmin) {
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.mdp = mdp;
        this.estAdmin = estAdmin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public boolean isEstAdmin() {
        return estAdmin;
    }

    public void setEstAdmin(boolean estAdmin) {
        this.estAdmin = estAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", mail='" + mail + '\'' +
                ", mdp='" + mdp + '\'' +
                ", estAdmin=" + estAdmin +
                '}';
    }
}
