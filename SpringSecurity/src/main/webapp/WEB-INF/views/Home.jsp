<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<center>
<h2>Hello!</h2>
<hr>
<h3> welcome to Home Page </h3>
<h4>
User: <security:authentication property = "principal.username"/>
<br><br>
Role: <security:authentication property = "principal.authorities"/>
</h4>
<br><br>
<hr>
<p>
<security:authorize access= "hasRole('TEACHER')">
<a href="teachers">Organization page</a>
</security:authorize>
<br><br>
<security:authorize access= "hasAnyRole('CLASSLEAD', 'TEACHER')">
<a href="class"> ClassRoom feedback page</a>
</security:authorize>
</p>
<br><br>
<form:form action = "logout" method="POST">
<input type = "submit" value="Logout"/>
</form:form>
</center>
</body>
</html>
