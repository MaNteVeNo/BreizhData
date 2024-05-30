package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.data.Annee;
import model.data.Commune;
import model.data.DonneesAnnuelle;

public class DonneesAnnuelleDAO extends DAO<DonneesAnnuelle> {

    private CommuneDAO communeDAO = new CommuneDAO();
    private AnneeDAO anneeDAO = new AnneeDAO();

    private ArrayList<DonneesAnnuelle> donneesAnnuelles;

    public DonneesAnnuelleDAO() {
        this.donneesAnnuelles = new ArrayList<>();
    }

    public int create(DonneesAnnuelle donnees) {
        this.donneesAnnuelles.add(donnees);
        String query = "INSERT INTO donneesAnnuelle(lAnnee, laCommune, nbMaison, nbAppart, prixMoyen, prixM2Moyen, surfaceMoy, depenses, budget, population, idCommune, annee) VALUES ('"
                + donnees.getLaCommune().getIdCommune() + "','" + donnees.getLAnnee().getAnnee() + "','" + donnees.getNbMaison() + "','" + donnees.getNbAppart() + "','" + donnees.getPrixMoyen() + "','"
                + donnees.getPrixM2Moyen() + "','" + donnees.getSurfaceMoy() + "','" + donnees.getDepCulturellesTotales()
                + "','" + donnees.getBudgetTotal() + "','" + donnees.getPopulation() + "','"
                + donnees.getLaCommune().getIdCommune() + "','" + donnees.getLAnnee().getAnnee() + "')";
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int update(DonneesAnnuelle donnees) {
        String query = "UPDATE donneesAnnuelle SET nbMaison='" + donnees.getNbMaison() + "', nbAppart='"
                + donnees.getNbAppart() + "', prixMoyen='" + donnees.getPrixMoyen() + "', prixM2Moyen='"
                + donnees.getPrixM2Moyen() + "', surfaceMoy='" + donnees.getSurfaceMoy() + "', depenses='"
                + donnees.getDepCulturellesTotales() + "', budget='" + donnees.getBudgetTotal() + "', population='"
                + donnees.getPopulation() + "', laCommune='" + donnees.getLaCommune() + "', lAnnee='"
                + donnees.getLAnnee().getAnnee() + "' WHERE laCommune='" + donnees.getLaCommune().getIdCommune() 
                + "' AND lAnnee='" + donnees.getLAnnee().getAnnee() + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            for (int i = 0; i < this.donneesAnnuelles.size(); i++) {
                if (donnees.getLaCommune().getIdCommune() == this.donneesAnnuelles.get(i).getLaCommune().getIdCommune()
                        && donnees.getLAnnee().getAnnee() == this.donneesAnnuelles.get(i).getLAnnee().getAnnee()) {
                    this.donneesAnnuelles.set(i, donnees);
                }
            }
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int delete(DonneesAnnuelle donnees) {
        this.donneesAnnuelles.remove(donnees);
        String query = "DELETE FROM donneesAnnuelle WHERE laCommune='" + donnees.getLaCommune().getIdCommune()
                + "' AND lAnnee='" + donnees.getLAnnee().getAnnee() + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public List<DonneesAnnuelle> findAll() {
        this.donneesAnnuelles.clear(); // Nettoyer la liste actuelle avant d'ajouter les données récupérées
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM donneesAnnuelle");
            while (rs.next()) {
                int nbMaison = rs.getInt("nbMaison");
                int nbAppart = rs.getInt("nbAppart");
                float prixMoyen = rs.getFloat("prixMoyen");
                float prixM2Moyen = rs.getFloat("prixM2Moyen");
                float surfaceMoy = rs.getFloat("surfaceMoy");
                float depenses = rs.getFloat("depenses");
                float budget = rs.getFloat("budget");
                float population = rs.getFloat("population");
                int idComm = rs.getInt("idCommune");
                int annee = rs.getInt("annee");

                Commune comm = communeDAO.findComm(idComm);
                Annee an = anneeDAO.findAnnee(annee);
                donneesAnnuelles.add(new DonneesAnnuelle(comm, an, nbMaison, nbAppart, prixMoyen, prixM2Moyen, surfaceMoy, depenses, budget, population));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.donneesAnnuelles;
    }
}
