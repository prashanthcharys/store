<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta charset=utf-8 />
		<title>Dropdown Menu With JQuery</title>
		<link href="../../css/style.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../../js/jquery.js"></script>
		<script type="text/javascript">
			$(function() {
				$('.dropdown').mouseenter(function() {
					$('.sublinks').stop(false, true).hide();

					var submenu = $(this).parent().next();

					submenu.css({
						position : 'absolute',
						top : $(this).offset().top + $(this).height() + 'px',
						left : $(this).offset().left + 'px',
						zIndex : 1000
					});

					submenu.stop().slideDown(300);

					submenu.mouseleave(function() {
						$(this).slideUp(300);
					});
				});
			});
			
			/*function addContent(contentPage){
				//$("#mainContentBody").load(contentPage);
				//$("#mainContentBody").load("/mobilizecarsweb/app/userDetails");
				alert("111contentPage:"+contentPage);
  			 	$("#mainContentBody").load("/mobilizecarsweb/app/"+contentPage);
				//$("#mainContentBody").src = "/mobilizecarsweb/app/"+contentPage;
				//$("#main-form").submit();
  			 	document.forms[0].action = "/mobilizecarsweb/app/userDetails";
  			 	alert($("#main-form").action);
				$("#main-form").submit();
				        $.ajax({
	        				type: "GET",
	       					 url: "/mobilizecarsweb/app/userDetails",
	        				data: "",
	        				success: function(response){
	       						 // we have the response
	       						$("#mainContentBody").load(response);
	       				    },
	       			 		error: function(e){
	       				 alert('Error: ' + e);
	        			}
	        		});

			}*/
		</script>
		<style type="text/css">
			/* CSS For Dropdown Menu Start */
			ul {
				list-style: none;
				padding: 0px;
				float: left;
				margin: -4px 0px 0px 0px;
			}
			ul li {
				display: inline;
				float:left;
			}
			ul li a {
				color: #ffffff;
				background: #990E00;
				margin-right: 0px;
				font-weight: bold;
				font-size: 12px;
				font-family: verdana;
				text-decoration: none;
				display: block;
				width: 150px;
				height: 25px;
				line-height: 25px;
				text-align: center;
				-webkit-border-radius: 5px;
				-moz-border-radius: 50px;
				border: 1px solid #560E00;
				border-radius: 5px;
			}
			ul li a:hover {
				color: #cccccc;
				background: #560E00;
				font-weight: bold;
				text-decoration: none;
				display: block;
				width: 150px;
				text-align: center;
				-webkit-border-radius: 5px;
				-moz-border-radius: 5px;
				border: 1px solid #000000;
				border-radius: 5px;
			}
			ul li.sublinks a {
				color: #000000;
				background:#999999;
				border-bottom: 1px solid #cccccc;
				font-weight: normal;
				text-decoration: none;
				display: block;
				width: 120px;
				text-align: center;
				margin-top: 2px;
				/*float: left; to make vertical list*/
			}
			ul li.sublinks a:hover {
				color: #000000;
				background: #FFEFC6;
				font-weight: normal;
				text-decoration: none;
				display: block;
				width: 120px;
				text-align: center;
			}
			ul li.sublinks {
				display: none;
			}
			/* CSS For Dropdown Menu End */

			#container {
				margin: 0px auto;
				width: 570px;
			}
			.clear {
				clear: both;
			}
			.left {
				float: left;
			}
			.right {
				float: right;
			}
			header {
				display: block;
				padding: 0px 0px 5px 0px;
				margin: -20px 0px 0px 0px;
				height: 80px;
				width: 1200px;
				float: left;
				background-color: #ffcc99;
			}
			header hgroup {
				display: block;
				float: right;
			}
			header #logo {
				float: left;
			}
		</style>
	</head>
	<body>
	<form method="post" action="" id="main-form">
		<div id="container" style="height:130px; width:1200px; margin-top:-20px; background-color:#ffcc99; float:left">
			<div class="divRow1">
				<div class="divCell" style="width:600px">
					<img id="logo" src="../../Images/logo_car.jpg" alt="Logo" height="120" width="250">
				</div>
				<div class="divCell" style="width:600px">
					<h1 align="right">Buy On Mobile Inc.</h1>
				</div>
			</div>
		</div>
		<!--<header style="height:100px; width:1200px; margin:-20px 0px 0px 32px; background-color:#ffcc99;"> -->
		<!--<header>
		<hgroup  >
		<h1 >ABC Solutions</h1>
		</hgroup>
		<img id="logo" src="Images/logo_car.jpg" alt="Logo" height="80" width="150">
		</header> -->
		<div id="container" style="height:25px; width:1200px; margin-top:-0px; background-color:#ffcc99; float:left">
			<!-- User Profile Menu Start -->
			<ul>
				<li>
					<!--<a class="dropdown" onclick="addContent('userDetails')">User Profile</a>-->
					<a class="dropdown" href="/mobilizecarsweb/app/userDetails/getUser" target="mainContentBody">User Profile</a>					
				</li>
				<!--<li class="sublinks"> <a href="#">Link 1</a> <a href="#">Link 2</a> </li> -->
			</ul>
			<!-- User Profile Menu End -->
			<!-- Use Preferences Menu Start -->
			<!--  <ul>
			<li><a href="#" class="dropdown">User Preferences </a></li>
			<li class="sublinks"> <a href="#">Link 1</a> <a href="#">Link 2</a> </li>
			</ul> -->
			<!-- Use Preferences Menu End -->
			<!-- Buyer Menu Start -->
			<ul>
				<li>
					<a href="#" class="dropdown">Buy A Car</a>
				</li>
				<li class="sublinks">
                    <a href="/mobilizecarsweb/app/buyer/getPref" target="mainContentBody">Preferences</a>
                    <a href="/mobilizecarsweb/app/buyer/getCriteria" target="mainContentBody">Search Criteria</a>
                    <a href="/mobilizecarsweb/app/buyer/getResult" target="mainContentBody">Search Results</a>
				</li>
			</ul>
			<!-- Buyer Menu End -->
			<!-- Seller Menu Start -->
			<ul>
				<li>
					<a href="#" class="dropdown">Sell A Car</a>
				</li>
				<li class="sublinks">
					<a href="/mobilizecarsweb/app/seller/addCar" target="mainContentBody">Add car</a>
                    <a href="/mobilizecarsweb/app/seller/makePay" target="mainContentBody">Make a payment</a>
                    <a href="/mobilizecarsweb/app/seller/carsList" target="mainContentBody">Car listings</a>
				</li>
			</ul>
			<!-- Seller Menu End -->
			<ul>
				<li>
					<a href="/mobilizecarsweb/app/login/user" class="dropdown" target="_self">Log Out</a>
				</li>
			</ul>
		</div>
       <!-- <div name="dummy"  id="dummy" style="height:80px;  width:1200px;  float:left; background-color:#EBEBEB"></div>
        <div name="mainContentBody"  id="mainContentBody" style="height:750px;  width:1200px;  float:left; background-color:#EBEBEB"></div>-->
        <iframe name="mainContentBody"  id="mainContentBody" height="750px"  width="1200px"  frameborder="0"></iframe>

        </form>
	</body>
</html>
