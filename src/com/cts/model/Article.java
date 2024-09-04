package com.cts.model;

public class Article {
    private int articleId;
    private int magazineId;
    private String title;
    private String author;
    private String content;
    private String publishDate;

    public Article() {}

    public Article(int magazineId, String title, String author, String content, String publishDate) {
        this.magazineId = magazineId;
        this.title = title;
        this.author = author;
        this.content = content;
        this.publishDate = publishDate;
    }

    // Getters and Setters
    public int getArticleId() { return articleId; }
    public void setArticleId(int articleId) { this.articleId = articleId; }

    public int getMagazineId() { return magazineId; }
    public void setMagazineId(int magazineId) { this.magazineId = magazineId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getPublishDate() { return publishDate; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", magazineId=" + magazineId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", publishDate='" + publishDate + '\'' +
                '}';
    }
}
