package devoir5;

import java.util.ArrayList;

public class Roman extends Livre {
	private ArrayList<String> listePrixLittéraires;

	public Roman(String titre, int nbCopies, String auteur, int nbPages, ArrayList<String> listePrixLittéraires) {
		super(titre, nbCopies, auteur, nbPages);
		this.listePrixLittéraires = listePrixLittéraires;
	}

	public ArrayList<String> getListePrixLittéraires() {
		return listePrixLittéraires;
	}

	public void afficherListePrixLittéraires() {
		if (listePrixLittéraires.isEmpty()) {
			System.out.println("Ce roman n'a pas gagné de prix littéraires.");
		} else {
			System.out.println("Ce roman a gagné :");
			for (String prix : listePrixLittéraires) {
				System.out.println(prix);
			}
		}
	}

	public String toString() {
		return "Ce document est de type roman. Ce roman, dont le titre est " + getTitre() + ", a été écrit par "
				+ getAuteur() + ", a " + getNbPages() + " pages et a gagné " + getListePrixLittéraires().size()
				+ " prix littéraires. Vous avez " + getNbCopies() + " copies.";
	}

}
