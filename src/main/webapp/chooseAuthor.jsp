<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>选择作者</title>
</head>
<body>
    <div class="container notitle">
        <div class="row">
            <h2>选择作者</h2>
        </div>
        <div class="row">
            <s:iterator value="authorList">
                <div class="radio"><label><input type="radio" name="optionsRadios" onclick="setNode(<s:property value="AuthorID"/>)"><s:property value="Author"/></label></div>
            </s:iterator>
        </div>
        <div class="row">
            <s:form action="selectAuthor.action">
                <input type="hidden" value="" id="authorID" name="authorID">
                <button class="btn btn-default" type="submit">下一步</button>
            </s:form>
        </div>
        <div class="row">
            <h3>手动添加新作者</h3>
        </div>
        <s:form action="newAuthor.action">
            <div class="row">
                <div class="col-md-4"><label for="name">名字</label><input type="text" class="form-control" id="name"
                                                                         name="name"></div>
                <div class="col-md-4"><label for="age">年龄</label><input type="number" class="form-control" id="age"
                                                                        name="age"></div>
                <div class="col-md-4"><label for="country">国家</label><input type="text" class="form-control"
                                                                            id="country" name="country"></div>
            </div>
            <div class="row">
                <button type="submit" class="btn btn-default pull-right">创建新作者</button>
            </div>
        </s:form>
    </div>
<script type="text/javascript">
    function setNode(text) {
        $("#authorID")[0].value = text;
    }
</script>
</body>
</html>