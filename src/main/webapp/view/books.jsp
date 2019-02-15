<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
</body>

<div class="container">
    <div class="row my-5">
        <div class="col-sm-8 mx-auto">
            <h4 class="text-primary text-center">Book List</h4>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ISBN</th>
                    <th scope="col">Title</th>
                    <th scope="col">Release Year</th>
                    <th scope="col">Author</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <th>${book.id}</th>
                        <td>${book.title}</td>
                        <td>${book.releaseYear}</td>
                        <td>${book.author.firstName}</td>
                        <td>
                            <a href="/books/updateBook/${book.id}" class="btn btn-white btn-lg text-warning"><i class="fas fa-edit"></i></a>
                        </td>
                        <td>
                            <a href="/books/delete/${book.id}" class="btn btn-white btn-lg text-danger post"> <i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>

</html>
