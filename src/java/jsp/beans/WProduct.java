/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static jdk.nashorn.internal.objects.NativeString.trim;

/**
 *
 * @author Administrator
 */
public class WProduct {
    int Uno;
    int Pno;
    int Pnum;
    String uid;
    String name;
    int price;
    String address;
    public void getPnum(String no)
    {
        try {
        int a = Integer.parseInt(no);
        Pnum = a ;
             } 
        catch (NumberFormatException e) {
                e.printStackTrace();
          }
        
    }
    
    public double getPrice()
    {
        return price;
    }
    public String getPname()
    {
        return name;
    }
    public void setUid(String s)
    {
        uid = s;
    }
    public String getUid()
    {
        return uid;
    }
    public void setUno(int n)
    {
        Uno = n;
    }
    public int getPno(String s)
    {  
         name = s;
         try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=WBuy;user=sa;password=123456");
           
            PreparedStatement stmt = conn.prepareStatement("select Pno,Price from Products where Pname = ? ");
            stmt.setString(1,name);
            ResultSet ui = stmt.executeQuery();
            
            
            while(ui.next())
           {
             Pno = ui.getInt(1);
             price = ui.getInt(2);
           }
              conn.close();
              stmt.close();
     
        }
           catch(SQLException sqle)
        {
           System.out.println(sqle.getMessage());
        }
        catch(ClassNotFoundException cnfe)
        {
           System.out.println(cnfe.getMessage());   
        }  
         return Pno;
    }
    public void getAdd(String a)
    {
        address = a;
        
    }
    public void AddOrder()
    {
          try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=WBuy;user=sa;password=123456");
           
            PreparedStatement stmt = conn.prepareStatement("insert into Orders(Uno,Pno,Pname,Price,Number,Address) values(?,?,?,?,?,?)");
            stmt.setInt(1,Uno);
            stmt.setInt(2,Pno);
            stmt.setString(3,name);
            stmt.setInt(4,price);
            stmt.setInt(5,Pnum);
            stmt.setString(6,address);
            stmt.executeUpdate();
            
          
              conn.close();
              stmt.close();
     
        }
           catch(SQLException sqle)
        {
           System.out.println(sqle.getMessage());
        }
        catch(ClassNotFoundException cnfe)
        {
           System.out.println(cnfe.getMessage());   
        }   
    }
}
