<%-- 
    Document   : signup
    Created on : Dec 28, 2022, 12:10:54 AM
    Author     : Kalina
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
    <%@ include file="head.html" %>  

    <body>
        <%@ include file="header.jsp" %>  

        <div class='container'>
            <h1>Sign up</h1>

            <form method='post' action='processSignup'>
                <label for="email">Email</label>
                <input type="email" name='email' pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" id='email' class='form-control mb-3' placeholder='email'>

                <label for="password">Password</label>
                <input type="password" name='password' id='password' class='form-control mb-3' placeholder='password'>

                <!--<label for="password">Confirm Password</label>-->
                <!--<input type="password" name='password' id='password' class='form-control mb-3' placeholder='password'>-->

                <input type='submit' value = 'Sign up'class='btn btn-success mt-2'>
            </form>
        </div>
    </body>
</html>