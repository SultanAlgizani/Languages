<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${selected_language.id}: ${selected_language.name}</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body class="container mt-5">

    <div class="row mb-5">
        <div class="col-9">
            <h1>Language: <c:out value="${selected_language.name}"/></h1>
        </div>
        <div class="col">
            <a href="/">Home</a>
        </div>
    </div>
<p>Creator: <c:out value="${selected_language.creator}"/></p>
<p>Current Version: <c:out value="${selected_language.currentVersion}"/></p>
<div class="row">
    <form action="/languages/${selected_language.id}/delete" method="post" >
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete" class="btn btn-sm btn-outline-danger">
    </form>
    <a href="/languages/${selected_language.id}/edit" class="btn btn-sm btn-outline-warning ml-2">edit</a>
</div>

</body>
</html>
