package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util .*;

import model.data.Annee;
import model.data.Departement;

public class AnneeDAO extends DAO <Annee> {

    public int create(Annee annee) {
        String query = "INSERT INTO gare(annee, inflation) VALUES ('" + annee.getAnnee() + "','" + annee.getTauxInflation() +" ')";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int update(Annee annee) {
        String query = "UPDATE annee SET annee='" + annee.getAnnee() + "', PWD='" + annee.getTauxInflation() + "' WHERE annee='" + annee.getAnnee() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int delete(Annee annee) {
        String query = "DELETE FROM annee WHERE annee='" + annee.getAnnee() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }


    public List <Annee> findAll () {
        List <Annee> annees = new LinkedList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM annee");
            while (rs.next()) {
                int annee = rs.getInt("annee");
                Float tauxInflation = rs.getFloat("tauxInflation");
                annees.add(new Annee(annee, tauxInflation));
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return annees;
    }
}
