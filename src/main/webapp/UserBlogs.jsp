<%-- 
    Document   : UserBlogs
    Created on : Dec 27, 2022, 8:57:36 PM
    Author     : Kalina
--%>

<%@page import="java.util.List"%>
<%--<%@page import="Blogs.Blog"%>--%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.sql.ResultSet"%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <%@ include file="head.html" %>  
    <body>

        <%@ include file="header.jsp" %>  

        <div class='container'>
            <h1 class="my-6 border-bottom border-success">All Articles</h1>
            
            <!--Check if there are articles-->
        <c:choose>
        <c:when test='${email==null}'>
           <h4>Please <a href="signup.jsp">Sign up</a> or <a href="login.jsp">Log in</a> to view your articles.</h4> 
        </c:when>
        <c:otherwise>
           <ul class="col-6 list-group list-group-flush my-3 d-flex justify-content-center">
                <li class="list-group-item">
                    <p><strong>Title </strong>Title</p>
                    <p><strong>Content: </strong>content</p>
                    <p><strong>Date: </strong>date</p>

                    <form action='removeBlog' method='get'>
                        <input hidden name="id" value="ID">
                            <input class ="btn btn-danger" type="submit" value="remove">
                    </form>
                </li>                
           </ul>              
        </c:otherwise>
        </c:choose>           
    </div>
</body>
</html>