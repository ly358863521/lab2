<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>增加书</title>
</head>
<body>
<div class="container notitle">
    <div class="row">
        <h2>增加书</h2>
    </div>
    <s:form action="newBook">
        <div class="form-group">
            <div class="row">
                <div class="col-md-6"><input type="isbn" class="form-control" id="isbn" name="isbn"><label for="isbn">ISBN</label></div>
                <div class="col-md-6"><input type="text" class="form-control" id="title" name="title"><label for="title">题目</label></div>
            </div>
            <div class="row">
                <div class="col-md-6"><input type="text" class="form-control" id="publisher" name="publisher"><label for="publisher">出版商</label></div>
                <div class="col-md-6"><input type="text" class="form-control" id="pubdate" name="publishDate"><label for="pubdate">出版日期</label></div>
            </div>
            <div class="row">
                <div class="col-md-6"><input type="text" class="form-control" id="price" name="price"><label for="price">价格</label></div>
                <div class="col-md-6"><input type="text" class="form-control" id="author" name="Author"><label for="author">作者</label></div>
            </div>
            <input type="hidden" value="<s:property value="AuthorID"/>" name="AuthorID">
            <div class="row">
                <button type="submit" class="btn btn-default">增加</button>
            </div>
        </div>
    </s:form>
</div>
</body>
</html>