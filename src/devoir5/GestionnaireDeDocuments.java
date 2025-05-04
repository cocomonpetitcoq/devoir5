//https://en.wikipedia.org/wiki/Magazine#History
//https://www.baeldung.com/find-list-element-java#5-java-8-stream-api

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
				if (validerQuantitéDocuments()) {
					créerDocument();
				}
				break;
			}
			case 2: {
				if (validerQuantitéDocuments()) {
					supprimerDocument();
				}
				break;
			}
			case 3: {
				if (validerQuantitéDocuments()) {
					System.out.println("\n==========AFFICHER LES DOCUMENTS==========\n");
					afficherDocuments();
				}
				break;
			}
			case 4: {
				if (validerQuantitéDocuments()) {
					afficherCaractéristiquesDocument();
				}
				break;
			}
			case 5: {
				if (validerQuantitéDocuments()) {
					afficherPrixLittéraires();
				}
				break;
			}
			case 6: {
				if (validerQuantitéDocuments()) {
					modifierNbCopies();
				}
				break;
			}
			case 7: {
				if (validerQuantitéDocuments()) {
					modifierTitreDocument();
				}
				break;
			}
			case 8: {
				if (validerQuantitéDocuments()) {
					modifierAuteurLivre();
				}
				break;
			}
			case 9: {
				créerDocumentsPrédéfinis();
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

	private static int validerNombre() {
		int nombre = 0;
		boolean valide = false;

		while (!valide) {
			try {
				nombre = Integer.parseInt(scanner.nextLine().trim());
				if (nombre > 0) {
					valide = true;
				} else {
					System.out.println("\nVeuillez fournir un nombre entier positif. Réessayez.");
				}
			} catch (Exception e) {
				System.out.println("\nCeci est une entrée invalide. Recommencez.");
			}
		}
		return nombre;
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

	private static void modifierNbCopies() {
		System.out.println("\n==========MODIFIER LE NOMBRE DE COPIES D'UN DOCUMENT==========");   
    Document doc = trouverDocumentParNoEnregistrement();
    System.out.println("\nNombre de copies actuel : " + doc.getNbCopies());

    System.out.println("\nVoulez-vous augmenter ou diminuer le nombre de copies?\n1. Augmenter\n2. Diminuer");
		int option = traiterOption(1, 2);

		switch (option) {
			case 1: {
				System.out.println("\nVeuillez fournir le nombre de copies à ajouter.");
				int nbCopiesAugmenter = validerNombre();
				document.setNbCopies(document.getNbCopies() + nbCopiesAugmenter);
				break;
			}
			case 2: {
				System.out.println("\nVeuillez fournir le nombre de copies à enlever.");
				int nbCopiesDiminuer = validerNbCopiesDiminuer(document);
				document.setNbCopies(document.getNbCopies() - nbCopiesDiminuer);
				break;}
			}
			System.out.println("\nLe nombre de copies a été modifié avec succès!");
}

private static int validerNbCopiesDiminuer(Document doc) {
    int nb = 0;
		boolean valide = false;

    while (!valide) {
        try {
            nb = Integer.parseInt(scanner.nextLine().trim());
            if (nb > 0 && nb <= doc.getNbCopies()) {
                valide = true;
            } else {
							System.out.println("\nVeuillez fournir un nombre entier positif et inférieur au nombre de copies du document. Réessayez.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un entier valide.");
        }
    }
		return nb;
}

private static void modifierTitreDocument() {
	System.out.println("\n==========MODIFIER LE TITRE D'UN DOCUMENT==========\n");
	afficherDocuments();
    Document doc = trouverDocumentParTitreEtNoEnregistrement();

    System.out.println("\nEntrez le nouveau titre");
    String nouveauTitre = scanner.nextLine().trim();

    System.out.println("\nNouveau titre proposé : " + nouveauTitre);
    System.out.println("Confirmez-vous la modification ?\n1. Oui\n2. Non");
    int option = traiterOption(1, 2);

			if (option == 1) {
				document.setTitre(nouveauTitre);
				System.out.println("\nLe titre du document a été modifié avec succès!");
			}
    else {
        System.out.println("\nModification annulée.");
    }
}

private static void modifierAuteurLivre() {
	System.out.println("\n==========MODIFIER L'AUTEUR D'UN LIVRE==========");
	ArrayList<Livre> livres = trouverDocumentsLivre();
	if (livres.size() > 0) {
		afficherLivres(livres);
		Livre livre = trouverLivreParTitreEtAuteur(livres);

    System.out.println("\nEntrez le nouvel auteur : ");
    String nouvelAuteur = scanner.nextLine().trim();

    System.out.println("\nNouvel auteur proposé : " + nouvelAuteur);
    System.out.println("Confirmez-vous la modification ?\n1. Oui\n2. Non");
    int option = traiterOption(1, 2);

				if (option == 1) {
					livre.setAuteur(nouvelAuteur);
					System.out.println("\nL'auteur du livre a été modifié avec succès!");
				}
    else {
        System.out.println("Modification annulée.");
    }
}
else {
	System.out.println("\nIl n'y a aucun livre dans la liste de documents.");
}
}

private static ArrayList<Livre> trouverDocumentsLivre() {
	ArrayList<Livre> livres = new ArrayList<Livre>();

    for (Document doc : documents) {
        if (doc instanceof Livre) {
            livres.add(doc);
        }
    }
    return livres;
}

private static void afficherLivres(ArrayList<Livre> livres) {
	System.out.println("\nListe des livres");
    for (Document livre : livres) {
        System.out.println(livre.getTitre() + " - " + livre.getAuteur());
    }
}

private static Livre trouverLivreParTitreEtAuteur(ArrayList<Livre> livres) {
	Livre livre = null;
			boolean succès = false;

    while (!succès) {
			try {
				System.out.println("\nVeuillez fournir le titre d'un livre.");
				String titre = scanner.nextLine().trim();

				System.out.println("\nVeuillez fournir l'auteur d'un livre.");
				String auteur = scanner.nextLine().trim();

				livre = livres.stream().filter(livre -> livre.getTitre().equalsIgnoreCase(titre)
						&& livre.getAuteur().equalsIgnoreCase(auteur)).findFirst().get();

				if (livre != null) {
					succès = true;
				} else {
					System.out.println("\nAucun livre ne correspond à ces informations. Réessayez.");
				}
			} catch (Exception e) {
				System.out.println("\nUne erreur s'est produite. Veuillez recommencer.");
			}
    }
		return livre;
}
private static void ajoutDocumentsPrédéfinis() {
	documents.add(new Roman("Les Misérables", 6, "Victor Hugo", 1734, ArrayList<String>("Prix Goncourt", "Prix Goncourt")));
	documents.add(new Roman("Le Seigneur des Anneaux", 10, "J.R.R. Tolkien", 1536, ArrayList<String>()));
	documents.add(new Roman("1984", 3, "George Orwell", 2051, ArrayList<String>("Prix Renaudot")));
	documents.add(new Manuel("Les softskills pour les nuls", 2, "Nelly Magré", 277, Domaine.Médecine));
	documents.add(new Manuel("Éducation alimentaire : 21 ateliers d'éveil au goût et aux 5 sens", 1, "Carole Ligniez", 176, Domaine.Nutrition));
	documents.add(new Manuel("SOS mal de dos : les bons gestes et les bonnes postures", 4, "Frédéric Srour", 127, Domaine.Ergonomie));
	documents.add(new Revue("Protégez-vous", 2, Mois.Janvier, 2024));
	documents.add(new Revue("Protégez-vous", 1, Mois.Février, 2024));
	documents.add(new Revue("Protégez-vous", 2, Mois.Mars, 2024));
	documents.add(new Dictionnaire("Larousse de l'anglais", 1, Langue.ANGLAIS));
	documents.add(new Dictionnaire("Dictionnaire de français", 3, Langue.FRANÇAIS));
	documents.add(new Dictionnaire("Dictionnaire de l'allemand", 1, Langue.ALLEMAND));
	System.out.println("\nDocuments prédéfinis ont été ajoutés avec succès!");
}
}
