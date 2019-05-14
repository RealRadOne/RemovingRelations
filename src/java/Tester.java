/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sakshi Sinha
 */
import Converter.*;
import DAO.*;
import Model.*;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.List;
/**
 *
 * @author Sakshi Sinha
 */
public class Tester
{
    public static void main (String args[])throws UnknownHostException 
 {
User u=new User();
u.setName("Akshita");
u.setEmail("SAKHISS");
 MongoClient mongo = new MongoClient("localhost", 27017);
 UserDAO uodc = new UserDAO(mongo);
   //Create
 uodc.createUser(u);
 System.out.println("User Added Successfully with id="+u.getUserId()+","+u.getName()+","+u.getEmail());
   List<User> list=uodc.readAllUser();
   for(User us:list)
   {
       System.out.println(us.getName()+","+us.getUserId()+","+us.getEmail());
   }
   
 }
}
