package model.dao;

import model.data.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<User> {

    private ArrayList<User> users;

    public UserDAO() {
        this.users = new ArrayList<User>();
    }

    @Override
    public List<User> findAll() {
        this.users.clear();
        String query = "SELECT * FROM user";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(new User(
                    rs.getString("prenom"),
                    rs.getString("nom"),
                    rs.getString("email"),
                    rs.getString("mdp"),
                    rs.getBoolean("estAdmin")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    public User findByMail(String mail) {
        String query = "SELECT * FROM user WHERE email = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, mail);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getString("prenom"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getString("mdp"),
                        rs.getBoolean("estAdmin")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(User user) {
        String query = "UPDATE user SET prenom = ?, nom = ?, mdp = ?, estAdmin = ? WHERE email = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getPrenom());
            stmt.setString(2, user.getNom());
            stmt.setString(3, user.getMdp());
            stmt.setBoolean(4, user.isEstAdmin());
            stmt.setString(5, user.getMail());
            for (int i = 0; i < this.users.size(); i++) {
                if (user.getMail().equals(this.users.get(i).getMail())) {
                    this.users.remove(i);
                    this.users.add(user);
                    break;
                }
            }
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(User user) {
        this.users.remove(user);
        String query = "DELETE FROM user WHERE email = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getMail());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int create(User user) {
        this.users.add(user);
        String query = "INSERT INTO user (prenom, nom, email, mdp, estAdmin) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getPrenom());
            stmt.setString(2, user.getNom());
            stmt.setString(3, user.getMail());
            stmt.setString(4, user.getMdp());
            stmt.setBoolean(5, user.isEstAdmin());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
