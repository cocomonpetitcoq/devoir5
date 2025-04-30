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
	public String toString() {
		return "le titre de ce roman est " + titre + "Le nombre de copies du roman est " + nbCopies + "Le nombre de pages du roman est" + nbPages + "L'auteur du Roman est " + auteur + ""
				+ "le prix du roman est" + prixLiterraire ;
	}
	
	
}
