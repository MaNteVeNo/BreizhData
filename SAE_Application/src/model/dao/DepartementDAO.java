package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util .*;

import model.data.Departement;

public class DepartementDAO extends DAO <Departement> {


    private List<Departement> deps;

    public DepartementDAO() {
        deps = new LinkedList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Departement");
            while (rs.next()) {
                int idDep = rs.getInt("idDep");
                String nomDep = rs.getString("nomDep");
                float invest = rs.getFloat("invesCulturel2019");
                deps.add(new Departement(idDep, nomDep, invest));
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
    }

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

    public Departement findDep(int id) {
        Departement departement = null;
        String query = "SELECT * FROM departement WHERE id=" + id;
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                String nom = rs.getString("nom");
                float invest = rs.getFloat("invesCulturel2019");
                departement = new Departement(id, nom, invest); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return departement;
    }


    public List <Departement> findAll () {
        List <Departement> deps = new LinkedList <>();
        try (Connection con = getConnection (); Statement st = con.createStatement ()) {
            ResultSet rs = st.executeQuery("SELECT * FROM Departement");
            while (rs.next()) {
                int idDep = rs.getInt("idDep");
                String nomDep = rs.getString("nomDep");
                float invest = rs.getFloat("invesCulturel2019");
                deps.add(new Departement(idDep, nomDep, invest));
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        return deps;
    }
}
