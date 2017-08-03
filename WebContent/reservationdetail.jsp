<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" >
<title>פרטי הזמנה</title>
<meta charset="utf-8">
<script type="text/javascript"  src="reservationdetail.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body >
<h1>טבלת צימרים</h1>
<section>
<table id="tablereservationdetail" border = 3 >
		<thead>
		<tr><th> זיהוי פרטי הזמנה </th> <th> מספר צימר </th><th> מספר מבוגרים </th> <th> מספר תינוקות </th> <th> בקשות מיוחדות </th> <th> תאריך התחלה </th><th> תאריך סיום </th><th colspan=2>פעולה</th></tr>
		</thead>
		
		<tbody>
		
		<c:forEach items="${reservationdetaill}" var="resdetl" >
				<tr>
				<td> <c:out value = "${ resdetl.reservation_detail_id}"/> </td>
				<td> <c:out value = "${ resdetl.zimmer_id}"/> </td>
				<td> <c:out value = "${ resdetl.num_of_guests}"/> </td>
				<td> <c:out value = "${ resdetl.baby}"/> </td>
				<td> <c:out value = "${ resdetl.notes}"/> </td>
				<td> <c:out value = "${ resdetl.start_date}"/> </td>
				<td> <c:out value = "${ resdetl.end_date}"/> </td>
				<td> <a href="#" onclick = "deleteresdet(<c:out value = "${ resdetl.reservation_detail_id}"/>)">מחיקה</a> </td>
				<td> <a href="#" onclick = "updateresdet(<c:out value = "${ resdetl.reservation_detail_id}"/>)">עדכון</a> </td>
				</tr>
		</c:forEach>	
		</tbody>
				<td><a href="#" onclick = "addresdet()">הוספה</a> </td>
		
</table>
</section>




</body>
</html>