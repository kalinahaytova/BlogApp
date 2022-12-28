<%-- 
    Document   : addBlog
    Created on : Dec 27, 2022, 8:57:58 PM
    Author     : Kalina
--%>

<!DOCTYPE html>
<html>

    <%@ include file="head.html" %>  
    <body>

        <%@ include file="header.jsp" %>  

        <div class='container'>
            <h1>Adding an Article</h1>
        <c:choose>
            <c:when test='${email==null}'>
                <h4 class = "p-3 my-5">Please <a href="signup.jsp">Sign up</a> or <a href="login.jsp">Log in</a> to add an article</h4>
            </c:when>
            <c:otherwise>
                <form method='post' action='processBlog'>
                    <label for="author">Author</label>
                    <input type="text" name='author' disabled value = "${email}" id='author' class='form-control mb-3' placeholder='author'>

                    <label for="title">Title</label>
                    <input type="text" name='title' id='title' class='form-control mb-3' placeholder='title'>

                    <label for="author">Content</label>
                    <input type="text" name='content' id='content' class='form-control mb-3' placeholder='content'>

                    <input type='submit' value = 'Add'class='btn btn-success mt-2'>
                </form>
            </c:otherwise>
        </c:choose>           
        </div>
    </body>
</html>