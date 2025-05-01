package devoir5;

import java.util.ArrayList;

public class Roman extends Livre {
	private ArrayList<String>prixLiterraire;
	
	public Roman(String titre, int nbCopies, String auteur, int nbPages, ArrayList<String>prixLiterraire) {
		super(titre,nbCopies,auteur,nbPages);
		this.prixLiterraire=prixLiterraire;
	}
	public ArrayList<String> getprixLiteraire() {
		return prixLiterraire;
	}
	public void afficherListePrixLiterraire() {
		if (prixLiterraire.isEmpty()) {
			System.out.println("Ce Roman n'as pas gagné de prix Litteraire");
		}else {
			System.out.println("Ce roman a gagné ");
			for (String prix : prixLiterraire) {
				System.out.println(prix);
			}
		}
	}
	public String toString() {
		return "Ce manuel dont le titre est " + titre  + "a été écrit par " + auteur + " á " + nbPages + " pages et vous avez"
	+ nbCopies + "copies" + " et vous avez  gagné " + prixLiterraire + " prix Litteraires";
	}
	
	
}
