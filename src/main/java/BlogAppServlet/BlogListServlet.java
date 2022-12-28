/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BlogAppServlet;

/**
 *
 * @author Kalina
 */
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author Kalina
 */

@WebServlet (name = "BlogListServlet", urlPatterns = {
    "/blogList"
})
public class BlogListServlet extends HttpServlet {
    private Logger logger;
    
    @PersistenceContext(unitName = "BlogAppPU")
    private EntityManager entityManager;
    
    
    public BlogListServlet() {
        logger = Logger.getLogger(this.getClass().getName());
        
        logger.info("Constructor");
    }
     
    public void init(){
        logger.info("init");
        
        ServletConfig config = getServletConfig();
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        List <Blog> blogList = null;
        
        if(entityManager!=null){
           String jpqlCommand = "SELECT b FROM Blog b";
           
           Query query = entityManager.createQuery(jpqlCommand);
           
           blogList = query.getResultList();
           
           request.setAttribute("blogList", blogList);
           
           RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allBlogs.jsp");
        
           dispatcher.forward(request, response);
        }
                
        logger.info("process");
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("get");
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("post");
        processRequest(request, response);
    }
}
