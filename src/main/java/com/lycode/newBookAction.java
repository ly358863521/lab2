package com.lycode;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.impl.resolver.INSURLOperationImpl;
import org.apache.commons.lang3.ObjectUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class newBookAction extends ActionSupport{
    private String isbn;
    private String title;
    private String AuthorID;
    private String Author;
    private String oldAuthor;
    private String publisher;
    private String publishDate;
    private String price;
    private String edit;
    private int age;
    private int oldAge;
    private String country;
    private String oldCountry;

    @Override
    public String execute() throws Exception {
        if(isbn == null || isbn.equals(""))
            return INPUT;
        else
            return addBook();
    }

    public String update() throws Exception{
        if(edit != null){
            if(!this.Author.equals(oldAuthor) || this.age != this.oldAge || !this.country.equals(oldCountry)){
                // 作者信息发生变动，重新增加作者
                Connection connection = ConnectionPool.getInstance().getConnection();
                if(connection != null && !connection.isClosed()){
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Author VALUES (NULL ,?, ?, ?);");
                    preparedStatement.setString(1,this.Author);
                    preparedStatement.setInt(2,this.age);
                    preparedStatement.setString(3,this.country);
                    System.out.println(preparedStatement.executeUpdate());
                    PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * FROM Author WHERE Author = ? AND AGE = ? AND COUNTRY = ?;");
                    preparedStatement1.setString(1,this.Author);
                    preparedStatement1.setInt(2,this.age);
                    preparedStatement1.setString(3,this.country);
                    ResultSet executeQuery = preparedStatement1.executeQuery();
                    executeQuery.next();
                    this.AuthorID = String.format("%d",executeQuery.getInt(0));
                }else
                    return ERROR;
            }
            return addBook();
        }else if(isbn == null || isbn.equals(""))
            return ERROR;
        else{
            Connection connection = ConnectionPool.getInstance().getConnection();
            if (connection != null && !connection.isClosed()) {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT a.*,b.* FROM Author a,Book b WHERE b.ISBN = ? AND a.AuthorID = b.AuthorID;");
                preparedStatement.setString(1,isbn);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    this.title = resultSet.getString("Title");
                    this.Author = resultSet.getString("Author");
                    this.AuthorID = resultSet.getString("AuthorID");
                    this.publishDate = resultSet.getString("PublishDate");
                    this.publisher = resultSet.getString("Publisher");
                    this.price = String.format("%f",resultSet.getFloat("Price"));
                    this.age = resultSet.getInt("age");
                    this.country = resultSet.getString("country");
                }
                connection.close();
            } else {
                return ERROR;
            }
            return INPUT;
        }
    }

    public String addBook()throws Exception{
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("REPLACE INTO Book VALUES (?, ?, ?, ?, ?, ?);");
        preparedStatement.setString(1,isbn);
        try{
            if(title.equals(""))
                preparedStatement.setNull(2, Types.VARCHAR);
            else
                preparedStatement.setString(2,title);
            if(AuthorID.equals("") || AuthorID == null)
                this.AuthorID = ActionContext.getContext().getSession().get("authorID").toString();
            preparedStatement.setInt(3,Integer.parseInt(AuthorID));
            if(publisher.equals(""))
                preparedStatement.setNull(4, Types.VARCHAR);
            else
                preparedStatement.setString(4,publisher);
            if(publishDate.equals(""))
                preparedStatement.setNull(5, Types.VARCHAR);
            else
                preparedStatement.setString(5,publishDate);
            if(price.equals(""))
                preparedStatement.setNull(6, Types.FLOAT);
            else
                preparedStatement.setFloat(6,Float.parseFloat(price));
            System.out.println(preparedStatement.executeUpdate());
        }catch (NullPointerException e) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(String authorID) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOldAuthor() {
        return oldAuthor;
    }

    public void setOldAuthor(String oldAuthor) {
        this.oldAuthor = oldAuthor;
    }

    public int getOldAge() {
        return oldAge;
    }

    public void setOldAge(int oldAge) {
        this.oldAge = oldAge;
    }

    public String getOldCountry() {
        return oldCountry;
    }

    public void setOldCountry(String oldCountry) {
        this.oldCountry = oldCountry;
    }
}
