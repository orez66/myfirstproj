<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" >
<title>������</title>
<meta charset="utf-8">
<script type="text/javascript"  src="zimmer.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body >
<h1>���� ������</h1>
<section>
<table id="tablezimmer" border = 3 >
		<thead>
		<tr><th> �� ���� </th><th> ���� ���� </th><th colspan=2>�����</th></tr>
		</thead>
		
		<tbody>
		
		<c:forEach items="${zimmerl}" var="ziml" >
				<tr>
				<td> <c:out value = "${ ziml.zimmer_name}"/> </td>
				<td> <c:out value = "${ ziml.zimmer_id}"/> </td>
				<td> <a href="#" onclick = "deletezim(<c:out value = "${ ziml.zimmer_id}"/>)">�����</a> </td>
				<td> <a href="#" onclick = "updatezim(<c:out value = "${ ziml.zimmer_id}"/>)">�����</a> </td>
				</tr>
		</c:forEach>	
		</tbody>
				<td><a href="#" onclick = "addzim()">�����</a> </td>
		
</table>
</section>




</body>
</html>