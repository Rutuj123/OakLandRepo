<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/PrefixDwr.js"></script>

<script type="text/javascript">
function addPrefix() {
    const prefix = document.getElementById("prefix").value;
    const gender = document.getElementById("gender").value;
    const prefixOf = document.getElementById("prefixOf").value;

    PrefixDwr.savePrefix(prefix, gender, prefixOf, function(resp) {
        alert(resp);
        loadPrefix();
    });
}

function loadPrefix() {
    PrefixDwr.listPersonPrefix(function(list) {
        const tbody = document.getElementById("prefixBody");
        tbody.innerHTML = "";
        list.forEach(function(s) {
            tbody.innerHTML += "<tr><td>" + s.id + "</td><td>" + s.prefix + "</td><td>" + s.gender + "</td><td>" + s.prefixOf + "</td><td><button onclick='deletePrefix(" + s.id + ")'>Delete</button></td></tr>";
        });
    });
}

function deletePrefix(id) {
    PrefixDwr.deletePersonPrefix(id, function(resp) {
        alert(resp);
        loadPrefix();
    });
}
</script>
</head>
<body onload="loadPrefix()">
<h2>Prefix CRUD with DWR and Hibernateeeee</h2>
Prefix: <input type="text" id="prefix" />
Gender: <input type="text" id="gender" />
Prefix Of: <input type="text" id="prefixOf" />
<button onclick="addPrefix()">Add Prefix</button>
<table border="1">
<thead>
<tr><th>ID</th><th>Prefix</th><th>Gender</th><th>Prefix Of</th><th>Action</th></tr>
</thead>
<tbody id="prefixBody"></tbody>
</table>
</body>
</html>