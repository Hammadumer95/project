
package project;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MemberControl
{
    Scanner sc=new Scanner(System.in);
Connection con=null;
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
    
    public void Addmember(MemberDetail md)       
   { 
   try
       {
         System.out.println("\t================== Add Member Details =====================\t");
         Connect();
         System.out.println("Enter Member Name : ");
  md.Name=sc.nextLine();
     System.out.println("Enter CNIC Number : ");
    md.CNIC=sc.nextLine();
    System.out.println("Enter Residential Address : ");
  md.Address=sc.nextLine();
      System.out.println("Enter Contact Number : ");
     md.Contact=sc.nextLine();
         String Query="insert into memberdetail(membername,membercnic,memberaddress,membercontact,memberidate) values (?,?,?,?,?)";
       PreparedStatement pst=con.prepareStatement(Query);
       
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       Date date = new Date();
       md.IDate=dateFormat.format(date);
       pst.setString(1,md.Name);
       pst.setString(2,md.CNIC);
       pst.setString(3,md.Address);
       pst.setString(4,md.Contact);
       pst.setString(5,md.IDate);
       
       pst.executeUpdate();
       con.close();
       
       
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
       
       
       
       

   }
    
    public void showmember()
    {
        try
       {
           System.out.println("\t================== All Members Detail =====================\t");
          Connect();
          String Query="Select * from memberdetail";
       Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(Query);
        while(rs.next())
        {
           System.out.println(rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getString(3)+" : "+rs.getString(4)+" : "+rs.getString(5)+" : "+rs.getString(6));
        }
       con.close();
       
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
        
    }
}
//       long year = TimeUnit.MILLISECONDS.convert(365, TimeUnit.DAYS);
//Date expiry = new Date(System.currentTimeMillis() + year);
//       md.EDate=expiry;
       