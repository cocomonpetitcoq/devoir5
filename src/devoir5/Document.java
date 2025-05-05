/*NOMS DES MEMBRES ET CODES PERMANENTS :
 * 
 * Martel,Angela                           MARA22559304
 * Kamgaing Koudjou,Arnold Ulrich          KAMA72320600
 * Mbonwo Kenne,Lesline                    MBOL87300100
 * Enga Enga,Mike Landry                   ENGM66310200
 * 
 * 
 * 
 * 
 * DESCRIPTION : L’objectif est de définir la classe de base commune à tous les documents, avec un numéro d’enregistrement unique, un titre et un nombre de copies modifiable, pour permettre une gestion uniforme des différents types de documents.
 * 
 * RÉFÉRENCES : 
 * Masudul. (2013, 12 décembre). Creating a random string with A-Z and 0-9 in Java [duplicate]. Stackoverflow. https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java/20536671#20536671
 */

package devoir5;

import java.util.Random;

public abstract class Document {
	private String noEnregistrement;
	protected String titre;
	protected int nbCopies;

	public Document(String titre, int nbCopies) {
		noEnregistrement = générerNoEnregistrement();
		this.titre = titre;
		this.nbCopies = nbCopies;
	}

	private String générerNoEnregistrement() {
		final String CARACTÈRES = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final int LONGUEUR = 9;
		Random rand = new Random();
		StringBuilder noEnregistrement = new StringBuilder();

		for (int i = 0; i < LONGUEUR; i++) {
			int index = rand.nextInt(CARACTÈRES.length());
			noEnregistrement.append(CARACTÈRES.charAt(index));
		}
		return noEnregistrement.toString();
	}

	public String getNoEnregistrement() {
		return noEnregistrement;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbCopies() {
		return nbCopies;
	}

	public void setNbCopies(int nbCopies) {
		this.nbCopies = nbCopies;
	}

	public abstract String toString();
}
