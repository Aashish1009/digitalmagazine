package com.cts.dao;

import com.cts.model.Article;
import com.cts.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {

    public void addArticle(Article article) {
        String query = "INSERT INTO Article (magazine_id, title, author, content, publish_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, article.getMagazineId());
            stmt.setString(2, article.getTitle());
            stmt.setString(3, article.getAuthor());
            stmt.setString(4, article.getContent());
            stmt.setString(5, article.getPublishDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        String query = "SELECT * FROM Article";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Article article = new Article();
                article.setArticleId(rs.getInt("article_id"));
                article.setMagazineId(rs.getInt("magazine_id"));
                article.setTitle(rs.getString("title"));
                article.setAuthor(rs.getString("author"));
                article.setContent(rs.getString("content"));
                article.setPublishDate(rs.getString("publish_date"));
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public void updateArticle(Article article) {
        String query = "UPDATE Article SET magazine_id = ?, title = ?, author = ?, content = ?, publish_date = ? WHERE article_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, article.getMagazineId());
            stmt.setString(2, article.getTitle());
            stmt.setString(3, article.getAuthor());
            stmt.setString(4, article.getContent());
            stmt.setString(5, article.getPublishDate());
            stmt.setInt(6, article.getArticleId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteArticle(int articleId) {
        String query = "DELETE FROM Article WHERE article_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, articleId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
