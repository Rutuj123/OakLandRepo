<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet"
	      href="https://cdnjs.cloudflare.com/ajax/libs/extjs/6.0.0/classic/theme-crisp/resources/theme-crisp-all.css">

	<script src="https://cdnjs.cloudflare.com/ajax/libs/extjs/6.0.0/ext-all.js"></script>	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

	<!-- DataTables CSS -->
	<link rel="stylesheet" href="https://cdn.datatables.net/1.13.8/css/jquery.dataTables.min.css">

	<!-- DataTables JS -->
	<script src="https://cdn.datatables.net/1.13.8/js/jquery.dataTables.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/dwr/interface/PrefixDwr.js"></script>
</head>
<body>
<h1>Welcome, jenkin is working..</h1>
<script src="js/tab5.js"></script>
<script src="js/tab1.js"></script>
<script src="js/tab2.js"></script>
<script src="js/tab3.js"></script>
<script src="js/tab4.js"></script>

<script src="js/app.js"></script> 
<script type="text/javascript">
function addPrefix() {
	alert("in add..");
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
</body>
</html>