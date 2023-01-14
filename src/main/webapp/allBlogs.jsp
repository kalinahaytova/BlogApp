<%-- 
    Document   : allBlogs
    Created on : Dec 28, 2022, 2:53:47 PM
    Author     : Kalina
--%>
<!DOCTYPE html>

<%@page import="java.sql.Date"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <%@ include file="head.html"%>  
    <body>

        <%@ include file="header.jsp"%>  

        <div class='container'>
            <h1 class="my-6 border-bottom border-success">All Articles</h1>
            <c:choose>
                <c:when test='${blogList==null || blogList.size()==0}'>
                <h2>No articles were found.</h2> 
                </c:when>
                <c:otherwise>
                    <ul class="col-6 list-group list-group-flush my-3 d-flex justify-content-center">
                        <c:forEach items="${blogList}" var="item">
                            <li class="list-group-item">
                                <p><strong>Author: </strong>${item.author}</p>
                                <p><strong>Title: </strong>${item.title}</p>
                                <p><strong>Content: </strong>${item.content}</p>
                                <p><strong>Date: </strong>${item.dateAdded}</p>

                                <!--<form action='removeBlog' method='get'>
                                    <input hidden name="id" value="ID">
                                    <input class ="btn btn-danger" type="submit" value="remove">
                                </form> -->
                            </li>
                        </c:forEach>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>