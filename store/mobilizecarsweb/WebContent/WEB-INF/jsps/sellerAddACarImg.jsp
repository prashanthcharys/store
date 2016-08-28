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
<!--<form method="post" id="selladdcar-form" enctype="multipart/form-data" name="selladdcar-form" action="/mobilizecarsweb/app/seller/addCarSave">-->
<form method="post" id="selladdcar-form" enctype="multipart/form-data" name="selladdcar-form" action="/mobilizecarsweb/app/seller/addCarSaveImg">
<fieldset >
<legend>Add A Car For Sale</legend>
<div>
<font color='red' >${carDetailsForm.resMessage}  </font>
</div>
<div>
	<label for="img1">Car Image 1:</label>
	<input name="img1" type="file" id="file">
</div>
<div>
	<label for="img2">Car Image 2:</label>
	<input name="img2" type="file" id="file">
</div>
<div>
	<label for="img3">Car Image 3:</label>
	<input name="img3" type="file" id="file">
</div>
<div>
	<label for="img4">Car Image 4:</label>
	<input name="img4" type="file" id="file">
</div>
<div>
	<label for="img5">Car Image 5:</label>
	<input name="img5" type="file" id="file">
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
