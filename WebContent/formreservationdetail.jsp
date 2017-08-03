<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" >
<title>טופס צימרים</title>
<meta charset="utf-8">
<script type="text/javascript"  src="reservationdetail.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body onload = "doadd()">
<h1>טופס פרטי הזמנה</h1>
<section>
<form dir = "rtl" action = "reservationdetailControllerAj" method = "post" name ="ros" id="formresdet" accept-charset=UTF-8 >
<fieldset>
<div>
<label for = "id" id = "idlabel">זיהוי פרטי הזמנה:</label>
<input  type = "text" id = "id" name = "id"  value = "<c:out value = "${reservationdetailf.reservation_detail_id}"/>"/>     
 </div>
<div>
<label for = "idzimmer">מספר צימר:</label>
<input type = "text" name = "idzimmer"  value = "<c:out value = "${reservationdetailf.zimmer_id}"/>"/> 
</div>
<div>
<label for = "numguests"> מספר מבוגרים:</label>
<input type = "text" name = "numguests"  value = "<c:out value = "${reservationdetailf.num_of_guests}"/>"/> 
</div>
<div>
<label for = "baby"> מספר תינוקות:</label>
<input type = "text" name = "baby"  value = "<c:out value = "${reservationdetailf.baby}"/>"/> 
</div>
<div>
<label for = "notes"> בקשות מיוחדות:</label>
<input type = "text" name = "notes"  value = "<c:out value = "${reservationdetailf.notes}"/>"/> 
  </div> 
<div>
<label for = "startdate" >תאריך התחלה:</label>
<input  type = "text" id = "startdate" name = "id"  value = "<c:out value = "${reservationdetailf.start_date}"/>"/>   
 </div> 
 <div>
<label for = "enddate" >תאריך סיום:</label>
<input  type = "text" id = "enddate" name = "id"  value = "<c:out value = "${reservationdetailf.end_date}"/>"/>   
 </div> 
 
 
<input type="submit" value= "Update" onclick = "{document.dos.action_type.value = this.value;updateresdet2();}"/>

<input type="submit" value= "Add" onclick = "{document.dos.action_type.value = this.value;addresdet2();}"/>

<input type ="hidden" name = "action_type"/>
 
</fieldset>
</form>
</section>



</body>
</html>