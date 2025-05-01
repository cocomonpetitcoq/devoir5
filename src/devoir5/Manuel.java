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
		return "Ce manuel dont le titre est  " + titre  + "a été écrit par  " + auteur + " á " + nbPages + " pages et traite de la" + domaine +
				" vous avez " + nbCopies + "copiés";
	}

}
