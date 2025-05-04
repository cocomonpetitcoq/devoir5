//https://en.wikipedia.org/wiki/Magazine#History

package devoir5;

import java.util.ArrayList;
import java.util.List;
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
		System.out.println("\n==========CRÉATION D'UN MANUEL==========");
		System.out.println("\nVeuillez fournir le titre du manuel.");
		String titre = scanner.nextLine().trim();

		System.out.println("\nVeuillez fournir le nom de l'auteur du manuel.");
		String auteur = scanner.nextLine().trim();

		System.out.println("\nVeuillez fournir le nombre de pages du manuel.");
		int nbPages = validerNombre();

		System.out.println("\nVeuillez fournir le nombre de copies du manuel que vous avez.");
		int nbCopies = validerNombre();

		énumérerDomaines();
		int option = traiterOption(1, Domaine.values().length);
		Domaine domaine = Domaine.values()[option - 1];

		documents.add(new Manuel(titre, nbCopies, auteur, nbPages, domaine));
		System.out.println("\nLe manuel a été créé et ajouté avec succès!");
	}

	private static int validerAnnéePublication() {
		int annéePublication = 0;
		boolean valide = false;

		System.out.println("\nVeuillez fournir l'année de publication de la revue.");

		while (!valide) {
			try {
				annéePublication = Integer.parseInt(scanner.nextLine().trim());
				if (annéePublication >= 1663) {
					valide = true;
				} else {
					System.out.println("\nAucune revue n'était publiée à cette époque. Réessayez.");
				}
			} catch (Exception e) {
				System.out.println("\nCeci est une entrée invalide. Recommencez.");
			}
		}
		return annéePublication;
	}
public static void modifierNbCopies(List<Document> documents, Scanner scanner) {
   
    if (documents.isEmpty()) {
        System.out.println("La liste de documents est vide.");
        return;
    }

    Document doc = trouverDocumentParNoEnregistrement(documents, scanner);
    System.out.println("Nombre de copies actuel : " + doc.getNbCopies());

    System.out.print("Voulez-vous augmenter (A) ou diminuer (D) le nombre de copies ? (A/D) : ");
    String choix = scanner.nextLine().trim().toUpperCase();

    if (choix.equals("A")) {
        int nb = validerNombre(scanner);
        doc.setNbCopies(doc.getNbCopies() + nb);
    } else if (choix.equals("D")) {
        int nb = validerNbCopiesDiminuer(doc, scanner);
        doc.setNbCopies(doc.getNbCopies() - nb);
    } else {
        System.out.println("Option invalide.");
    }
}
private static Document trouverDocumentParNoEnregistrement(List<Document> documents2, Scanner scanner2) {
	
	return null;
}

private static int validerNombre(Scanner scanner2) {
	
	return 0;
}

public static int validerNbCopiesDiminuer(Document doc, Scanner scanner) {
   
    int nb;
    while (true) {
        System.out.print("Combien de copies voulez-vous retirer (max " + doc.getNbCopies() + ") ? : ");
        try {
            nb = Integer.parseInt(scanner.nextLine());
            if (nb > 0 && nb <= doc.getNbCopies()) {
                return nb;
            } else {
                System.out.println("Veuillez entrer un entier positif inférieur ou égal au nombre de copies disponibles.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un entier valide.");
        }
    }
}

public static void modifierTitreDocument(List<Document> documents, Scanner scanner) {
    if (documents.isEmpty()) {
        System.out.println("La liste de documents est vide.");
        return;
    }

    afficherLivres(documents);
    Document doc = trouverDocumentParTitreEtNoEnregistrement(documents, scanner);

    System.out.print("Entrez le nouveau titre : ");
    String nouveauTitre = scanner.nextLine();
    System.out.println("Nouveau titre proposé : " + nouveauTitre);
    System.out.print("Confirmez-vous la modification ? (O/N) : ");
    String confirmation = scanner.nextLine().trim().toUpperCase();

    if (confirmation.equals("O")) {
        doc.setTitre(nouveauTitre);
        System.out.println("Titre modifié avec succès.");
    } else {
        System.out.println("Modification annulée.");
    }
}
public static void modifierAuteurLivre(List<Document> documents, Scanner scanner) {
    if (documents.isEmpty()) {
        System.out.println("La liste de documents est vide.");
        return;
    }

    List<Livre> livres = trouverDocumentsLivre(documents);
    afficherLivres(livres);
    Livre livre = trouverLivreParTitreEtAuteur(livres, scanner);

    System.out.print("Entrez le nouvel auteur : ");
    String nouvelAuteur = scanner.nextLine();
    System.out.println("Nouvel auteur proposé : " + nouvelAuteur);
    System.out.print("Confirmez-vous la modification ? (O/N) : ");
    String confirmation = scanner.nextLine().trim().toUpperCase();

    if (confirmation.equals("O")) {
        livre.setAuteur(nouvelAuteur);
        System.out.println("Auteur modifié avec succès.");
    } else {
        System.out.println("Modification annulée.");
    }
}
public static List<Livre> trouverDocumentsLivre(List<Document> documents) {
    
    List<Livre> livres = new ArrayList<>();
    for (Document doc : documents) {
        if (doc instanceof Livre) {
            livres.add((Livre) doc);
        }
    }
    return livres;
}

public static void afficherLivres(List<Livre> livres) {
    for (Document livre : livres) {
        System.out.println("Titre : " + livre.getTitre() + ", Auteur : " + livre.getAuteur());
    }
}

public static Livre trouverLivreParTitreEtAuteur(List<Livre> livres, Scanner scanner) {
    while (true) {
        System.out.print("Entrez le titre du livre : ");
        String titre = scanner.nextLine();
        System.out.print("Entrez l'auteur du livre : ");
        String auteur = scanner.nextLine();

        for (Livre livre : livres) {
            if (livre.getTitre().equalsIgnoreCase(titre) && livre.getAuteur().equalsIgnoreCase(auteur)) {
                return livre;
            }
        }
        System.out.println("Aucun livre ne correspond aux données fournies. Veuillez réessayer.");
    }
}
public static void ajoutDocumentsPredefinis(List<Document> documents) {
   
    for (int i = 1; i <= 3; i++) {
        documents.add(new Roman("Roman " + i, "Auteur R" + i, 5));
        documents.add(new Manuel("Manuel " + i, "Auteur M" + i, 3));
        documents.add(new Revue("Revue " + i, "Auteur V" + i, 2));
        documents.add(new Dictionnaire("Dictionnaire " + i, "Auteur D" + i, 1));
    }
}


}
