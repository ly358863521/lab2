<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>详细信息</title>
    <style>
        p{
            font-size:18px;
        }
    </style>
</head>
<body>
    <div class="container notitle">
        <div class="row">
            <div class="col-md-6">
                <p>书名: <s:property value="book.title"/></p>
            </div>
            <div class="col-md-6">
                <p>作者名: <s:property value="book.Author"/></p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <p>作者年龄: <s:property value="age"/></p>
            </div>
            <div class="col-md-6">
                <p>作者国籍: <s:property value="country"/></p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <p>ISBN: <s:property value="book.isbn"/></p>
            </div>
            <div class="col-md-6">
                <p>价格: <s:property value="book.price"/></p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <p>出版社: <s:property value="book.publisher"/></p>
            </div>
            <div class="col-md-6">
                <p>出版日期: <s:property value="book.publishDate"/></p>
            </div>
        </div>
    </div>
</body>
</html>