<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>

<div class="container">
    <div class="row my-5">
        <div class="col-sm-6 mx-auto">
            <h4 class="text-primary text-center">Add new Book</h4>

            <form:form method="post" action="/books" modelAttribute="book">
                <div class="form-group">
                    <form:input type="text" class="form-control" placeholder="Title" path="title"/>
                </div>
                <div class="form-group">
                    <form:input type="text" class="form-control" placeholder="Release Year" path="releaseYear"/>
                </div>
                <div class="form-group">
                    <form:select path="author">
                        <c:forEach var="author" items="${authors}">
                            <form:option value="${author.id}" label="${author.id}"/>
                        </c:forEach>
                    </form:select>
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form:form>

        </div>
    </div>
</div>
</body>
</html>
