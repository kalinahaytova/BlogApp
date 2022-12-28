/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BlogAppServlet;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kalina
 */
@Entity

@Table (name = "blog")

public class Blog implements Serializable {
    
    @Id
    @Column(name = "title")
    private String title;  
    
    @Id
    @Column(name = "author")
    private String author;
     
    @Id
    @Column(name = "content")
    private String content;
    
    @Id
    @Column(name = "dateAdded")
    private String dateAdded;
   
    @Id
    @Column(name = "id")
    private int id;

    public Blog() {
        author = null;
        title = null; 
        content = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
    
    public Date getDateAdded() {
        Date date = new Date(dateAdded);
        return date;
    }
    
}