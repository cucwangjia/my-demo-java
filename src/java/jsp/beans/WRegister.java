package jsp.beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
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
public class WRegister {
    String UserName,Password;
    int Uno;
  
    public void getStr(String n,String p)
    {
        UserName = n;
        Password = p;
    }
    public void result(){
        
     try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=WBuy;user=sa;password=123456");
            
            
              PreparedStatement stmt1 = conn.prepareStatement("insert into [UI](Uid,Upw) values(?,?)");
              stmt1.setString(1,UserName);
              stmt1.setString(2,Password);
              stmt1.executeUpdate();
    
              PreparedStatement stmt2 = conn.prepareStatement("select Uno from [UI] where Uid = ?");
              stmt2.setString(1,UserName);
             
              ResultSet rs = stmt2.executeQuery();
              
               while(rs.next())
              {                
                   Uno = rs.getInt(1);
                            
              } 
              
              conn.close();
              stmt1.close();
              stmt2.close();
              
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
