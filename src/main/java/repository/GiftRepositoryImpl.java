package repository;

import model.Gift;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GiftRepositoryImpl implements GiftRepository {
    @Override
    public void save(Gift gift) {
        String sql = "INSERT INTO gifts (name, description, price, isPurchased, recipientId, occasionId, gifterId) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, gift.getName());
            stmt.setString(2, gift.getDescription());
            stmt.setDouble(3, gift.getPrice());
            stmt.setBoolean(4, gift.isPurchased());
            stmt.setInt(5, gift.getRecipientId());
            stmt.setInt(6, gift.getOccasionId());
            stmt.setInt(7, gift.getGifterId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Gift findById(int id) {
        String sql = "SELECT * FROM gifts WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToGift(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Gift> findAll() {
        List<Gift> gifts = new ArrayList<>();
        String sql = "SELECT * FROM gifts";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                gifts.add(mapResultSetToGift(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gifts;
    }

    @Override
    public void update(Gift gift) {
        String sql = "UPDATE gifts SET name=?, description=?, price=?, isPurchased=?, recipientId=?, occasionId=?, gifterId=? WHERE id=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, gift.getName());
            stmt.setString(2, gift.getDescription());
            stmt.setDouble(3, gift.getPrice());
            stmt.setBoolean(4, gift.isPurchased());
            stmt.setInt(5, gift.getRecipientId());
            stmt.setInt(6, gift.getOccasionId());
            stmt.setInt(7, gift.getGifterId());
            stmt.setInt(8, gift.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM gifts WHERE id=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Gift mapResultSetToGift(ResultSet rs) throws SQLException {
        return new Gift(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getDouble("price"),
            rs.getBoolean("isPurchased"),
            rs.getInt("recipientId"),
            rs.getInt("occasionId"),
            rs.getInt("gifterId")
        );
    }
} 