<!DOCTYPE HTML>
<html>
<head>
<meta charset=utf-8 />
<title></title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript">
//$(function(){   $("#content").load("mainPage_2.html"); }); 
</script>
</head>
<body>
<!--<div name="content" id="content" style="height:130px; width:1200px; background-color:#ffcc99; float:left; margin:0px 0px 0px 0px"></div>
<fieldset  style="margin-left:300px; height:300px; width:600px; float:left; border:solid thick" >-->
<form method="post" id="selladdcar-form"  name="selladdcar-form" action="/mobilizecarsweb/app/seller/addCarSave">
<fieldset >
<legend>Add A Car For Sale</legend>
<div>
<font color='red' >${carDetailsForm.resMessage}  </font>
</div>
<div>
  <label for="year">Year:</label>
  <input type="number" name="year" id="year" required>
</div>
<div>
  <label for="make">Make:</label>
  <input type="text" name="make" id="make" required>
</div>
<div>
  <label for="model">Model:</label>
  <input type="text" name="model" id="model" required>
</div>
<div>
  <label for="mileage">Mileage:</label>
  <input type="number" name="mileage" id="mileage" required>
</div>
<div>
  <label for="color">color:</label>
  <input type="color" name="color" id="color" required>
</div>
<div>
  <label for="price">Price:</label>
  <input type="number" name="price" id="price" required>
</div>
<div>
  <label for="comments">Comments:</label>
  <input type="text" name="comments" id="comments" required>
</div>
<div class="divTable">
  <div class="divRow">
    <div class="divCell" align="right">
      <input type="submit" name="save" id="save" value="Save">
      </div>
      <div class="divCell">
      <input type="button" name="delete" id="delete" value="Delete">
    </div>
  </div>
</div>
</fieldset>
</form>
</body>
</html>
