package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util .*;

import model.data.Aeroport;

public class AeroportDAO extends DAO <Aeroport> {

    public int create(Aeroport aer) {
        String query = "INSERT INTO aeroport(nom, adresse) VALUES ('" + aer.getNom() + "','" + aer.getAdresse() + " ')";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int update(Aeroport aer) {
        String query = "UPDATE aeroport SET nom='" + aer.getNom() + "', PWD='" + aer.getAdresse() + "' WHERE nom='" + aer.getNom() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int delete(Aeroport aer) {
        String query = "DELETE FROM aeroport WHERE nom='" + aer.getNom() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public List <Aeroport> findAll () {
        List <Aeroport> aers = new LinkedList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM aeroport");
            while (rs.next()) {
                String nom = rs.getString("nom");
                String adresse = rs.getString("adresse");
                aers.add(new Aeroport(nom, adresse));
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return aers;
    }
}