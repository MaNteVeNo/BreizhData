package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.data.Commune;
import model.data.Gare;

public class GareDAO extends DAO<Gare> {


    private CommuneDAO communeDAO = new CommuneDAO();

    private ArrayList<Gare> gares;


    public GareDAO() {
        this.gares = new ArrayList<Gare>();
    }

    public int create(Gare gare) {
        this.gares.add(gare);
        String query = "INSERT INTO gare(code, nom, estFret, estVoyageur) VALUES ('" + gare.getCodeGare() + "','" + gare.getNomGare() + "','" + gare.getEstFret() + "','" + gare.getEstVoyageur() + "','" + gare.getLaCommune().getIdCommune() + "')";
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int update(Gare gare) {
        String query = "UPDATE gare SET nom='" + gare.getNomGare() + "', estFret='" + gare.getEstFret() + "', estVoyageur='" + gare.getEstVoyageur() + "' WHERE code='" + gare.getCodeGare() + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            for (int i = 0; i < this.gares.size(); i++) {
                if (gare.getCodeGare() == this.gares.get(i).getCodeGare()) {
                    this.gares.remove(i);
                    this.gares.add(gare);
                }
            }
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int delete(Gare gare) {
        this.gares.remove(gare);
        String query = "DELETE FROM gare WHERE code='" + gare.getCodeGare() + "'";
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            return st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public List<Gare> findAll() {
        this.gares.clear(); // Nettoyer la liste actuelle avant d'ajouter les gares récupérées
        try (Connection con = getConnection(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM gare");
            while (rs.next()) {
                int code = rs.getInt("code");
                String nom = rs.getString("nom");
                boolean estFret = rs.getBoolean("estFret");
                boolean estVoyageur = rs.getBoolean("estVoyageur");
                int comm = rs.getInt("laCommune");

                Commune commune = communeDAO.findComm(comm);
                this.gares.add(new Gare(code, nom, estFret, estVoyageur, commune));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.gares;
    }
}
