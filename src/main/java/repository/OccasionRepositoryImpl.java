package repository;

import model.Occasion;
import util.DatabaseUtil;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;



public class OccasionRepositoryImpl implements OccasionRepository{
    @Override
    public List<Occasion> findAll() {
        List<Occasion> occasions = new ArrayList<>();
        String sql = "SELECT * FROM occasions";
        try (Connection conn = DatabaseUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                occasions.add(mapResultSetToOccasion(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null; // TODO: Implement this method to retrieve all occasions
    }



    @Override
    public Occasion findById(int id) {
        String sql = "SELECT * FROM occasions  WHERE id = ?";
        try ( Connection conn = DatabaseUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToOccasion(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Occasion occasion) {
        String sql = "INSECT INTO occasions (name, description, date, location) VALAUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, occasion.getName());
            stmt.setString(2, occasion.getDescription());
            stmt.setString(3, occasion.getDate());
            stmt.setString(4, occasion.getLocation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving occasion: " + e.getMessage(), e);
        }
    }


    @Override
    public void update(Occasion occasion) {
        String sql = "UPDATE occasions SET name = ?, description = ?, date = ?, Location = ? WHERE id = ?";
         try(Connection conn = DatabaseUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setString(1, occasion.getName());
             stmt.setString(2, occasion.getDescription());
             stmt.setString(3, occasion.getDate());
                stmt.setString(4, occasion.getLocation());
                stmt.executeQuery();
         } catch (SQLException e) {
             e.printStackTrace();
             throw new RuntimeException("Error updating occasion: " + e.getMessage(), e);
         }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM occasions WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();

        )

        return; // TODO: Implement this method to delete an occasion by its ID
    }


    private Occasion mapResultSetToOccasion(ResultSet rs) {
        return null;


    }

}
