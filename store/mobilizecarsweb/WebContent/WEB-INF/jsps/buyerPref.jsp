<%@ page isErrorPage="true"  errorPage=".errorPage.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=utf-8 />
<title></title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<style>
label {
	display:block;
	float:left;
	clear:both;
	font-weight:bold;
	width:110px;	
}
</style>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript">
//$(function(){   $("#content").load("mainPage_2.html"); }); 
</script>
</head>
<body>
<!--<div name="content" id="content" style="height:130px; width:1200px; background-color:#ffcc99; float:left; margin:0px 0px 0px 0px"></div>
<fieldset  style="margin-left:300px; height:300px; width:600px; float:left; border:solid thick" >-->
<fieldset >
<legend>Byers Preferences</legend>
<div>
  <label for="year">Year:</label>
  <input type="number" name="year" id="year" value="${userPref2.year}" required>
</div>
<div>
  <label for="make">Make:</label>
  <input type="text" name="make" id="make" value="${userPref2.make}" required>
</div>
<div>
  <label for="model">Model:</label>
  <input type="text" name="model" id="model" value="${userPref2.model}" required>
</div>
<div>
  <label for="mileage">Mileage:</label>
  <input type="number" name="mileage" id="mileage" value="${userPref2.mileage}" required>
</div>
<div>
  <label for="color">color:</label>
  <input type="color" name="color" id="color" value="${userPref2.color}" required>
</div>
<div>
  <label for="price">Price:</label>
  <input type="number" name="price" id="price" value="${userPref2.price}"  required>
</div>

<div class="divTable">
  <div class="divRow">
    <div class="divCell" align="right">
      <input type="button" name="save" id="save" value="Save">
      </div>
      <div class="divCell">
      <input type="button" name="delete" id="delete" value="Delete">
    </div>
  </div>
</div>
</fieldset>
</body>
</html>
