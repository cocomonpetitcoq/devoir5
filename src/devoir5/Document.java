package devoir5;

public abstract class Document {
	protected String NoEnregistrement;
	protected String Titre;
	protected int nbCopies;
	
	public Document(String noEnregistrement, String titre, int nbCopies) {
	
		NoEnregistrement = générerNoEnregistrement();;
		this.Titre = titre;
		this.nbCopies = nbCopies;
	}
	
	public String getNoEnregistrement() {
		return NoEnregistrement;
	}
	public void setNoEnregistrement(String noEnregistrement) {
		NoEnregistrement = noEnregistrement;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public int getNbCopies() {
		return nbCopies;
	}
	public void setNbCopies(int nbCopies) {
		this.nbCopies = nbCopies;
	}

	public String toString() {
		return "Le No d'Enregistrement du Document est: " + NoEnregistrement + "Le titre du Document est:" + Titre + ",Le nombre de copies du Document est: " + nbCopies + "";
	}
	
	
}
