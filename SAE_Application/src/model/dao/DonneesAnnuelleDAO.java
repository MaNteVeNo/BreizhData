package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util .*;

import model.data.DonneesAnnuelle;

public class DonneesAnnuelleDAO extends DAO <DonneesAnnuelle> {

    public int create(DonneesAnnuelle donnees) {
        String query = "INSERT INTO donneesAnnuelle(nbMaison, nbAppart, prixMoyen, prixM2Moyen, surfaceMoy, depenses, budget, population) VALUES ('" + donnees.getNbMaison() + "','" + donnees.getNbAppart() + "','" + donnees.getPrixMoyen() + "','" + donnees.getPrixM2Moyen() + "','" + donnees.getSurfaceMoy() +"','" + donnees.getDepCulturellesTotales() + "','" + donnees.getBudgetTotal() + "','" + donnees.getPopulation() + " ')";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int update(DonneesAnnuelle donnees) {
        String query = "UPDATE donneesAnnuelle SET depenses='" + donnees.getDepCulturellesTotales() + "', PWD='" + donnees.getPopulation() + "' WHERE depenses='" + donnees.getDepCulturellesTotales() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int delete(DonneesAnnuelle donnees) {

        String query = "DELETE FROM donneesAnnuelle WHERE depenses='" + donnees.getDepCulturellesTotales() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }


    public List <DonneesAnnuelle> findAll () {
        List <DonneesAnnuelle> donnees = new LinkedList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM donneesAnnuelle");
            while (rs.next()) {
                int nbMaison = rs.getInt("nbMaison");
                int nbAppart = rs.getInt("nbAppart");
                Float prixMoyen = rs.getFloat("PrixMoyen");
                Float prixM2Moyen = rs.getFloat("PrixM2Moyen");
                Float surfaceMoy = rs.getFloat("SurfaceMoy");
                Float depenses = rs.getFloat("depenses");
                Float budget = rs.getFloat("budget");
                Float population = rs.getFloat("population");
                donnees.add(new DonneesAnnuelle(nbMaison, nbAppart, prixMoyen, prixM2Moyen, surfaceMoy, depenses, budget, population));
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return donnees;
    }
}
