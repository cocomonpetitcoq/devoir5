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
	
	private static void énumérerMois() {
		Mois[] mois = Mois.values();

		System.out.println("\nListe des mois");
		for (int i = 0; i < mois.length; i++) {
			System.out.println((i + 1) + ". " + mois[i]);
		}
		System.out.println("\nVeuillez choisir un mois de publication pour la revue.");
		}
	}
