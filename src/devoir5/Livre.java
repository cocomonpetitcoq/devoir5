/*NOMS DES MEMBRES ET CODES PERMANENTS :
 * 
 * Martel,Angela                           MARA22559304
 * Kamgaing Koudjou,Arnold Ulrich          KAMA72320600
 * Mbonwo Kenne,Lesline                    MBOL87300100
 * Enga Enga,Mike Landry                   ENGM66310200
 * Kobangoye,Philippe Henri                KOBP68350400
 * 
 * 
 * 
 * 
 * DESCRIPTION : L’objectif est de définir une classe intermédiaire pour les documents de type livre, en ajoutant les attributs auteur et nombre de pages, afin de regrouper les caractéristiques communes aux romans et aux manuels.
 *  */

package devoir5;

public abstract class Livre extends Document {
	protected String auteur;
	protected int nbPages;

	public Livre(String titre, int nbCopies, String auteur, int nbPages) {
		super(titre, nbCopies);
		this.auteur = auteur;
		this.nbPages = nbPages;
	}
	
	public String getAuteur() {
		return auteur;
	}
	
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public int getNbPages() {
		return nbPages;
	}
}