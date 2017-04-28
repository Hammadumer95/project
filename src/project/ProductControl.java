/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author dellli7
 */
public class ProductControl {
    Scanner sc=new Scanner(System.in);
    protected Connection con=null;
   public void Connect()
   {
       try {
       String url="jdbc:mysql://localhost/ooad";
        String uname="root";
        String pass="12345678";    
       Class.forName("com.mysql.jdbc.Driver");
       con = DriverManager.getConnection(url,uname,pass);
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
   }
    
    public void Addproduct(ProductDetail pd)       
   { 
   try
       {
           System.out.println("\t================== Add Product Details =====================\t");
          Connect();
          {
          System.out.println("Enter Product Name : ");
          pd.productname=sc.nextLine();
          System.out.println("Enter Product Price : ");
          pd.productprice=sc.nextDouble();
          String Query="insert into product(productname,productprice) values (?,?)";
       PreparedStatement pst=con.prepareStatement(Query);
       
       pst.setString(1,pd.productname);
       pst.setDouble(2,pd.productprice);
       pst.executeUpdate();
          }
          
       con.close();
       
       
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
       
       
       
       

   }
    
    public void showallproducts()
    {
        try
       {
           System.out.println("\t================== All Products Detail =====================\t");
          Connect();
          String Query="Select * from product";
       Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(Query);
        while(rs.next())
        {
          
           System.out.println(rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getString(3));
        }
       con.close();
       
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
        
    }
}
    

