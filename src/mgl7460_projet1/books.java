package mgl7460_projet1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class books {
	public static void insertBook() {
		Connection con = databaseConnection.connect();
		PreparedStatement ps = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Titre du livre : ");
		String title = sc.next();
		System.out.print("Auteur : ");
		String author = sc.next();

		try {
			String sql = "INSERT INTO books(title, author) VALUES(?,?) ";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, author);
			ps.execute();
			System.out.println("Le livre a été insérée.");
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				ps.close();
				con.close();
				sc.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	} // end method

	public static void deleteBook() {
		Connection con = databaseConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "delete from books WHERE title = ? ";
			ps = con.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			System.out.print("Titre du livre que vous voulez supprimer : ");
			String title = sc.next();
			ps.setString(1, title);
			ps.execute();
			System.out.println("Le livre a bien été supprimer");
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			// always remember to close, am forgetting because this is teaching purposes
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	} // end method

	public static void allBooks() {
		Connection con = databaseConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM books";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("Liste des livres");
			while (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");

				System.out.println("Titre du livre: " + title);
				System.out.println("Auteur: " + author);
				System.out.println();
				System.out.println("************************");
				System.out.println();

			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

	} // end method

	public static void updateBook() {
		Connection con = databaseConnection.connect();
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE books set title = ?, author = ? WHERE title = ? ";
			ps = con.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			System.out.print("Titre du livre que vou voulez moodifier : ");
			String title = sc.next();
			System.out.print("Nouveau titre du livre: ");
			String title2 = sc.next();
			System.out.print("Auteur : ");
			String author = sc.next();
			ps.setString(1, title2);
			ps.setString(2, author);
			ps.setString(3, title);
			ps.execute();
			System.out.println("Data has been updated");
			sc.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

	} // end method

	public static void searchBook() {
		Connection con = databaseConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Nom librairie que vous cherchez : ");
			String name = sc.next();
			String sql = "SELECT * FROM library WHERE name = " + name + "";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("Liste des librariries");
			while (rs.next()) {
				String name2 = rs.getString("name");
				String address = rs.getString("address");
				String phone = rs.getString("phone");

				System.out.println("Nom: " + name2);
				System.out.println("Adresse: " + address);
				System.out.println("Numéro de téléphone: " + phone);
				System.out.println();
				System.out.println("************************");
				System.out.println();

			}
			sc.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

	} // end method
}
