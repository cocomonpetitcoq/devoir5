package devoir5;

public abstract class Document {
	private String noEnregistrement;
	protected String titre;
	protected int nbCopies;
	
	public Document( String titre, int nbCopies) {
	
		noEnregistrement = générerNoEnregistrement();;
		this.titre = titre;
		this.nbCopies = nbCopies;
	}
	
	public String getNoEnregistrement() {
		return noEnregistrement;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		titre = titre;
	}
	public int getNbCopies() {
		return nbCopies;
	}
	public void setNbCopies(int nbCopies) {
		this.nbCopies = nbCopies;
	}

	public  abstract String toString();
}
