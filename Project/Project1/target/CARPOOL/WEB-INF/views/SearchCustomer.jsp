<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Searching for customer </title>
</head>
<body>
    <h3>Your details</h3>
    <table>
    <thead>
    <tr>
    <th>name</th>
    <th>car</th>
    <th>start</th>
    <th>des</th>
    </tr>
    </thead>
    <c:forEach items="${owners}" var="owner">
        <tr>
            <td> ${owner.name}</td>
            <td> ${owner.carNumber}</td>
            <td> ${owner.startPoint}</td>
            <td> ${owner.destination}</td>
        </tr>
    </c:forEach>
    </table>
    <h3>Click the below button to see any available customer</h3>

    <a href="SearchCustomer">Search for customers</a>

     <h3>Your details</h3>
        <table>
        <thead>
        <tr>
        <th>customerId</th>
        <th>start</th>
        <th>destination</th>
        <th>price</th>
        </tr>
        </thead>
        <c:forEach items="${requests}" var="request">
            <tr>
                <td> ${request.customerId}</td>
                <td> ${request.start}</td>
                <td> ${request.destination}</td>
                <td> ${request.price}</td>
            </tr>
        </c:forEach>
        </table>




</body>
</html>