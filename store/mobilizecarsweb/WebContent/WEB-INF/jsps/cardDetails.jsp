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
<P>  Card holder first name ${cardDetails.firstName}. </P>
</br>
<P>  Card holder last name ${cardDetails.lastName}. </P>
</br>
<P>  Exp date ${cardDetails.expDate}. </P>
</body>
</html>
