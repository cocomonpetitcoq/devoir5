package devoir5;

public class Manuel extends Livre{
	private Domaine domaine;
	public Manuel(String titre, int nbCopies, String auteur, int nbPages, Domaine domaine) {
		super(titre, nbCopies,auteur,nbPages);
		this.domaine=domaine;	
	}
	public Domaine getDomaine() {
		return domaine;
	}
	public String toString() {
		return  "Ce document est de type Manuel. Ce manuel dont le titre est " + getTitre()  + " a été écrit par  " + getAuteur() + " á " + getNbPages() + " pages et traite de la " + getDomaine() +" et vous avez " + getNbCopies() + " copies";
	}

}
