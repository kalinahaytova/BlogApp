<%-- 
    Document   : index
    Created on : Dec 27, 2022, 8:48:00 PM
    Author     : Kalina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- Including head html, so it's the same for every jsp page-->
    <%@ include file="head.html" %>  

    <body>
    <!-- Including header jsp, so it's the same for every jsp page-->

        <%@ include file="header.jsp" %>  

        <main class="container">
            <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
                <h1 class="display-4">Welcome to the Blog Website</h1>
                <p class="lead">Sign up to add your own blogs or just read other people's stories</p>
            </div>

            <div class="row row-cols-1 row-cols-md-3 mb-3 text-center justify-content-center">
                <div class="col">
                    <div class="card mb-4 shadow-sm">
                        <h1 class="card-title pricing-card-title card-header">My articles<small class="text-muted"></small></h1>
                        <div class="card-body">
                            <p>&#11015;</p>
                            <a class="w-100 btn btn-lg btn-outline-primary nav-link" aria-current="page" href='UserBlogs.jsp'>Check it out</a>

                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card mb-4 shadow-sm">
                        <h1 class="card-title pricing-card-title card-header">All articles<small class="text-muted"></small></h1>
                        <div class="card-body">
                            <p>&#11015;</p>
                            <a class="w-100 btn btn-lg btn-outline-primary nav-link" aria-current="page" href="allBlogs.jsp">Check it out</a>
                        </div>
                    </div>
                </div>


            </div>

            <footer class="pt-4 my-md-5 pt-md-5 border-top">
                <div class="row">
                    <h5>About</h5>
                    <ul class="list-unstyled text-small">
                        <li>A simple Blog Web Application.</li>
                        <li style="font-size: 9pt">Veliko Tarnovo, Bulgaria. 2022</li>
                    </ul>
                </div>
            </footer>
        </main>
    </body>
</html>