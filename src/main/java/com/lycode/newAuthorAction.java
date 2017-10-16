package com.lycode;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class newAuthorAction extends ActionSupport {
    private String name;
    private String age;
    private String country;

    @Override
    public String execute() throws Exception {
        Connection connection = ConnectionPool.getInstance().getConnection();
        if (connection != null && !connection.isClosed()) {
            PreparedStatement preparedStatement = connection.prepareStatement("REPLACE INTO Author VALUES (NULL ,?, ?, ?);");
            if(name != null && !name.equals(""))
                preparedStatement.setString(1,name);
            else
                return INPUT;
            if(age != null && !age.equals(""))
                try {
                    preparedStatement.setInt(2, Integer.parseInt(age));
                }catch (Exception e) {
                    return ERROR;
                }
            else
                preparedStatement.setNull(2, Types.TINYINT);
            if(country != null && !country.equals(""))
                preparedStatement.setString(3,country);
            else
                preparedStatement.setNull(3,Types.VARCHAR);
            System.out.println(preparedStatement.executeUpdate());
            PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM Author WHERE Author = ?;");
            preparedStatement1.setString(1,name);
            ResultSet executeQuery = preparedStatement1.executeQuery();
            executeQuery.next();
            Integer authorID = executeQuery.getInt(1);
            ActionContext.getContext().getSession().put("authorID",authorID);
            connection.close();
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
