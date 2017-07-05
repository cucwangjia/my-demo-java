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
import static jdk.nashorn.internal.objects.NativeString.trim;

/**
 *
 * @author Administrator
 */
public class WOrders {
    int Uno;
    String list="\n";
    public void setUno(int n)
    {
        Uno = n;
    }
    public String getAll()
    {
         try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=WBuy;user=sa;password=123456");
           
            PreparedStatement stmt = conn.prepareStatement("select * from Orders where Uno=?");
             stmt.setInt(1,Uno);
            ResultSet ui = stmt.executeQuery();
           
            
            while(ui.next())
           {
             int a = ui.getInt("Pno");
             String b =ui.getString("Pname");
             int c = ui.getInt("Price");
             int d = ui.getInt("Number");
             String e = ui.getString("Address");
             
             list = list+a+","+b+","+c+","+d+","+e+";";

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
         return list;
    }
    
}
