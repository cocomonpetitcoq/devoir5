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
		return "le titre du Domaine est " + titre + "Son Domaine est " + domaine +"L'auteur est " + auteur + " Le nombre de Pages est" + nbPages +
				" le nombre de copies est " + nbCopies;
	}

}
