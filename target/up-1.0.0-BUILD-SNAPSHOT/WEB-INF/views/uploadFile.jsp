<%--
  Created by IntelliJ IDEA.
  User: sungjaehyun
  Date: 2023/09/18
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>File Upload</title>
    <style>
        a { text-decoration: none; }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h2>파일 업로드</h2>
<form id="uploadForm" action="/board/uploadFile" method="post" enctype="multipart/form-data">
    <input type="file" id="file" name="files" multiple/>
    <br><br>
    <button>Upload File</button>
</form>
</body>
</html>