<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <title>Employee Register Form</title>
</head>
<body>
<br><br><br><br>
<center><h2>Details Successfully Registered</h2></center>
<br><br>
<h3>
Employee Id : ${benefitEmployee.id}<br><br>
Employee Name : ${benefitEmployee.firstName} ${benefitEmployee.lastName}<br><br>
Nationality : ${benefitEmployee.language}<br><br>
Gender : ${benefitEmployee.gender}<br><br>
Benefits Selected :
<ul>
<c:forEach var="plan" items="${benefitEmployee.plan}">
<li>${plan}</li><br>
</c:forEach>
</ul>
</h3>
</body>
</html>