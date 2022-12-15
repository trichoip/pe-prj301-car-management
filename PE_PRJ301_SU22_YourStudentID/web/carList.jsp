<%-- 
    Document   : carList
    Created on : 30-06-2022
    Author     : hd
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="pe.CarErrorDTO"%>
<%@page import="pe.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car List Page</title>
    </head>
    <body>
        kiểm tra thư viện :
        -thêm jdbc
        -thêm jstl nếu k có sẳn
        - khi sử dụng thẻ jstl trong trang jsp nhớ crlt + space mới sd được  (<c:forEach items=""/>)
        - trong class dao copy nhớ đổi tên table vd from tblCars to theo đề bài
        - nhớ thêm properties trong class DTO theo database (đúng tên colunm)
        - còn nữa dao đọc


        <!--phan quyen - authentication authorization  -->
        <%--    <c:if test="${sessionScope.USER.roleID ne 'AD'}">
                <c:redirect url="login.jsp"/>
            </c:if>    --%>
        <!--your code here-->

        <h1>Welcome ${sessionScope.USER.fullName}</h1>

        <!-- logout button-->
        <form action="MainController">
            <input type="submit" value="Logout" name="action" />
        </form>

        <!-- logout link-->        
        <a href="MainController?action=Logout">logout</a>



        <!-- search-->
        <form action="MainController">
            Search   <input type="text" name="Search" value="${param.Search}" />
            <input type="submit" value="Search" name="action" />
        </form>

        <c:if test="${not empty requestScope.LIST_CAR}">

            <table border="1">
                <thead>
                    <tr>
                        <th>no</th>
                        <th>id</th>
                        <th>name</th>
                        <th>description</th>
                        <th>price</th>
                        <th>speed</th>
                        <th>status</th>
                        <th>Delete</th>
                        <th>Update</th>
                        <th>Remove</th>

                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="car" items="${requestScope.LIST_CAR}" varStatus="minh">
                    <form action="MainController">
                        <tr>
                            <td>${minh.count}</td>
                            <td><input type="text" name="id" value="${car.id}" readonly="" /> </td>
                            <td><input type="text" name="name" value="${car.name}" /> </td>
                            <td><input type="text" name="description" value="${car.description}" /> </td>
                            <td><input type="text" name="price" value="${car.price}" /> </td>
                            <td><input type="text" name="speed" value="${car.speed}" /> </td>
                            <td>${car.status}</td>


                            <!--"delete" link-->
                            <td> <a href="MainController?action=Delete&carID=${car.id}&Search=${param.Search}">Delete</a></td>

<!--                            "delete" button
                            <td> <input type="submit" value="Delete" name="action" /> </td>
                        <input type="hidden" name="Search" value="${param.Search}" />
                        <input type="hidden" name="carID" value="${car.id}" />-->

                        <!--"update" button-->
                        <td><input type="submit" value="Update" name="action" /></td>
                        <input type="hidden" name="Search" value="${param.Search}" />


                        <!--"remove" link-->
                        <td>   <a href="MainController?action=Remove&carID=${car.id}&Search=${param.Search}">Remove </a>     </td>  

                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>

    </c:if> 
    <!-- search end-->



    <!-- create -->

    <form action="MainController">
        <h4>Create products: </h4>
        id <input type="text" name="id" value="" required="" />   ${requestScope.ERROR.id}  <br>   
        name <input type="text" name="name" value="" required="" />     ${requestScope.ERROR.name}  <br>
        description <input type="text" name="description" value="" required="" />   ${requestScope.ERROR.description}   <br>
        price <input type="text" name="price" value="" required="" />   ${requestScope.ERROR.price} <br>
        speed <input type="text" name="speed" value="" required="" />   ${requestScope.ERROR.speed} <br>
        <input type="submit" value="Create" name="action" />
    </form>
    <!-- create end-->




    <h1>${requestScope.MESSAGE}</h1>

</body>
</html>
