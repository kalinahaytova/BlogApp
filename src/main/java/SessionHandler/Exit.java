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
import java.util.logging.Logger;

/**
 *
 * @author Kalina
 */
@WebServlet (name = "Exit", urlPatterns = {
    "/exit"
})
public class Exit extends HttpServlet {
    private Logger logger; 
    
    public Exit() {
        logger = Logger.getLogger(this.getClass().getName());
        
    }
     
    public void init(){
        
        ServletConfig config = getServletConfig();
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      
        HttpSession session = request.getSession(false); 
        session.removeAttribute("email");
        
        response.sendRedirect("index.jsp");
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
