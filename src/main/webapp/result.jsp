<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script defer src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="styles/global.css">
</head>
<body>
<div class="container notitle">
    <div class="row">
        <h2>搜索结果</h2>
    </div>
    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>ISBN</th>
                <th>出版社</th>
                <th>出版日期</th>
                <th>价格</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="bookList"><tr>
                <td onclick="window.location.href='detail.action?isbn=<s:property value="isbn"/>'"><s:property value="title"/></td>
                <td onclick="window.location.href='detail.action?isbn=<s:property value="isbn"/>'"><s:property value="Author"/></td>
                <td onclick="window.location.href='detail.action?isbn=<s:property value="isbn"/>'"><s:property value="ISBN"/></td>
                <td onclick="window.location.href='detail.action?isbn=<s:property value="isbn"/>'"><s:property value="publisher"/></td>
                <td onclick="window.location.href='detail.action?isbn=<s:property value="isbn"/>'"><s:property value="publishDate"/></td>
                <td onclick="window.location.href='detail.action?isbn=<s:property value="isbn"/>'"><s:property value="price"/></td>
                <td>
                    <span class="glyphicon glyphicon-pencil" aria-hidden="true" onclick="window.location.href='editBook.action?isbn=<s:property value="isbn"/>'"></span>
                </td>
                <td>
                    <span class="glyphicon glyphicon-remove" aria-hidden="true" onclick="window.location.href='delete.action?isbn=<s:property value="isbn"/>'"></span>
                </td>
            </tr></s:iterator>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>