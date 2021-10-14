package mgl7460_projet1;

import java.sql.SQLException;
import java.util.Scanner;

public class theMain {
	public static void main(String[] args) throws SQLException {

		int option = 0;
		while (option != 8) {
			System.out.println("******BIENVENUE******");
			System.out.println("****** Veuillez choisir une option ******");
			System.out.println("1 - Gestion des livres");
			System.out.println("2 - Gestion des librairies");
			System.out.println("3 - Gestion des utilisateurs");
			System.out.println("4 - Liste des livres");
			System.out.println("5 - Chercher des livres");
			System.out.println("6 - S'enregistrer");
			System.out.println("7 - Se connecter");
			System.out.println("8 - Quitter");
			Scanner sc = new Scanner(System.in);
			System.out.println("Tapez un chiffre");
			option = sc.nextInt();
			sc.close();
			int choice = 0;
			switch (option) {
			case 1: {
				String roles = authentication.login();
				if (roles.equals("admin") || roles.equals("libraire")) {
					while (choice != 4) {
						System.out.println("****** Veuillez choisir une option ******");
						System.out.println("1 - Ajouter un livre");
						System.out.println("2 - Modifier un livre");
						System.out.println("3 - Supprimer un livre");
						System.out.println("4 - Quitter");
						Scanner sc2 = new Scanner(System.in);
						System.out.println("Tapez un chiffre");
						choice = sc2.nextInt();
						sc2.close();
						switch (choice) {
						case 1:
							books.insertBook();
							break;
						case 2:
							books.updateBook();
							break;
						case 3:
							books.deleteBook();
							break;
						case 4:
							System.out.println("Sortie de gestion des livres");
							break;
						default:
							break;
						}
					}
				} else {
					System.out.println("Vous n'avez pas les privilèges pour accéder à cette fonctionalité");
				}
			}

				break;

			case 2: {
				String roles = authentication.login();
				if (roles.equals("admin")) {
					while (choice != 6) {
						System.out.println("****** Veuillez choisir une option ******");
						System.out.println("1 - Ajouter une librairie");
						System.out.println("2 - Chercher une libraire");
						System.out.println("3 - Modifier une libraire");
						System.out.println("4 - Supprimer une libraire");
						System.out.println("5 - Liste des librairie");
						System.out.println("6 - Quitter");
						Scanner sc2 = new Scanner(System.in);
						System.out.println("Tapez un chiffre");
						choice = sc2.nextInt();
						sc2.close();
						switch (choice) {
						case 1:
							library.insertLibrary();
							break;
						case 2:
							library.searchLibrary();
							break;
						case 3:
							library.updateLibrary();
							break;
						case 4:
							library.deleteLibrary();
							break;
						case 5:
							library.allLibrary();
							break;
						case 6:
							System.out.println("Sortie de gestion des librairies");
							break;
						default:
							break;
						}
					}
				} else {
					System.out.println("Vous n'avez pas les privilèges pour accéder à cette fonctionalité");
				}
			}
				break;
			case 3:

				break;
			case 4:
				books.allBooks();
				break;
			case 5:
				books.searchBook();
				break;
			case 6:
				authentication.registration("slimane", "slimane", "password", "normal");
				break;
			case 7:
				authentication.login();
				break;
			case 8:
				System.out.println("************** AU REVOIR ***************");
				break;
			} // end du premier switch
		} // end method
	}
} // end class
