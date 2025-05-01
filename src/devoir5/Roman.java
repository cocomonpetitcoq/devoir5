package devoir5;

import java.util.ArrayList;

public class Roman extends Livre {
	private ArrayList<String>listesPrixLiterraire;
	
	public Roman(String titre, int nbCopies, String auteur, int nbPages, ArrayList<String>listesPrixLiterraire) {
		super(titre,nbCopies,auteur,nbPages);
		this.listesPrixLiterraire=listesPrixLiterraire;
	}
	public ArrayList<String> getListesPrixLiteraire() {
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
		return  "Ce documneent est de type Roman. Ce Roman dont le titre est " + getTitre() + " a été écrit par " + getauteur() + " á " + getnbPages() +  " pages et vous avez "
	+ getNbCopies() + " copies et vous avez  gagné " + getListesPrixLiteraire()+ " prix Litteraires";
	}
	
	
}
