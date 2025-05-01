package devoir5;

public class GestionnaireDeDocuments {

	public static void main(String[] args) {
	}
	
	private static int traiterOption(int min, int max) {
		int option = -1;
		boolean valide = false;

		while (!valide) {
			try {
				option = Integer.parseInt(scanner.nextLine().trim());
				if (option >= min && option <= max) {
					valide = true;
				} else {
					System.out.println("\nVotre choix ne fait pas partie des options valides. Réessayez.");
				}
			} catch (Exception e) {
				System.out.println("\nCeci est une entrée invalide. Recommencez.");
			}
		}
		return option;
	}
}
