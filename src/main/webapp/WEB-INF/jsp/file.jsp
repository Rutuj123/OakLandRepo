<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="xlsUploadForm" action="${pageContext.request.contextPath}/api/prefix/upload-excel" 
      method="post" enctype="multipart/form-data">
    <label for="xlsFile">Upload XLS file:</label>
    <input type="file" id="file" name="file" accept=".xls,.xlsx" />
    <button type="submit">Upload</button>
</form>
</body>
</html>