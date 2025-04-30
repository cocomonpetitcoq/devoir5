package devoir5;

public abstract class Document {
	protected String NoEnregistrement;
	protected String Titre;
	protected int nbCopies;
	
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
	@Override
	public String toString() {
		return "Document: [Le No d'Enregistrement est: " + NoEnregistrement + "Le titre est:" + Titre + ",Le nombre de copies est: " + nbCopies + "]";
	}
	
	
}
