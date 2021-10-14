package mgl7460_projet1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
			System.out.println("User has been inserted!");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

	}

	public static String login() throws SQLException {
		Connection con = databaseConnection.connect();
		Statement stmt = con.createStatement();

		Scanner sc = new Scanner(System.in);
		System.out.print("Username : ");
		String str1 = sc.next();
		System.out.print("Password : ");
		String str2 = sc.next();
		ResultSet rs = stmt
				.executeQuery("select * from users where username='" + str1 + "' and password='" + str2 + "'");

		if (rs.next()) {
			String roles = rs.getString(5);
			System.out.println("Bienvenue::: " + str1);
			con.close();
			sc.close();
			return roles;
		} else
			System.out.println("Nom d'utilisateur ou mot de passe invalides");
		con.close();
		sc.close();
		return "InvalidUser";

	}// end method login

}// end class
