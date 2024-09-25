<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Spring MVC Home</title>
</head>
<body>
    <h1>Welcome to the Spring MVC Application</h1>

    <!-- Example of a link to the REST endpoint -->
    <a href="${pageContext.request.contextPath}/api/hello">Go to Hello Endpoint</a>
</body>
</html>