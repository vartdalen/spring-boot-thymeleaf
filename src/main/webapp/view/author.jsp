<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>

    <div class="container">
        <div class="row my-5">
            <div class="col-sm-6 mx-auto">
                <h4 class="text-primary text-center">Add new Author</h4>
                <form:form method="post" action="/authors" modelAttribute="author">
                    <div class="form-group">
                        <form:input type="text" class="form-control" placeholder="First Name" path="firstName"/>
                    </div>
                    <div class="form-group">
                        <form:input type="text" class="form-control" placeholder="Last Name" path="lastName"/>
                    </div>
                    <div class="form-group">
                        <form:input type="text" class="form-control" placeholder="Nationality" path="nationality"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
