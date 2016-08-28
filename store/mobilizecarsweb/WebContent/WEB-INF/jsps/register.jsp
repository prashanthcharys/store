<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>HTML5 Form - New HTML5 Elements</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../js/jquery.js"></script>
<style>
fieldset{
 	margin-left:300px;
 	height:350px; 
	width:600px; 
	float:left; 
	border:solid #990000;
 }
 label {
	display:block;
	float:left;
	clear:both;
	font-weight:bold;
	width:135px;	
}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/generalFunctions.js"></script>
<script type="text/javascript">
			$(document).ready(function() {
				$("#cancel").click(function() {	
					document.forms[0].action = "/mobilizecarsweb/app/login/user";
					document.forms[0].method = "GET";
					$("#my-form").submit();
					/*if($("#pWord").val() != $("#cpWord").val()){
						alert("Password and Confirm Password should match.");
						$("#pWord").focus();

					// }*/
					// checkManditory($("#userID"),$("#userID").val(),"User ID");
					// checkManditory($("#pWord"),$("#pWord").val(),"Password");
					// checkManditory($("#cpWord"),$("#cpWord").val(),"Confirm Password");
					// checkManditory($("#fName"),$("#fName").val(),"First Name");
					// checkManditory($("#lName"),$("#lName").val(),"Last Name");
					// checkManditory($("#address"),$("#address").val(),"Address");
					// checkManditory($("#city"),$("#city").val(),"City");
					// checkManditory($("#state"),$("#state").val(),"State");
					// checkManditory($("#zip"),$("#zip").val(),"Zip");
				});
				$("#register").click(function() {	
					document.forms[0].action = "/mobilizecarsweb/app/login/registerUser";
					document.forms[0].method="POST";
					$("#my-form").submit();
				});				
				
				
			});
			//end doc ready
function validateFields(){
	checkManditory();
}
</script>
</head>
<body>
<form method="POST" action="/mobilizecarsweb/app/login/registerUser" id="my-form">
  <!-- <div id="header" style="height:100px; width:1500px;  background-color:#ffcc99;" > </div >-->
  <div id="container" style="height:130px; width:1200px; margin-top:-20px; background-color:#ffcc99; float:left">
    <div class="divRow1">
		<div class="divCell" style="width:600px; float:left"> 
			<img id="logo" src="../../Images/logo_car.jpg" alt="Logo" height="120" width="250">
		</div>
		<div class="divCell" style="width:600px;  float:left">
			<h1 align="right">Buy On Mobile Inc.</h1>
		</div>
    </div>
  </div>
  <div name="dummy"  id="dummy" style="height:80px;  width:1200px;  float:left; background-color:#EBEBEB"></div>
  <div name="mainContentBody"  id="mainContentBody" style="height:750px;  width:1200px;  float:left; background-color:#EBEBEB">
    <fieldset >
    <legend>User Profile</legend>
    <div>
      <label for="userId">User ID:</label>
      <input type="text" name="userId" id="userId" required>
    </div>
    <div>
      <label for="password">Password:</label>
      <input type="password" name="password" id="password" required>
    </div>
    <div>
      <label for="cpWord">Confirm Password:</label>
      <input type="password" name="cpWord" id="cpWord" required>
    </div>    
    <div>
      <label for="firstName">First Name:</label>
      <input type="text" name="firstName" id="firstName" required>
    </div>
    <div>
      <label for="lastName">Last Name:</label>
      <input type="text" name="lastName" id="lastName" required>
    </div>
    <div>
      <label for="addressLine1">Address:</label>
      <input type="text" name="addressLine1" id="addressLine1" required>
    </div>
    <div>
      <label for="city">City:</label>
      <input type="text" name="city" id="city" required>
    </div>
    <div>
      <label for="state">State:</label>
      <input type="text" name="state" id="state" required>
    </div>
    <div>
      <label for="zip">Zip Code:</label>
      <input type="text" name="zip" id="zip" required>
    </div>
    <div>
      <label for="homePhone" >Home Phone:</label>
      <input type="tel" name="homePhone" id="homePhone" required>
    </div>
    <div>
      <label for="mobilePhone" >Mobile Phone:</label>
      <input type="tel" name="mobilePhone" id="mobilePhone" required>
    </div>
    <div>
      <label for="emailId">Email:</label>
      <input type="emailId" name="email" id="emailId" required>
    </div>
	<div>
      <label for="userType">User Type:</label>
      <input type="radio" name="userType" id="userType" value="B">Buyer &nbsp;&nbsp;
	  <input type="radio" name="userType" id="userType" value="S">Seller
    </div>

    <div class="divTable">
      <div class="divRow">
        <div class="divCell"  align="right">
          <input type="submit" name="register" id="register" value="Register">
        </div>
        <div class="divCell">
          <input type="button" name="cancel" id="cancel" value="Cancel">
        </div>
      </div>
    </div>
    </fieldset>
  </div>
</form>
</body>
</html>
