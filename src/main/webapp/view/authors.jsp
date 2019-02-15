<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <jsp:include page="header.jsp"></jsp:include>
<body>

</body>

   <div class="container">
       <div class="row my-5">
           <div class="col-sm-8 mx-auto">
               <h4 class="text-primary text-center">Author List</h4>
               <table class="table">
                   <thead>
                   <tr>
                       <th scope="col">Id</th>
                       <th scope="col">First Name</th>
                       <th scope="col">Last Name</th>
                       <th scope="col">Nationality</th>
                   </tr>
                   </thead>
                   <tbody>
                    <c:forEach var="author" items="${authors}">
                        <tr>
                            <th>${author.id}</th>
                            <td>${author.firstName}</td>
                            <td>${author.lastName}</td>
                            <td>${author.nationality}</td>
                            <td>
                                <a href="/authors/updateAuthor/${author.id}" class="btn btn-white btn-lg text-warning"><i class="fas fa-edit"></i></a>
                            </td>
                            <td>
                                <a href="/authors/delete/${author.id}" class="btn btn-white btn-lg text-danger post"> <i class="fas fa-trash-alt"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                   </tbody>
               </table>

           </div>
       </div>
   </div>

</html>
