<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" >
<title>טופס צימרים</title>
<meta charset="utf-8">
<script type="text/javascript"  src="zimmer.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body onload = "doadd()">
<h1>טופס צימרים</h1>
<section>
<form dir = "rtl" action = "zimmerControllerAj" method = "post" name ="dos" id="formzim" accept-charset=UTF-8 >
<fieldset>
<div>
<label for = "name">שם צימר:</label>
<input type = "text" name = "name"  value = "<c:out value = "${zimmerf.zimmer_name}"/>"/> 
</div>
<div>
<label for = "id" id = "idlabel">מספר צימר:</label>
<input  type = "text" id = "id" name = "id"  value = "<c:out value = "${zimmerf.zimmer_id}"/>"/>   
 </div>
   
<input type="submit" value= "Update" onclick = "{document.dos.action_type.value = this.value;updatezim2();}"/>

<input type="submit" value= "Add" onclick = "{document.dos.action_type.value = this.value;addzim2();}"/>

<input type ="hidden" name = "action_type"/>
 
</fieldset>
</form>
</section>



</body>
</html>