package com.cts.dao;

import com.cts.model.Subscription;
import com.cts.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDAO {

    public void addSubscription(Subscription subscription) {
        String query = "INSERT INTO Subscription (user_id, magazine_id, subscription_date, expiry_date, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, subscription.getUserId());
            stmt.setInt(2, subscription.getMagazineId());
            stmt.setString(3, subscription.getSubscriptionDate());
            stmt.setString(4, subscription.getExpiryDate());
            stmt.setString(5, subscription.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Subscription> getAllSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        String query = "SELECT * FROM Subscription";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Subscription subscription = new Subscription();
                subscription.setSubscriptionId(rs.getInt("subscription_id"));
                subscription.setUserId(rs.getInt("user_id"));
                subscription.setMagazineId(rs.getInt("magazine_id"));
                subscription.setSubscriptionDate(rs.getString("subscription_date"));
                subscription.setExpiryDate(rs.getString("expiry_date"));
                subscription.setStatus(rs.getString("status"));
                subscriptions.add(subscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscriptions;
    }

    public void updateSubscription(Subscription subscription) {
        String query = "UPDATE Subscription SET user_id = ?, magazine_id = ?, subscription_date = ?, expiry_date = ?, status = ? WHERE subscription_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, subscription.getUserId());
            stmt.setInt(2, subscription.getMagazineId());
            stmt.setString(3, subscription.getSubscriptionDate());
            stmt.setString(4, subscription.getExpiryDate());
            stmt.setString(5, subscription.getStatus());
            stmt.setInt(6, subscription.getSubscriptionId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancelSubscription(int subscriptionId) {
        String query = "DELETE FROM Subscription WHERE subscription_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, subscriptionId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
