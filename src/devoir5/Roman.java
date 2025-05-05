/*NOMS DES MEMBRES ET CODES PERMANENTS :
 * 
 * Martel,Angela                           MARA22559304
 * Kamgaing Koudjou,Arnold Ulrich          KAMA72320600
 * Mbonwo Kenne,Lesline                    MBOL87300100
 * Enga Enga,Mike Landry                   ENGM66310200 
 * 
 * 
 * 
 * DESCRIPTION : L’objectif est de représenter un type de livre qui peut avoir remporté plusieurs prix littéraires afin de valoriser ces œuvres et faciliter leur identification dans la collection.
*/

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
			System.out.println("\nCe roman n'a pas gagné de prix littéraires.");
		} else {
			System.out.println("\nCe roman a gagné :");
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
