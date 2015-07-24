<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Error Occured</title>
</head>
<body>
<h3> Please contact production support</h3>
<br/>

	${exception.message}
	<br/>
	<!--
	 Failed URL: ${url}
	 Exception:  ${exception.message}
	     <c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
	 </c:forEach>
	 -->
</body>
</html>