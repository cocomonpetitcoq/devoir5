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
