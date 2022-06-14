<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<! DOCTYPE HTML>
<html>

<head>
<title> List Customers </title>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>


<div id="wrapper">
		<div id="header">
			<h2>Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">

    		<div id="content">
<table>
        <tr>
                <th> First Name </th>
                <th> Last Name </th>
                <th> Email </th>
                <th> update </th>
                <th> delete </th>
        </tr>

        <c:forEach var = "customer" items = "${customers}">

        <!-- adding link to update data for a given row -->
            <c:url var = "updateLink" value = "/customer/updateCustomer">
                    <c:param name = "customerId" value = "${customer.cId}"/>
            </c:url>
        <!-- adding link to update data for a given row -->
             <c:url var = "deleteLink" value = "/customer/deleteCustomer">
                  <c:param name = "customerId" value = "${customer.cId}"/>
             </c:url>

        <tr>
                <td> ${customer.firstName} </td>
                <td> ${customer.lastName} </td>
                <td> ${customer.email} </td>
                <td> <a href = "${updateLink}">Update</a></td>
                <td> <a href = "${deleteLink}" onclick= "if (!(confirm('Do you want to delete this for sure ?'))) return false">delete</a></td>
        </tr>
        </c:forEach>
</table>
<br><br>
<input type="button" value="Add Customer" onclick="window.location.href='addCustomer'; return false;"class = "add-button"/>

</div>
</div>

</body>
</html>
