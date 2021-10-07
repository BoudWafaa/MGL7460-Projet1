package mgl7460_projet1;


import java.sql.*;
import java.util.*;

public class authentication {
	
	public static void registration(String name, String username, String password, String roles) {
		  Connection con = databaseConnection.connect();
		  PreparedStatement ps = null; 
		  try {
		    String sql = "INSERT INTO users(name, username, password, roles) VALUES(?,?,?,?) ";
		    ps = con.prepareStatement(sql);
		    ps.setString(1, name); 
		    ps.setString(2, username);
		    ps.setString(3, password);
		    ps.setString(4, roles);
		    ps.execute();
		    System.out.println("Data has been inserted!");
		  } catch(SQLException e) {
		    System.out.println(e.toString());
		  } finally {
		    try{
		      ps.close();
		      con.close();
		    } catch(SQLException e) {
		      System.out.println(e.toString());
		    }		    
		  }
  }
	
	
	public static void login() throws SQLException {
		  Connection con = databaseConnection.connect();
		  Statement stmt = con.createStatement(); 
		  Scanner sc = new Scanner(System.in);  
		  System.out.print("Username : ");  
		  String str1 = sc.next();  
		  System.out.print("Password : ");  
		  String str2 = sc.next();  
		  ResultSet rs = stmt.executeQuery("select * from users where username='" + str1 + "' and password='" + str2 + "'");  
		  if (rs.next())  
		   System.out.println("Welcome::: " + str1);  
		  else  
		   System.out.println("Invalid username and password");  
		  con.close(); 
		  
		  
		}//end method login
	
	
}// end class
