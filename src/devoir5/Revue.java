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
