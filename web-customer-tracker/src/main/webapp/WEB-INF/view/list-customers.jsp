<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>List Customers</title>
    <!-- references our Style Sheet  -->
    <link type="text/css"
          rel="styleSheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"></link>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- add a new customer button here -->
			<input type="button" value="Add Customer"
			        onclick="window.location.href='showFormForAdd'; return false;"
			        class="add-button"/>

            <!-- add a table here -->
			<table>
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Email</th>
				</tr>
				<!-- loop over and print our customers-->
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>
