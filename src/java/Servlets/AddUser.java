
package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import Model.*;
import com.mongodb.MongoClient;
import java.io.PrintWriter;

public class AddUser extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Name = request.getParameter("Name");
		String Email = request.getParameter("Email");
		if((Name.isEmpty()))
		{
			RequestDispatcher rd = request.getRequestDispatcher("Input.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{
                        User u = new User();
			u.setName(Name);
			u.setEmail(Email);
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			UserDAO userDAO = new UserDAO(mongo);
			userDAO.createUser(u);
			System.out.println("User Added Successfully with id="+u.getUserId());
			request.setAttribute("success", "User Added Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("Output.jsp");
			rd.forward(request, response);
		}
	}
    
    
}


