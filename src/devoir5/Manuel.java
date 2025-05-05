/*NOMS DES MEMBRES ET CODES PERMANENTS :
 * 
 * Martel,Angela                           MARA22559304
 * Kamgaing Koudjou,Arnold Ulrich          KAMA72320600
 * Mbonwo Kenne,Lesline                    MBOL87300100
 * Enga Enga,Mike Landry                   ENGM66310200 
 * 
 * 
 * 
 * DESCRIPTION : L’objectif est de représenter un type de livre spécialisé, associé à un domaine particulier, pour permettre une gestion précise des manuels selon leur discipline.
*/

package devoir5;

public class Manuel extends Livre {
	private Domaine domaine;

	public Manuel(String titre, int nbCopies, String auteur, int nbPages, Domaine domaine) {
		super(titre, nbCopies, auteur, nbPages);
		this.domaine = domaine;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public String toString() {
		return "Ce document est de type manuel. Ce manuel, dont le titre est " + getTitre() + ", a été écrit par "
				+ getAuteur() + ", a " + getNbPages() + " pages et traite de la " + getDomaine() + ". Vous avez "
				+ getNbCopies() + " copies.";
	}
}
