package devoir5;

public class Revue extends Document {
	private Mois moisPublication;
	private int annéePublication;

	public Revue(String titre, int nbCopies, Mois moisPublication,int annéePublication) {	
		super(titre, nbCopies);
		this.moisPublication = moisPublication;
		this.annéePublication = annéePublication;
	
	}
	public Mois getmoisPublication() {
		return moisPublication;
	}
	public int getannéePublication() {
		return annéePublication;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ce document est de type revue. " + "Cette revue dont le titre est " + titre +" a été publié le " + moisPublication + annéePublication + " et vous avez " + nbCopies ;
	}
	

}
