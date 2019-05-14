package Servlets;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 
import Model.*;
import DAO.*;
import com.mongodb.MongoClient;
 
public class ViewUsers extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
       // out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Users List</h1>");  
        MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
	UserDAO userDAO = new UserDAO(mongo);
        List<User> list=userDAO.readAllUser();  
          
        out.print("<table border='1' width='100%'");  
        for(User us:list)
        {  
                 out.print("<tr><td>"+us.getUserId()+"</td><td>"+us.getName()+"</td><td>"+us.getEmail()+"</td></tr>");   
        }  
        out.print("</table>");   
        out.close();  
    }  
}  