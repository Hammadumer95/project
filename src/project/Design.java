/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
//MuzammilUmarOfficial.AllRightsReserved.
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;

/**
 *
 * @author dellli7
 */
public class Design {
    SaleDetail sd=new SaleDetail();
    PurchaseDetail pd=new PurchaseDetail();
    SaleControl sac=new SaleControl();
    Receipt r=new Receipt();
    ProductControl pc=new ProductControl();
    ProductDetail prd=new ProductDetail();
    MemberControl mc=new MemberControl();
     MemberDetail md=new MemberDetail();
    Scanner sc=new Scanner(System.in);
    public void  MainDesign()
    {
        System.out.println("==============================================================");
        System.out.println("================= Shop Management System =====================");
        System.out.println("==============================================================");
        
        System.out.println("Press 1 : Sale");
        System.out.println("Press 2 : Products Detail");
        System.out.println("Press 3 : Membership");
        
        String act=sc.nextLine();
        switch(act)
        {
            case "1": 
                saledesign();
            break;
            
            case "2":
                productdesign();
                break;
            case "3":
            memberdesign();
            break;
                
                
        }
    }
   
    public void saledesign()
    {
        System.out.println("============================================");
        System.out.println("================= Sale =====================");
        System.out.println("============================================");
        System.out.println("Press 0 : Exit");
        sac.Productsale(sd, pd);
            sac.showsaleinfo(pd);
            r.print(pd);
    }
    
    public void productdesign()
    {
        System.out.println("===============================================");
        System.out.println("================= Product =====================");
        System.out.println("===============================================");
        System.out.println("Press 1 : Add Product");
        System.out.println("Press 2 : View Products");
        System.out.println("Press 0 : Exit");
         String act=sc.nextLine();
        switch(act)
        {
            case "1": 
                pc.Addproduct(prd);
            break;
            
            case "2":
                 pc.showallproducts();
                break;
            
                
                
        }
    }
    
    public void memberdesign()
    {
        System.out.println("==================================================");
        System.out.println("================= Membership =====================");
        System.out.println("==================================================");
        System.out.println("Press 1 : Add Member");
        System.out.println("Press 2 : View Members");
        System.out.println("Press 0 : Exit");
         String act=sc.nextLine();
        switch(act)
        {
            case "1": 
                mc.Addmember(md);
               
            break;
            
            case "2":
                 mc.showmember();
                break;
            
                
                
        }
    }
}
