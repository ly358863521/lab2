package com.lycode;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class detailAction extends ActionSupport {
    private String isbn;
    private Book book;
    private Integer age;
    private String country;
    @Override
    public String execute() throws Exception {
        Connection connection = ConnectionPool.getInstance().getConnection();
        if (connection == null || connection.isClosed()) {
            return ERROR;
        }
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT a.*,b.* FROM Author a,Book b where a.AuthorID = b.AuthorID AND b.ISBN = ?;");
        preparedStatement.setString(1,isbn);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        book = new Book(resultSet);
        age = resultSet.getInt("AGE");
        country = resultSet.getString("country");
        return SUCCESS;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
