package com.lycode;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class searchAction extends ActionSupport{
    private String authorName;
    private List<Book> bookList;

    @Override
    public String execute() throws Exception {
        if(authorName == null || authorName.equals(""))
            return INPUT;
        if (bookList == null) {
            bookList = new ArrayList<Book>();
        }
        Connection connection = ConnectionPool.getInstance().getConnection();
        if (connection != null && !connection.isClosed()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT a.*,b.* FROM Author a,Book b where a.AuthorID = b.AuthorID AND a.Author = ?;");
            preparedStatement.setString(1,authorName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                bookList.add(new Book(resultSet));
            }
            connection.close();
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}


