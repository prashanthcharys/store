<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</br>
<P>  Card number ${paymentDetails.cardNumber}. </P>
</br>
<P> Amount ${paymentDetails.amount}. </P>
</br>
<P>  Transaction date ${paymentDetails.transactionDate}. </P>
</body>
</html>
