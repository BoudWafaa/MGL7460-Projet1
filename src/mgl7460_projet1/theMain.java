package mgl7460_projet1;

import java.sql.SQLException;
import java.util.Scanner;

public class theMain {
	public static void main(String [] args) throws SQLException {
		
		System.out.println("******BIENVENUE******");
		System.out.println("****** Veuillez choisir une option ******");
		System.out.println("1 - Gestion des livres");
		System.out.println("2 - Gestion des librairies");
		System.out.println("3 - Gestion des utilisateurs");
		System.out.println("4 - Liste des livres");
		System.out.println("5 - Chercher des livres");
		System.out.println("6 - S'enregistrer");
		System.out.println("7 - Se connecter");
		Scanner sc = new Scanner(System.in);
		System.out.println("Tapez un chiffre");
		String option = sc.next();  
		int choice = 0;
		switch (option) {
			  case "1":
			    
			    break;		    
			    
			    
			  case "2":{
				String roles = authentication.login();				
				if (roles.equals("admin")) {					
					while (choice != 6)  {
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
			  case "3":
			    System.out.println("Wednesday");
			    break;
			  case "4":
			    System.out.println("Thursday");
			    break;
			  case "5":
			    System.out.println("Friday");
			    break;
			  case "6":
				    authentication.registration("slimane","slimane", "password", "normal");
				    break;
		} // end du premier switch
	  }	// end method
} // end class
