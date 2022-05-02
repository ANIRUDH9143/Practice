<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Wait</title>
</head>
<body>
<h3>Your details</h3>
<table>
    <thead>
    <tr>
    <th>Your Name</th>
    <th>Your start point</th>
    <th>Your destination</th>
    </tr>
    </thead>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.startPoint}</td>
            <td>${customer.destination}</td>
        </tr>
    </c:forEach>
    </table>

    <h3>Click below button to see available cars</h3>




    <a href="fetchCar">Search for Cars</a><br>

</body>
</html>