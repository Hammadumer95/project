
package project;
import java.sql.*;

public class Receipt 
{
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
    
    public void print(PurchaseDetail pd)
    {try
    { System.out.println("\t=================================\t");
    System.out.println("\t*\tOriginal Receipt\t*\t");
    System.out.println("\t=================================\t");
        
        Connect();
        String Query1="select saleid,saledate,salebill from saledetail where saleid="+pd.purchaseid;
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(Query1);
        rs.next();
        System.out.println("Receipt ID : "+rs.getString(1));
        System.out.println("Date/Time : "+rs.getString(2));
        String t=rs.getString(3);
        String Query2="select p.productname,s.qty ,(p.productprice*s.qty) price from product p inner join sale s on p.productid=s.productid where s.saleid="+ pd.purchaseid;
        Statement st1=con.createStatement();
        ResultSet rs1=st1.executeQuery(Query2);
        System.out.println("--------------------------------------------------");
        System.out.println("Item no    |      Product     |  Qty  |   Amount   ");
        System.out.println("--------------------------------------------------");
        int count=1;
        while(rs1.next())
        {
           System.out.println(count+"\t     "+rs1.getString(1)+"\t  "+rs1.getString(2)+"\t"+rs1.getString(3));
       count++;
       
        }
        System.out.println("\t-----------------------------------\t");
        System.out.println("\t   Total Amount : "+t);
    System.out.println("\t-----------------------------------\t");
    con.close();
    }
    catch(Exception ex)
                {
                System.out.println(ex);
                }
    
    }
        
        
    }//MuzammilUmarOfficial.AllRightsReserved.
  
    

