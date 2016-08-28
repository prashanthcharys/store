<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8">
		<title>HTML5 Form - New HTML5 Elements</title>
		<link href="../../css/style.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../../js/jquery.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#login").click(function() {
					document.forms[0].action = "/mobilizecarsweb/app/login/validate";
					$("#my-form").submit();
				});
				$("#register").click(function() {		
					document.forms[0].action = "/mobilizecarsweb/app/login/register";
					$("#my-form").submit();
				});
			});
			//end doc ready
		</script>

	</head>
	<body>
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
       <!--<div name="mainContentBody"  id="mainContentBody" style="height:750px;  width:1200px;  float:left; background-color:#EBEBEB"></div>-->
		<form method="post" action="/mobilizecarsweb/app/login/validate" id="my-form">
        <fieldset >
        <legend>Login</legend>
        <div>
        <font color='red' >${loginForm.errorMessage}  </font>
        </div>
        <div>
          <label for="userId">User ID:</label>
          <input type="text" name="userId" id="userId" value="" required>
        </div>
        <div>
          <label for="password">Password:</label>
          <input type="password" name="password" id="password" value="" required>
        </div>
        <div class="divTable">
          <div class="divRow">
            <div class="divCell" align="right">
              <input type="submit" name="login" id="login" value="Login">
            </div>
            <div class="divCell">
              <input type="button" name="register" id="register" value="Register">
            </div>
          </div>
        </div>
        </fieldset>
        </div>
		</form>
	</body>
</html>
