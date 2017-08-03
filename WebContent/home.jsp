<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>פרוייקט צימרים</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="zimmer.js"></script>
  <script src="reservationdetail.js"></script>
  <link rel="stylesheet" href="orez.css">
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage">לוגו</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li ><a  href="#ZIMMERS">רשימת צימרים</a></li>
        <li ><a  href="#RESERVATIONDETAILS">פרטי הזמנה</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- Container (About Section) -->
<div id="ZIMMERS" class="container-fluid">
  <div class="row">
   		 <div class="col-sm-8">
        <h2>רשימת צימרים</h2>
       
       
     	 <table id = "tablezimmer">
		<div id = "zim_rows"></div>
    	</table>
   		</div>
   		 
    <div class="col-sm-4">
   <div id="formzimupdate"></div>
    </div>
  </div>
</div>

<div id="RESERVATIONDETAILS" class="container-fluid">
  <div class="rowp">
   		 <div class="col-sm-8">
        <h2>פרטי הזמנה</h2>
       
       
     	 <table id = "tablereservatindetail">
		<div id = "resdet_rows"></div>
    	</table>
   	 </div>
   	 	 
    <div class="col-sm-4">
   <div id="formresdetupdate"></div>
    </div>
  </div>
</div>



</body>
</html>

</body>
</html>