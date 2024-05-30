package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.data.Commune;
import model.data.Departement;

public class CommuneDAO extends DAO<Commune> {

    private List<Commune> comms;
    private DepartementDAO departementDAO = new DepartementDAO();

    public CommuneDAO() {
        this.comms = new LinkedList<>();
    }

    public int create(Commune commune) {
        this.comms.add(commune);
        String query = "INSERT INTO commune(id, nom, departement) VALUES ('" + commune.getIdCommune() + "','" + commune.getNomCommune() + "','" + commune.getLeDepartement()+ "')";
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int update(Commune commune) {
        String query = "UPDATE commune SET nom='" + commune.getNomCommune() + "', PWD='" + commune.getIdCommune() + "' WHERE nom='" + commune.getNomCommune() + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            for (int i = 0; i < this.comms.size(); i++) {
                if (commune.getNomCommune().equals(this.comms.get(i).getNomCommune())) {
                    this.comms.remove(i);
                    this.comms.add(commune);
                    break;
                }
            }
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int delete(Commune commune) {
        this.comms.remove(commune); 
        String query = "DELETE FROM commune WHERE nom='" + commune.getNomCommune() + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public Commune findComm(int id) {
        Commune comm = null;
        String query = "SELECT * FROM Commune WHERE idCommune=" + id;
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                String nom = rs.getString("nomCommune");
                int dep = rs.getInt("leDepartement");

                Departement leDepartement = departementDAO.findDep(dep);
                comm = new Commune(id, nom, leDepartement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return comm;
    }

    public List<Commune> findAll() {
        this.comms.clear(); 
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM commune");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                int departement = rs.getInt("departement");

                Departement leDepartement = departementDAO.findDep(departement);
                Commune commune = new Commune(id, nom, leDepartement);
                this.comms.add(commune);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.comms;
    }
}
