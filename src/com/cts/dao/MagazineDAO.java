package com.cts.dao;

import com.cts.model.Magazine;
import com.cts.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagazineDAO {

    public void addMagazine(Magazine magazine) {
        String query = "INSERT INTO Magazine (title, genre, publication_frequency, publisher) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, magazine.getTitle());
            stmt.setString(2, magazine.getGenre());
            stmt.setString(3, magazine.getPublicationFrequency());
            stmt.setString(4, magazine.getPublisher());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Magazine> getAllMagazines() {
        List<Magazine> magazines = new ArrayList<>();
        String query = "SELECT * FROM Magazine";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Magazine magazine = new Magazine();
                magazine.setMagazineId(rs.getInt("magazine_id"));
                magazine.setTitle(rs.getString("title"));
                magazine.setGenre(rs.getString("genre"));
                magazine.setPublicationFrequency(rs.getString("publication_frequency"));
                magazine.setPublisher(rs.getString("publisher"));
                magazines.add(magazine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return magazines;
    }

    public void updateMagazine(Magazine magazine) {
        String query = "UPDATE Magazine SET title = ?, genre = ?, publication_frequency = ?, publisher = ? WHERE magazine_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, magazine.getTitle());
            stmt.setString(2, magazine.getGenre());
            stmt.setString(3, magazine.getPublicationFrequency());
            stmt.setString(4, magazine.getPublisher());
            stmt.setInt(5, magazine.getMagazineId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMagazine(int magazineId) {
        String query = "DELETE FROM Magazine WHERE magazine_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, magazineId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
