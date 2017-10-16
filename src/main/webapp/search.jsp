<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>搜索</title>
</head>
<body>
<div class="container notitle">
    <div class="row center-block">
        <form action="">
            作者名:<input type="text" id="authorName" class="form-control" name="authorName">
            <button class="btn btn-default" type="submit">搜索</button>
        </form>
    </div>
    <div class="row center-block">
        <button class="btn btn-default" onclick="window.location.href='showAuthor.action'">增加书</button>
    </div>
    <div class="row">
        <p>如果出现数据库错误，请返回上一步刷新</p>
    </div>
</div>
</body>
</html>