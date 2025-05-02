package devoir5;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionnaireDeDocuments {
	private static ArrayList<Document> documents = new ArrayList<Document>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int option;
		boolean arrêt = false;

		while (!arrêt) {
			afficherMenu();
			option = traiterOption(0, 9);

			switch (option) {
			case 0: {
				arrêt = true;
				break;
			}
			case 1: {
				break;
			}
			case 2: {
				break;
			}
			case 3: {
				break;
			}
			case 4: {
				break;
			}
			case 5: {
				break;
			}
			case 6: {
				break;
			}
			case 7: {
				break;
			}
			case 8: {
				break;
			}
			case 9: {
				break;
			}
			}
			System.out.print("\n");
		}
		System.out.println("Au revoir !");
		scanner.close();
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

	private static void afficherTypesDocuments() {
		System.out.println("\n==========AJOUTER UN DOCUMENT==========\n");
		System.out.println("1. Roman");
		System.out.println("2. Manuel");
		System.out.println("3. Revue");
		System.out.println("4. Dictionnaire");
		System.out.println("\nVeuillez choisir le type de document à créer.");
	}

	private static void énumérerMois() {
		Mois[] mois = Mois.values();

		System.out.println("\nListe des mois");
		for (int i = 0; i < mois.length; i++) {
			System.out.println((i + 1) + ". " + mois[i]);
		}
		System.out.println("\nVeuillez choisir un mois de publication pour la revue.");
	}

	private static void énumérerDomaines() {
		Domaine[] domaines = Domaine.values();

		System.out.println("\nListe des domaines");
		for (int i = 0; i < domaines.length; i++) {
			System.out.println((i + 1) + ". " + domaines[i]);
		}
		System.out.println("\nVeuillez choisir un domaine pour le manuel.");
	}

	private static void énumérerLangues() {
		Langue[] langues = Langue.values();

		System.out.println("\nListe des langues");
		for (int i = 0; i < langues.length; i++) {
			System.out.println((i + 1) + ". " + langues[i]);
		}
		System.out.println("\nVeuillez choisir une langue pour le dictionnaire.");
	}

	private static void créerDocument() {
		afficherTypesDocuments();
		int option = traiterOption(1, 4);
		switch (option) {
		case 1: {
			créerRoman();
			break;
		}
		case 2: {
			créerManuel();
			break;
		}
		case 3: {
			créerRevue();
			break;
		}
		case 4: {
			créerDictionnaire();
			break;
		}
		}
	}

	private static void créerRoman() {
		System.out.println("\n==========CRÉATION D'UN ROMAN==========");
		System.out.println("\nVeuillez fournir le titre du roman.");
		String titre = scanner.nextLine().trim();

		System.out.println("\nVeuillez fournir le nom de l'auteur du roman.");
		String auteur = scanner.nextLine().trim();

		System.out.println("\nVeuillez fournir le nombre de pages du roman.");
		int nbPages = validerNombre();

		System.out.println("\nVeuillez fournir le nombre de copies du roman que vous avez.");
		int nbCopies = validerNombre();

		ArrayList<String> listePrixLittéraires = new ArrayList<String>();

		System.out.println("\nCe roman a-t-il gagné un ou des prix littéraires ?\n1. Oui\n2. Non");
		int option = traiterOption(1, 2);

		while (option == 1) {
			System.out.println("\nVeuillez fournir le prix littéraire que ce roman a gagné.");
			listePrixLittéraires.add(scanner.nextLine().trim());

			System.out.println(
					"\nY a-t-il un ou plusieurs autres prix littéraires à ajouter à la liste ?\n1. Oui\n2. Non");
			option = traiterOption(1, 2);
		}

		documents.add(new Roman(titre, nbCopies, auteur, nbPages, listePrixLittéraires));
		System.out.println("\nLe roman a été créé et ajouté avec succès!");
	}
	private static void créerManuel() {
		
		System.out.print(" Le Titre est : ");
	    String titre = scanner.nextLine();

	    int nbCopies = validerNombre();

	    System.out.print("L'Auteur est : ");
	    String auteur = scanner.nextLine();

	    int nbPages = validerNombre(" ");

	    énumérerDomaines();
	    int choix = traiterOption(1, Domaine.values().length);
	    Domaine choixDomaine = Domaine.values()[choix - 1];

	    documents.add(new Manuel(titre, nbCopies, auteur, nbPages, choixDomaine));
	    System.out.println("Manuel créé avec succès.");
		
	}
}
