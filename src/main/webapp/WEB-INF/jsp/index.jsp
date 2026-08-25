<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


</head>
<body onload="loadPrefix()">
<h2>Prefix CRUD with DWR and Hibernate</h2>

Prefix: <input type="text" id="prefix" />
Gender: <input type="text" id="gender" />
Prefix Of: <input type="text" id="prefixOf" />

<button onclick ="addPrefix()">Add Prefix</button> 

<table border="1">
<thead>
<tr><th>ID</th><th>Prefix</th><th>Gender</th><th>Prefix Of</th><th>Action</th></tr>
</thead>
<tbody id="prefixBody"></tbody>
</table>


</body>


</html>