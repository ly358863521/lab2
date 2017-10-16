package com.lycode;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Author {
    private Integer AuthorID;
    private String Author;
    private Short age;
    private String country;

    public Author() {}

    public Author(ResultSet resultSet) throws SQLException {
        this.age = resultSet.getShort("Age");
        this.AuthorID = resultSet.getInt("AuthorID");
        this.country = resultSet.getString("Country");
        this.AuthorID = resultSet.getInt("AuthorID");
        this.Author = resultSet.getString("Author");
    }

    public Integer getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(Integer authorID) {
        AuthorID = authorID;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
