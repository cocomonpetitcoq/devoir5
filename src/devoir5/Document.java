package devoir5;

import java.util.Random;

public abstract class Document {
	private String noEnregistrement;
	protected String titre;
	protected int nbCopies;
	
	public Document( String titre, int nbCopies) {
	
		noEnregistrement = générerNoEnregistrement();;
		this.titre = titre;
		this.nbCopies = nbCopies;
	}
	
	public String générerNoEnregistrement() {
		String caractéres="ABCDEFGHIJKLMNOPQRSTVUWYZ1234567890";
		String resultat="";
		Random Rand=new Random();
		for(int i=0;i<9;i++) {
			int index=Rand.nextInt(caractéres.length());
			resultat+=caractéres.charAt(index);
		}
		return resultat;
	}
	
	public String getNoEnregistrement() {
		return noEnregistrement;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getNbCopies() {
		return nbCopies;
	}
	public void setNbCopies(int nbCopies) {
		this.nbCopies = nbCopies;
	}

	public  abstract String toString();
}
