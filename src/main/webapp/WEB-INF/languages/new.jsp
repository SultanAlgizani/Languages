<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Languages</title>
                <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
                <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
                <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

            </head>

            <body class="container mt-5 col-6">

                    <div class="row mb-5">
                        <div class="col-9">
                            <h1>Add New Language</h1>
                        </div>
                        <div class="col">
                            <a href="/">Home</a>
                        </div>
                    </div>

                <form:form action="/languages" method="post" modelAttribute="language">
                    <div class="form-group">
                        <form:label path="name">Name</form:label>
                        <form:input path="name" class="form-control" /><br>
                        <form:errors path="name" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <form:label path="creator">Creator</form:label>
                        <form:input path="creator" class="form-control" /><br>
                        <form:errors path="creator" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <form:label path="currentVersion">Current Version</form:label>
                        <form:input type="number" path="currentVersion" class="form-control" /><br>
                        <form:errors path="currentVersion" class="text-danger" />
                    </div>
                    <input type="submit" value="Submit" class="btn btn-outline-info"/>
                </form:form>

            </body>

            </html>