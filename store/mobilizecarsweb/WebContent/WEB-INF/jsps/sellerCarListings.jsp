<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=utf-8 />
<title></title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<link href="../../css/results.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript">
//$(function(){   $("#content").load("mainPage_2.html"); }); 
</script>
</head>
<body>
<!--<div name="content" id="content" style="height:130px; width:1200px; background-color:#ffcc99; float:left; margin:0px 0px 0px 0px"></div>
<fieldset  style="margin-left:300px; height:300px; width:600px; float:left; border:solid thick" >-->
<fieldset >
<legend>Seller Car Listings</legend>
<div class="divTable">
  <div class="headRow">
    <div class="divCell">Make</div>
    <div  class="divCell">Model</div>
    <div  class="divCell">Year</div>
  </div>
    <c:forEach var="detBean" items="${carsList}">
	  <div class="divRow">
	    <div class="divCell">${detBean.make}</div>
	    <div class="divCell">${detBean.model}</div>
	    <div class="divCell">${detBean.year}</div>
	  </div>
   </c:forEach> 
</div>
</fieldset>
</body>
</html>
