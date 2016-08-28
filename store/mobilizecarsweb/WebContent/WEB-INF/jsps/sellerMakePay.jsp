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
	width:140px;
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
<legend>Seller Make Paymentss</legend>
<div >
  <label for="cardType">Card Type:</label>
  <input type="text" list="cardType_list" name="cardType" id="cardType" required>
  <datalist id="cardType_list">
    <option label="visa" value="Visa">
    <option label="master" value="Master">
    <option label="arericanExpress" value="Arerican Express">
    <option label="Discoveror" value="Discoveror"> 
  </datalist>
</div>
<div>
  <label for="cNumber">Card Number:</label>
  <input type="number" name="cNumber" id="cNumber" required>
</div>
<div>
  <label for="chName">Card Holder Name:</label>
  <input type="text" name="chName" id="chName" required>
</div>
<div>
  <label for="model">Model:</label>
  <input type="text" name="model-local" id="model" required>
</div>
<div>
  <label for="expDate">Expiratuib Date:</label>
  <input type="date" name="expDate" id="expDate" required>
</div>
<div>
  <label for="cvvCOde">CVV code:</label>
  <input type="number" name="cvvCOde" id="cvvCOde" required>
</div>
<div>
  <label for="amount">Amount:</label>
  <input type="number" name="amount" id="amount" required>
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
