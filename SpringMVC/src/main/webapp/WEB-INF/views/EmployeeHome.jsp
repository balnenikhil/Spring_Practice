<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <title>Employee Login Page</title>

  <style>
  .error{color:red}
  </style>

</head>

<body>
<center>
<h1>Hello..!!!</h1>
<h2> <strong>Welcome to Employee Login Page </strong> </h2>
<h3> Please Login </h3>
<br><br><br>
<hr>
<br><br>
<form:form action="registration" modelAttribute="employee">

First Name : <form:input path="firstName"/>
<form:errors path="firstName" cssClass="error"/>
<br><br><br>

Last Name : <form:input path="lastName"/>
<form:errors path="lastName" cssClass="error"/>
<br><br><br>

Password : <form:password path="password" required="required"/>
<form:errors path="password" cssClass="error"/>
<br><br><br><br>

<input type="submit" value="Login" style="height:30px; width:80px">
</form:form>
</center>

</body>

</html>