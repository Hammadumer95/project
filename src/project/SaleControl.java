/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
//MuzammilUmarOfficial.AllRightsReserved.
 * and open the template in the editor.
 */
package project;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author dellli7
 */
public class SaleControl {
    Scanner sc=new Scanner(System.in);
     PreparedStatement pst;
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
    
    public void Productsale(SaleDetail sd ,PurchaseDetail pd)       
   { 
   try
       {
       System.out.println("\t================== Product Purchase =====================\t");
       Connect();
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       java.util.Date date = new java.util.Date();
       pd.purchasedate=dateFormat.format(date);
       String Query1="insert into saledetail (saledate) values (?)" ;
       pst=con.prepareStatement(Query1);
      pst.setString(1,pd.purchasedate);
      pst.executeUpdate();
       String Query2="select max(saleid) from saledetail";
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery(Query2);
       rs.next();
       pd.purchaseid=rs.getInt(1);
       int exit =1;
       while(exit!=0)
       {
          System.out.println("Enter Product id : ");
        sd.productid=sc.nextInt();
          System.out.println("Enter Product quantity : ");
          sd.qty=sc.nextInt();
          String Query="insert into sale (saleid,productid,qty) values (?,?,?)" ;
       pst=con.prepareStatement(Query);
       
       pst.setInt(1,pd.purchaseid);
       pst.setDouble(2,sd.productid);
       pst.setDouble(3,sd.qty);
       pst.executeUpdate();
       exit =sc.nextInt();
       }
      con.close();
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
       
       
       
       

   }
    
    
    public void showsaleinfo(PurchaseDetail pd)
    {
        try
       {
           System.out.println("\t================== Sale Detail =====================\t");
          Connect();
       String Query="select p.productname,s.qty ,(p.productprice*s.qty) price from product p inner join sale s on p.productid=s.productid where s.saleid="+ pd.purchaseid;
       Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(Query);
       pd.purchasebill=0;
        while(rs.next())
        {
           System.out.println(rs.getString(1)+" \t: "+rs.getString(2)+" \t: "+rs.getString(3));
       pd.purchasebill=pd.purchasebill+rs.getDouble(3);
       
       
        }
        String Query1="update saledetail set salebill="+pd.purchasebill+"where saleid="+pd.purchaseid;
           pst=con.prepareCall(Query1);
           pst.executeUpdate();
        System.out.println("Done");
       con.close();
       
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
    }
   }
