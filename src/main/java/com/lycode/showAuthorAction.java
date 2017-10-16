package com.lycode;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class showAuthorAction extends ActionSupport {
    private List<Author> authorList;
    @Override
    public String execute() throws Exception {
        Connection connection = ConnectionPool.getInstance().getConnection();
        if (connection == null) {
            return ERROR;
        }
        ResultSet resultSet = connection.prepareStatement("SELECT * FROM Author;").executeQuery();
        authorList = new ArrayList<>(100);
        while(resultSet.next())
            authorList.add(new Author(resultSet));
        return SUCCESS;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
