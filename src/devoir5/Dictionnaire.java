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
