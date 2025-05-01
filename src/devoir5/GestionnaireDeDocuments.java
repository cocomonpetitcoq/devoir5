package devoir5;

import java.util.ArrayList;

public class GestionnaireDeDocuments {

	public static void main(String[] args) {
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
	
	public static void créerRoman() {
		System.out.println(" Le Titre est :");
		String titre =scanner.nextLine();
		System.out.println("L'auteur est ");
		String auteur=scanner.nextLine();
		System.out.println(" Le nombre de pages :");
		int nbPages = validerNombre();
		System.out.println(" Le nombre de copies a faire:");
		int nbCopies = validerNombre();
		System.out.println("Le Prix Litteraire ");
		String listePrixLittéraires= scanner.nextLine();
		
		ArrayList<String> prix = new ArrayList<>();
	    String nom;
	    do {
	        System.out.print("Ajouter un prix littéraire (laisser vide pour terminer) : ");
	        nom = nom.nextLine();
	        if (!nom.isEmpty()) {
	            prix.add(nom);
	        }
	    } while (!nom.isEmpty());

	    documents.add(new Roman(titre, nbCopies, auteur, nbPages, prix));
	    System.out.println("Roman créé avec succès.");
		

	}
}
