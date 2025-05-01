package devoir5;

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

	private static void énumérerDomaines() {
		Domaine[] domaines = Domaine.values();

		System.out.println("\nListe des domaines");
		for (int i = 0; i < domaines.length; i++) {
			System.out.println((i + 1) + ". " + domaines[i]);
		}
		System.out.println("\nVeuillez choisir un domaine pour le manuel.");
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
	private static void créerRevue() {
	    System.out.print(" Le Titre est : ");
	    String titre = scanner.nextLine();

	    int nbCopies = validerNombre();

	    énumérerMois();
	    int moisChoisi = traiterOption(1, Mois.values().length);
	    Mois mois = Mois.values()[moisChoisi - 1];
	    System.out.print(" L'année de Fabrication est : ");
	    int annee = validerAnnéePublication();

	    documents.add(new Revue(titre, nbCopies, mois, annee));
	    System.out.println("Revue créé avec succès.");
	}
}
