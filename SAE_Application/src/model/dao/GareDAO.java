package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util .*;

import model.data.Gare;

public class GareDAO extends DAO <Gare> {

    public int create(Gare gare) {
        String query = "INSERT INTO gare(code, nom, estFret, estVoyageur) VALUES ('" + gare.getCodeGare() + "','" + gare.getNomGare() + "','" + gare.getEstFret() + "','" + gare.getEstVoyageur() +" ')";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int update(Gare gare) {
        String query = "UPDATE gare SET nom='" + gare.getNomGare() + "', PWD='" + gare.getCodeGare() + "' WHERE nom='" + gare.getNomGare() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int delete(Gare gare) {
        String query = "DELETE FROM gare WHERE nom='" + gare.getNomGare() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public List <Gare> findAll () {
        List <Gare> gares = new LinkedList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM gare");
            while (rs.next()) {
                int code = rs.getInt("code");
                String nom = rs.getString("nom");
                Boolean estFret = rs.getBoolean("estFret");
                Boolean estVoyageur = rs.getBoolean("estVoyageur");
                gares.add(new Gare(code, nom, estFret, estVoyageur));
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return gares;
    }
}
