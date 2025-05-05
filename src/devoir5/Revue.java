/*NOMS DES MEMBRES ET CODES PERMANENTS :
 * 
 * Martel,Angela                           MARA22559304
 * Kamgaing Koudjou,Arnold Ulrich          KAMA72320600
 * Mbonwo Kenne,Lesline                    MBOL87300100
 * Enga Enga,Mike Landry                   ENGM66310200 
 * 
 * 
 * 
 * DESCRIPTION : L’objectif est de modéliser un type de document caractérisé par une date de publication (mois et année), en plus des attributs de base, pour gérer les revues de la bibliothèque.
*/

package devoir5;

public class Revue extends Document {
	private Mois moisPublication;
	private int annéePublication;

	public Revue(String titre, int nbCopies, Mois moisPublication, int annéePublication) {
		super(titre, nbCopies);
		this.moisPublication = moisPublication;
		this.annéePublication = annéePublication;
	}

	public Mois getMoisPublication() {
		return moisPublication;
	}

	public int getAnnéePublication() {
		return annéePublication;
	}

	public String toString() {
		return "Ce document est de type revue. Cette revue, dont le titre est " + getTitre() + ", a été publiée en "
				+ getMoisPublication() + " " + getAnnéePublication() + ". Vous avez " + getNbCopies() + " copies.";
	}
}
