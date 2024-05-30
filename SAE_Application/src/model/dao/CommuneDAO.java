package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util .*;

import model.data.Commune;
import model.data.Departement;

public class CommuneDAO extends DAO <Commune> {

    private DepartementDAO departementDAO = new DepartementDAO();

    public int create(Commune commune) {
        String query = "INSERT INTO commune(id, nom, departement) VALUES ('" + commune.getIdCommune() + "','" + commune.getNomCommune() + "','" + commune.getLeDepartement() + " ')";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int update(Commune commune) {
        String query = "UPDATE commune SET nom='" + commune.getNomCommune() + "', PWD='" + commune.getIdCommune() + "' WHERE nom='" + commune.getNomCommune() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int delete(Commune commune) {
        String query = "DELETE FROM commune WHERE nom='" + commune.getNomCommune() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public List <Commune> findAll () {
        List <Commune> communes = new LinkedList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM commune");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                int departement = rs.getInt("leDepartement");

                Departement leDepartement = departementDAO.findDep(departement);
                communes.add(new Commune(id, nom, leDepartement));
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return communes;
    }
}
