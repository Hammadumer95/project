/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.sql.*;
/**
 *
 * @author dellli7
 */
public class Database {
    
    
    public static Connection connect(Connection con)
    {
        try 
{
       String url="jdbc:mysql://localhost/ooad";
        String uname="root";
        String pass="12345678";    
       Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection(url,uname,pass);
       }
catch(Exception ex)
       {
           System.out.println(ex);
       }
        return con;
    }
}
