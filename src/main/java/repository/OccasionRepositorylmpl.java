package repository;

import model.Occasion;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OccasionRepositorylmpl implements OccasionRepository {
    @Override
    public void save(Occasion occasion) {
        String sql = "INSERT INTO occasions (name, description, date, location) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, occasion.getName());
            stmt.setString(2, occasion.getDescription());
            stmt.setString(3, occasion.getDate());
            stmt.setString(4, occasion.getLocation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Occasion findById(int id) {
        String sql = "SELECT * FROM occasions WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
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
            e.printStackTrace();
        }
        return occasions;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM occasions WHERE id=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Occasion mapResultSetToOccasion(ResultSet rs) throws SQLException {
        return new Occasion(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getString("date"),
            rs.getString("location")
        );
    }
}