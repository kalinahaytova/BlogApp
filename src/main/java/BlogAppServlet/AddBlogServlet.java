/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BlogAppServlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author Kalina
 */
@WebServlet (name = "AddBlogServlet", urlPatterns = {
    "/processBlog"
})
public class AddBlogServlet extends HttpServlet {
 
    @Resource (mappedName="jdbc:derby://localhost:1527")
    private DataSource dataSource;
    private String sqlCommand;
    private Logger logger; 
       
    public AddBlogServlet() {
        logger = Logger.getLogger(this.getClass().getName());
        
    }
     
    public void init(){
        
        ServletConfig config = getServletConfig();
        
        sqlCommand = "INSERT INTO Blog (author, title, content, dateAdded) VALUES (?,?,?,?)";
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        Connection conn = null;
        PreparedStatement stmt = null; 
        
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("email");
        
        if(email == null){
           response.sendRedirect("login.jsp"); 
        }
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        long date = System.currentTimeMillis();
        
        if(sqlCommand != null && dataSource != null) {
            try {
                conn = dataSource.getConnection();
                stmt = conn.prepareStatement(sqlCommand);
                
                stmt.setString(1, email);
                stmt.setString(2, title);
                stmt.setString(3, content);
                stmt.setLong(4, date);
                
                stmt.executeUpdate();
                
                if(stmt != null){
                    stmt.close();
                }
                
                if(conn != null){
                    conn.close();
                }
                
                response.sendRedirect("index.jsp");
            } catch(SQLException e){
                
            }
        }
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
