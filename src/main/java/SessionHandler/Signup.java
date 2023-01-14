/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SessionHandler;


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
@WebServlet (name = "Signup", urlPatterns = {
    "/processSignup"
})
public class Signup extends HttpServlet {
 
    @Resource (mappedName="jdbc/blogapp")
    private DataSource dataSource;
    private String sqlCommand;
    private Logger logger; 
    private String email;
    private String password;
       
    public Signup() {
        logger = Logger.getLogger(this.getClass().getName());
        
    }
     
    public void init(){
        
        ServletConfig config = getServletConfig();
        
        sqlCommand = "INSERT INTO BlogUsers (email, password) VALUES (?,?)";
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      
        email = request.getParameter("email");
        password = request.getParameter("password" );
        
        if(email!=null || password!=null){
            response.sendRedirect("signup.jsp");
        }
        
        Connection conn = null;
        PreparedStatement stmt = null; 
     
        if(sqlCommand != null && dataSource != null) {
            try {
                conn = dataSource.getConnection();
                stmt = conn.prepareStatement(sqlCommand);
                
                stmt.setString(1, email);
                stmt.setString(2, password);
                
                stmt.executeUpdate();
                
                HttpSession session = request.getSession(true);
                session.setAttribute("email", email);
                
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
