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