<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body class="container mt-5">

<h1>All Languages</h1>
<table class="table mt-4">
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Current Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languages}" var="language">
        <tr>
            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>

            <td class="row">
                <form action="/languages/${language.id}/delete" method="post" >
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete" class="btn btn-sm btn-outline-danger">
                </form>
                <a href="/languages/${language.id}/edit" class="btn btn-sm btn-outline-warning ml-2">edit</a>
            </td>
                
        </tr>
        </c:forEach>
    </tbody>
</table>

<a href="/languages/new">New Book</a>

</body>
</html>
