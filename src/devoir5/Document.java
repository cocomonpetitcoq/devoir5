//https://stackoverflow.com/a/20536671

package devoir5;

import java.util.Random;

public abstract class Document {
	private String noEnregistrement;
	protected String titre;
	protected int nbCopies;

	public Document(String titre, int nbCopies) {
		noEnregistrement = générerNoEnregistrement();
		this.titre = titre;
		this.nbCopies = nbCopies;
	}

	private String générerNoEnregistrement() {
		final String CARACTÈRES = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final int LONGUEUR = 9;
		Random rand = new Random();
		StringBuilder noEnregistrement = new StringBuilder();

		for (int i = 0; i < LONGUEUR; i++) {
			int index = rand.nextInt(CARACTÈRES.length());
			noEnregistrement.append(CARACTÈRES.charAt(index));
		}
		return noEnregistrement.toString();
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

	public abstract String toString();
}
