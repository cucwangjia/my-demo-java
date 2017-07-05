package jsp.beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static jdk.nashorn.internal.objects.NativeString.trim;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class WCheck {
  String UserName,Password;
    int flag,Uno ;
       public String getUid()
    {
        return UserName;
    }
       public String getUpw()
    {
        return Password;
    }
    public void setUid(String n)
    {
        UserName = n;
        
    }
    public void setUpw(String p)
    {
        Password = p;
    }
    public int result(){
     try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=WBuy;user=sa;password=123456");
           
            PreparedStatement stmt = conn.prepareStatement("select Uno,Upw from UI where Uid=?");
             stmt.setString(1,UserName);
            ResultSet ui = stmt.executeQuery();
           
            
            while(ui.next())
           {
               int o = ui.getInt("Uno");
             
             String p = trim(ui.getString("Upw"));
              System.out.println(p);
              
            
                 if(Password.equals(p))
                 {Uno = o;
                  flag = 1;}
              
                 
            
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
     return flag;
    }   
    public int getUno()
    {
        
        return Uno;
    }
 
    
}
   

