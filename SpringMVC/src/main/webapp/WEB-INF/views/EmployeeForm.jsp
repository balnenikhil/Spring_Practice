<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
  <title>Employee benefits Register Form</title>
   <style>
    .error{color:red}
   </style>
</head>
<body>

<h3>
<center><h3> Hi ${employee.firstName} ${employee.lastName} Login Successful </h3></center>

<form:form action="processed" modelAttribute="benefitEmployee">
<br><br><br><br>
<center><h2> Employee benefits Register Form </h2></center>
<br>

  Employee Id:
  <form:input path="id" placeholder="Enter Valid Employee Id" style="height:20px"/>
  <form:errors path="id" cssClass="error"/>
<br><br>

  First Name:
  <form:input path="firstName" placeholder="Enter Your First Name" style="height:20px"/>
  <form:errors path="firstName" cssClass="error"/>
<br><br>

  Last Name:
  <form:input path="lastName" placeholder="Enter Your Last Name" style="height:20px"/>
  <form:errors path="lastName" cssClass="error"/>
<br><br>

  Email:
  <form:input path="email" placeholder="Enter Your email" style="height:20px"/>
  <form:errors path="email" cssClass="error"/>
<br><br>

  Nationality:
  <form:select path="language">
          <form:option value="Indian" label="Indian"/>
          <form:option value="Chinese" label="Chinese"/>
          <form:option value="Nepali" label="Nepali"/>
          <form:option value="Others" label="Others"/>
  </form:select>
<br><br>

  Gender:
  Male<form:radiobutton path="gender" value="Male"/>
  Female<form:radiobutton path="gender" value="Female"/>
<br><br>

  Select Your Benefits:
  Health Benefits<form:checkbox path="plan" value="Health Benefits"/>
  Travel Benefits<form:checkbox path="plan" value="Travel Benefits"/>
  Meal benefits<form:checkbox path="plan" value="Meal benefits"/>
<br><br><br>

  <input type="submit" value="Process Form" style="height:30px; width:100px">

</form:form>
</h3>
</body>
</html>