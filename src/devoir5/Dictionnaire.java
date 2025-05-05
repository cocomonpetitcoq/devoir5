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
 *
 *DESCRIPTION : L’objectif est de représenter un type de document spécifique qui possède une langue associée, en plus d’un numéro d’enregistrement, d’un titre et d’un nombre de copies, afin de gérer les dictionnaires disponibles dans la bibliothèque.   
 */

package devoir5;

public class Dictionnaire extends Document {
	private Langue langue;

	public Dictionnaire(String titre, int nbCopies, Langue langue) {
		super(titre, nbCopies);
		this.langue = langue;
	}

	public Langue getLangue() {
		return langue;
	}

	public String toString() {
		return "Ce document est de type dictionnaire. Ce dictionnaire, dont le titre est " + getTitre()
				+ ", a été écrit en " + getLangue().toString().toLowerCase() + ". Vous avez " + getNbCopies()
				+ " copies.";
	}
}
