package devoir5;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionnaireDeDocuments {
	
	private static ArrayList<Document> documents = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
	private static int option;
	public static void main(String[] args) {
	
		boolean arrêt = false;
	
		
	

		while (!arrêt) {
			option = traiterOption(1, 10);

			afficherMenu();
            option = traiterOption(1, 10); 
        	switch (option) {
                case 1:{

                	break;
                }
                case 2:{
      
                	break;
                }
                case 3:{

                	break;
                }
                case 4:{

                	break;
                }
                case 5:{
                	
                	  break;
                }
                  
                case 6:{
                	
                	  break;
                }

                case 7:{
                	
                	  break;
                }
                case 8:{
                	
                    break;

                }
                case 9:{
                	
                    break;

                }
                   
                case 10:{
                	
                    break;

                }
 
		}	
		}
	}
		

	
	private static void afficherMenu() {
		System.out.println("==========MENU==========\n");
		System.out.println("Option 1 : Ajouter un document");
		System.out.println("Option 2 : Supprimer un document");
		System.out.println("Option 3 : Afficher tous les documents");
		System.out.println("Option 4 : Afficher les caractéristiques d'un document");
		System.out.println("Option 5 : Afficher la liste des prix littéraires d'un roman");
		System.out.println("Option 6 : Augmenter ou diminuer le nombre de copies d'un document");
		System.out.println("Option 7 : Modifier le titre d'un document");
		System.out.println("Option 8 : Modifier l'auteur d'un livre");
		System.out.println("Option 9 : Créer et ajouter 12 documents prédéfinis");
		System.out.println("Appuyez sur 0 pour quitter.\n");
		System.out.println("Veuillez choisir une option.");
	}

	private static int traiterOption(int min, int max) {
		int option = -1;
		boolean valide = false;

		while (!valide) {
			try {
				option = Integer.parseInt(scanner.nextLine().trim());
				if (option >= min && option <= max) {
					valide = true;
				} else {
					System.out.println("\nVotre choix ne fait pas partie des options valides. Réessayez.");
				}
			} catch (Exception e) {
				System.out.println("\nCeci est une entrée invalide. Recommencez.");
			}
		}
		return option;
	}

	private static boolean validerQuantitéDocuments() {
		if (documents.isEmpty()) {
			System.out.println("\nLa liste de documents est vide.");
			return false;
		} else {
			return true;
		}
	}
}
