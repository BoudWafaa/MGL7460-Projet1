package mgl7460_projet1;

import java.sql.SQLException;

public class theMain {
	public static void main(String [] args) throws SQLException {
		
		
		authentication.registration("test", "test", "test", "admin");
		authentication.login();
	  }	
}
