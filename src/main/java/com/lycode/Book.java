package com.lycode;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
    private String isbn;
    private String title;
    private String Author;
    private Integer AuthorID;
    private String publisher;
    private String publishDate;
    private Float price;

    public Book() {
    }

    public Book(ResultSet resultSet)throws SQLException {
        this.AuthorID = resultSet.getInt("AuthorID");
        this.isbn = resultSet.getString("ISBN");
        this.publishDate = resultSet.getString("PublishDate");
        this.price = resultSet.getFloat("Price");
        this.title = resultSet.getString("Title");
        this.publisher = resultSet.getString("Publisher");
        this.Author = resultSet.getString("Author");
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Integer getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(Integer authorID) {
        AuthorID = authorID;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
