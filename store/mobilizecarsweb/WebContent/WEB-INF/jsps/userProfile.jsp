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
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
/*$(document).ready(function() {
	$("#save").click(function() {
		alert("submit-top");
		document.forms["userprof-form"].action = "/mobilizecarsweb/app/userDetails?pageType=save";
		//document.forms["userprof-form"].target=window.opener.$('#mainContentBody');
		document.forms["userprof-form"].submit();
		//$("#mainContentBody").load("/mobilizecarsweb/app/userDetails?pageType=save");


	});
});*/
</script>
</head>
<body>
<form method="post" id="userprof-form" name="userprof-form" action="/mobilizecarsweb/app/userDetails/saveUser">
<!--<div name="content" id="content" style="height:130px; width:1200px; background-color:#ffcc99; float:left; margin:0px 0px 0px 0px"></div>
<fieldset  style=" margin-left:300px; height:350px; width:600px; float:left; border:solid #990000" >-->
<fieldset >
<legend>User Profile</legend>
<div>
<font color='red' >${userDetails.resMessage}  </font>
</div>
<div>
  <label for="firstName">First Name:</label>
  <input type="text" name="firstName" id="firstName" value="${userDetails.firstName}" required>
</div>
<div>
  <label for="lastName">Last Name:</label>
  <input type="text" name="lastName" id="lastName" value="${userDetails.lastName}" required>
</div>
<div>
  <label for="addressLine1">Address Line1:</label>
  <input type="text" name="addressLine1" id="addressLine1" value="${userDetails.addressLine1}" required>
</div>
<div>
  <label for="addressLine2">Address Line2:</label>
  <input type="text" name="addressLine2" id="addressLine2" value="${userDetails.addressLine2}"  required>
</div>
<div>
  <label for="city">City:</label>
  <input type="text" name="city" id="city" value="${userDetails.city}"  required>
</div>
<div>
<label for="state">State:</label>
<input type="text" name="state" id="state" value="${userDetails.state}"  required>
</div>
<div>
  <label for="zip">Zip Code:</label>
  <input type="text" name="zip" id="zip" value="${userDetails.zip}"  required>
</div>
<div>
<label for="country">Country:</label>
<input type="text" name="country" id="country" value="${userDetails.country}"  required>
</div>
<div>
  <label for="homePhone" >Home Phone:</label>
  <input type="tel" name="homePhone" id="homePhone" value="${userDetails.homePhone}"  required>
</div>
<div>
  <label for="mobilePhone" >Mobile Phone:</label>
  <input type="tel" name="mobilePhone" id="mobilePhone" value="${userDetails.mobilePhone}"  required>
</div>
<div>
  <label for="emailId">Email:</label>
  <input type="email" name="emailId" id="emailId" value="${userDetails.emailId}"  required>
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
