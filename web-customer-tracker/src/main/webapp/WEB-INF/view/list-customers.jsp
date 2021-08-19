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
                <th scope="col">Action</th>
            </tr>

            <!-- loop over and print our customers-->
            <c:forEach var="customer" items="${customers}">
                <!-- construct an Update-Link with customer ID -->
                <c:url var = "updateLink" value="/customers/showFormForAdd">
                    <c:param name="customerID" value="${customer.id}"/>
                </c:url>

                <!-- construct an Delete-Link with customer ID -->
                <c:url var = "deleteLink" value="/customers/deleteCustomer">
                    <c:param name="customerID" value="${customer.id}"/>
                </c:url>

                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>
                        <!--Display the Update Link -->
                        <a href="${updateLink}">Update</a>
                        |
                        <!--Display the Delete Link -->
                        <a href="${deleteLink}"
                           onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
</div>

</body>

</html>
