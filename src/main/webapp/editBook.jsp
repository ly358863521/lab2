<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>更新书</title>
</head>
<body>
<div class="container notitle">
    <div class="row">
        <h2>更新书</h2>
    </div>
    <s:form action="editBook.action">
        <div class="form-group">
            <div class="row">
                <div class="col-md-6"><input type="isbn" class="form-control" id="isbn" name="isbn" value="<s:property value="isbn"/>"><label for="isbn">ISBN</label></div>
                <div class="col-md-6"><input type="text" class="form-control" id="title" name="title" value="<s:property value="title"/>"><label for="title">题目</label></div>
            </div>
            <div class="row">
                <div class="col-md-6"><input type="text" class="form-control" id="publisher" name="publisher" value="<s:property value="publisher"/>"><label for="publisher">出版商</label></div>
                <div class="col-md-6"><input type="text" class="form-control" id="pubdate" name="publishDate" value="<s:property value="publishDate"/>"><label for="pubdate">出版日期</label></div>
            </div>
            <div class="row">
                <div class="col-md-6"><input type="text" class="form-control" id="price" name="price" value="<s:property value="price"/>"><label for="price">价格</label></div>
                <div class="col-md-6"><input type="text" class="form-control" id="author" name="Author" value="<s:property value="Author"/>"><label for="author">作者</label></div>
            </div>
            <div class="row">
                <div class="col-md-6"><input type="number" class="form-control" value="<s:property value="age"/>" id="age" name="age"><label for="age"></label></div>
                <div class="col-md-6"><input type="text" class="form-control" value="<s:property value="country"/>" id="country" name="country"><label for="country"></label></div>
            </div>
            <input type="hidden" value="<s:property value="AuthorID"/>" name="AuthorID">
            <input type="hidden" value="<s:property value="Author"/>" name="oldAuthor">
            <input type="hidden" value="<s:property value="age"/>" name="oldAge">
            <input type="hidden" value="<s:property value="country"/>" name="oldCountry">
            <input type="hidden" value="true" name="edit">
            <div class="row">
                <button type="submit" class="btn btn-default">更新</button>
            </div>
        </div>
    </s:form>
</div>
</body>
</html>