package mgl7460_projet1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class library {
	
	public static void insertLibrary() {
		  Connection con = databaseConnection.connect();
		  PreparedStatement ps = null; 
		  Scanner sc = new Scanner(System.in);  
		  System.out.print("Nom librairie : ");  
		  String name = sc.next();  
		  System.out.print("Adresse : ");  
		  String address = sc.next(); 
		  System.out.print("Numéro de téléphone : ");  
		  String phoneNumber = sc.next(); 
		  
		  try {
		    String sql = "INSERT INTO library(name, address, phone) VALUES(?,?,?) ";
		    ps = con.prepareStatement(sql);
		    ps.setString(1, name); 
		    ps.setString(2, address);
		    ps.setString(3, phoneNumber);
		    ps.execute();
		    System.out.println("La librairie a été insérée.");
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
	} // end method	
	
	public static void deleteLibrary() {
	    Connection con = databaseConnection.connect(); 
	    PreparedStatement ps = null; 
	    try {
	      String sql = "delete from library WHERE name = ? "; 
	      ps = con.prepareStatement(sql); 
	      Scanner sc = new Scanner(System.in);  
		  System.out.print("Nom librairie que vous voulez supprimer : ");  
		  String name = sc.next();
	      ps.setString(1, name);
	      ps.execute();
	      System.out.println("Librairie a bien été supprimer");
	    } catch (Exception e) {
	      // TODO: handle exception
	      System.out.println(e.toString());
	    } finally {
	      //always remember to close, am forgetting because this is teaching purposes
	      try {
	        ps.close();
	        con.close(); 
	      } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      } 
	      
	      
	    }
	} // end method	
	
	public static void allLibrary() {
	    Connection con = databaseConnection.connect(); 
	    PreparedStatement ps = null; 
	    ResultSet rs = null; 
	    
	    try {
	      String sql = "SELECT * FROM library";
	      ps = con.prepareStatement(sql); 
	      rs = ps.executeQuery();
	      System.out.println("Liste des librariries");
	      while(rs.next()) {
	        String name = rs.getString("name"); 
	        String address = rs.getString("address"); 
	        String phone = rs.getString("phone");        
	        
	        
	        System.out.println("Nom: "+name);
	        System.out.println("Adresse: "+address);
	        System.out.println("Numéro de téléphone: "+phone);
	        System.out.println();
	        System.out.println("************************");
	        System.out.println();
	        
	      }
	    } catch(SQLException e) {
	      System.out.println(e.toString());
	    } finally {
	      try {
	        rs.close();
	        ps.close();
	        con.close(); 
	      } catch(SQLException e) {
	        System.out.println(e.toString());
	      }
	    }
	    
	} // end method	
	
	
	public static void updateLibrary() {
	    Connection con = databaseConnection.connect(); 
	    PreparedStatement ps = null; 
	    try {
	      String sql = "UPDATE library set name = ?, address = ?, phone = ? WHERE name = ? ";
	      ps = con.prepareStatement(sql); 
	      Scanner sc = new Scanner(System.in);  
		  System.out.print("Nom librairie que vou voulez moodifier : ");  
		  String name = sc.next();  
		  System.out.print("Nouveau nom de la librairie : ");  
		  String name2 = sc.next();  
		  System.out.print("Adresse : ");  
		  String address = sc.next(); 
		  System.out.print("Numéro de téléphone : ");  
		  String phoneNumber = sc.next(); 
	      ps.setString(1, name2);
	      ps.setString(2, address);
	      ps.setString(3, phoneNumber);
	      ps.setString(4, name);
	      ps.execute();
	      System.out.println("Data has been updated");
	    } catch (SQLException e) {
	      // TODO: handle exception
	      System.out.println(e.toString());
	    }
	    
	} // end method	
	
	
	public static void searchLibrary() {
	    Connection con = databaseConnection.connect(); 
	    PreparedStatement ps = null; 
	    ResultSet rs = null; 
	    
	    try {
	      Scanner sc = new Scanner(System.in);  
	      System.out.print("Nom librairie que vous cherchez : ");  
	      String name = sc.next();  
	      String sql = "SELECT * FROM library WHERE name = "+name+"";
	      ps = con.prepareStatement(sql); 
	      rs = ps.executeQuery();
	      System.out.println("Liste des librariries");
	      while(rs.next()) {
	        String name2 = rs.getString("name"); 
	        String address = rs.getString("address"); 
	        String phone = rs.getString("phone");        
	        
	        
	        System.out.println("Nom: "+name2);
	        System.out.println("Adresse: "+address);
	        System.out.println("Numéro de téléphone: "+phone);
	        System.out.println();
	        System.out.println("************************");
	        System.out.println();
	        
	      }
	    } catch(SQLException e) {
	      System.out.println(e.toString());
	    } finally {
	      try {
	        rs.close();
	        ps.close();
	        con.close(); 
	      } catch(SQLException e) {
	        System.out.println(e.toString());
	      }
	    }
	    
	} // end method	
	
}
