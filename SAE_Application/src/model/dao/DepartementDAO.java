/*
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util .*;

import model.data.Departement;

public class DepartementDAO extends DAO <Departement> {

    public int create(Departement dep) {
        String query = "INSERT INTO Departement(idDep, nomDep, invesCulturel2019) VALUES ('" + dep.getIdDep() + "','" + dep.getNomDep() + "','" + dep.getInvesCulturel2019() + " ')";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int update(Departement dep) {
        String query = "UPDATE Departement SET idDep='" + dep.getIdDep() + "', PWD='" + dep.getNomDep() + "' WHERE idDep='" + dep.getIdDep() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public int delete(Departement dep) {
        String query = "DELETE FROM Departement WHERE idDep='" + dep.getIdDep() + "'";
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace ();
            return -1;
        }
    }

    public List <Departement> findAll () {
        List <Departement> deps = new LinkedList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Departement");
            while (rs.next()) {
                String idDep = rs.getString("idDep");
                String nomDep = rs.getString("nomDep");
                deps.add(new Departement(idDep, nomDep));
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return deps;
    }
}
*/