package devoir5;

import java.util.ArrayList;

public class Roman extends Livre {
	private ArrayList<String>listesPrixLiterraire;
	
	public Roman(String titre, int nbCopies, String auteur, int nbPages, ArrayList<String>listesPrixLiterraire) {
		super(titre,nbCopies,auteur,nbPages);
		this.listesPrixLiterraire=listesPrixLiterraire;
	}
	public ArrayList<String> getlistesPrixLiteraire() {
		return listesPrixLiterraire;
	}
	public void afficherListePrixLiterraire() {
		if (listesPrixLiterraire.isEmpty()) {
			System.out.println("Ce roman n'as pas gagné de prix litteraire");
		}else {
			System.out.println("Ce roman a gagné ");
			for (String prix : listesPrixLiterraire) {
				System.out.println(prix);
			}
		}
	}
	public String toString() {
		return  "Ce documneent est de type Roman." + "Ce Roman dont le titre est " + titre  + "a été écrit par " + auteur + " á " + nbPages + " pages et vous avez"
	+ nbCopies + "copies" + " et vous avez  gagné " + listesPrixLiterraire + " prix Litteraires";
	}
	
	
}
