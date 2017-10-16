package com.lycode;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class deleteAction extends ActionSupport {
    private String isbn;

    @Override
    public String execute() throws Exception {
        Connection connection = ConnectionPool.getInstance().getConnection();
        if (connection != null && !connection.isClosed()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Book WHERE ISBN = ?");
            preparedStatement.setString(1,isbn);
            preparedStatement.executeUpdate();
            connection.close();
        } else {
            return ERROR;
        }
        return SUCCESS;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
