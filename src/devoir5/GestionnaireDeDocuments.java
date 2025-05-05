/*NOMS DES MEMBRES ET CODES PERMANENTS :
 * 
 * Martel,Angela                           MARA22559304
 * Kamgaing Koudjou,Arnold Ulrich          KAMA72320600
 * Mbonwo Kenne,Lesline                    MBOL87300100
 * Enga Enga,Mike Landry                   ENGM66310200
 * Kobangoye,Philippe Henri                KOBP68350400
 * 
 * 
 * 
 * 
 * DESCRIPTION : L’objectif est de centraliser la gestion de l’ensemble des documents, en permettant l’ajout, la suppression, la recherche et la consultation des documents tout en garantissant l’unicité des numéros d’enregistrement.
 *  */


/*https://en.wikipedia.org/wiki/Magazine#History
https://www.baeldung.com/find-list-element-java#5-java-8-stream-api*/

package devoir5;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionnaireDeDocuments {
    private static ArrayList<Document> documents = new ArrayList<Document>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        boolean arrêt = false;

        while (!arrêt) {
            afficherMenu();
            option = traiterOption(0, 9);

            switch (option) {
                case 0: {
                    arrêt = true;
                    break;
                }
                case 1: {
                    créerDocument();
                    break;
                }
                case 2: {
                    if (validerQuantitéDocuments()) {
                        supprimerDocument();
                    }
                    break;
                }
                case 3: {
                    if (validerQuantitéDocuments()) {
                        System.out.println("\n==========AFFICHER LES DOCUMENTS==========\n");
                        afficherDocuments();
                    }
                    break;
                }
                case 4: {
                    if (validerQuantitéDocuments()) {
                        afficherCaractéristiques();
                    }
                    break;
                }
                case 5: {
                    if (validerQuantitéDocuments()) {
                        afficherPrixLittéraires();
                    }
                    break;
                }
                case 6: {
                    if (validerQuantitéDocuments()) {
                        modifierNbCopies();
                    }
                    break;
                }
                case 7: {
                    if (validerQuantitéDocuments()) {
                        modifierTitreDocument();
                    }
                    break;
                }
                case 8: {
                    if (validerQuantitéDocuments()) {
                        modifierAuteurLivre();
                    }
                    break;
                }
                case 9: {
                    ajoutDocumentsPrédéfinis();
                    break;
                }
            }
            System.out.print("\n");
        }
        System.out.println("Au revoir !");
        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("==========MENU==========\n");
        System.out.println("Option 1 : Ajouter un document");
        System.out.println("Option 2 : Supprimer un document");
        System.out.println("Option 3 : Afficher tous les documents");
        System.out.println("Option 4 : Afficher les caractéristiques d'un document");
        System.out.println("Option 5 : Afficher la liste des prix littéraires d'un roman");
        System.out.println("Option 6 : Augmenter ou diminuer le nombre de copies d'un document");
        System.out.println("Option 7 : Modifier le titre d'un document");
        System.out.println("Option 8 : Modifier l'auteur d'un livre");
        System.out.println("Option 9 : Créer et ajouter 12 documents prédéfinis");
        System.out.println("Appuyez sur 0 pour quitter.\n");
        System.out.println("Veuillez choisir une option.");
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

    private static boolean validerQuantitéDocuments() {
        if (documents.isEmpty()) {
            System.out.println("\nLa liste de documents est vide.");
            return false;
        } else {
            return true;
        }
    }

    private static void afficherTypesDocuments() {
        System.out.println("\n==========AJOUTER UN DOCUMENT==========\n");
        System.out.println("1. Roman");
        System.out.println("2. Manuel");
        System.out.println("3. Revue");
        System.out.println("4. Dictionnaire");
        System.out.println("\nVeuillez choisir le type de document à créer.");
    }

    private static void énumérerMois() {
        Mois[] mois = Mois.values();

        System.out.println("\nListe des mois");
        for (int i = 0; i < mois.length; i++) {
            System.out.println((i + 1) + ". " + mois[i]);
        }
        System.out.println("\nVeuillez choisir un mois de publication pour la revue.");
    }

    private static void énumérerDomaines() {
        Domaine[] domaines = Domaine.values();

        System.out.println("\nListe des domaines");
        for (int i = 0; i < domaines.length; i++) {
            System.out.println((i + 1) + ". " + domaines[i]);
        }
        System.out.println("\nVeuillez choisir un domaine pour le manuel.");
    }

    private static void énumérerLangues() {
        Langue[] langues = Langue.values();

        System.out.println("\nListe des langues");
        for (int i = 0; i < langues.length; i++) {
            System.out.println((i + 1) + ". " + langues[i]);
        }
        System.out.println("\nVeuillez choisir une langue pour le dictionnaire.");
    }

    private static void créerDocument() {
        afficherTypesDocuments();
        int option = traiterOption(1, 4);
        switch (option) {
            case 1: {
                créerRoman();
                break;
            }
            case 2: {
                créerManuel();
                break;
            }
            case 3: {
                créerRevue();
                break;
            }
            case 4: {
                créerDictionnaire();
                break;
            }
        }
    }

    private static int validerNombre() {
        int nombre = 0;
        boolean valide = false;

        while (!valide) {
            try {
                nombre = Integer.parseInt(scanner.nextLine().trim());
                if (nombre > 0) {
                    valide = true;
                } else {
                    System.out.println("\nVeuillez fournir un nombre entier positif. Réessayez.");
                }
            } catch (Exception e) {
                System.out.println("\nCeci est une entrée invalide. Recommencez.");
            }
        }
        return nombre;
    }

    private static void créerRoman() {
        System.out.println("\n==========CRÉATION D'UN ROMAN==========");
        System.out.println("\nVeuillez fournir le titre du roman.");
        String titre = scanner.nextLine().trim();

        System.out.println("\nVeuillez fournir le nom de l'auteur du roman.");
        String auteur = scanner.nextLine().trim();

        System.out.println("\nVeuillez fournir le nombre de pages du roman.");
        int nbPages = validerNombre();

        System.out.println("\nVeuillez fournir le nombre de copies du roman que vous avez.");
        int nbCopies = validerNombre();

        ArrayList<String> listePrixLittéraires = new ArrayList<String>();

        System.out.println("\nCe roman a-t-il gagné un ou des prix littéraires ?\n1. Oui\n2. Non");
        int option = traiterOption(1, 2);

        while (option == 1) {
            System.out.println("\nVeuillez fournir le prix littéraire que ce roman a gagné.");
            listePrixLittéraires.add(scanner.nextLine().trim());

            System.out.println(
                    "\nY a-t-il un ou plusieurs autres prix littéraires à ajouter à la liste ?\n1. Oui\n2. Non");
            option = traiterOption(1, 2);
        }

        documents.add(new Roman(titre, nbCopies, auteur, nbPages, listePrixLittéraires));
        System.out.println("\nLe roman a été créé et ajouté avec succès!");
    }

    private static void créerManuel() {
        System.out.println("\n==========CRÉATION D'UN MANUEL==========");
        System.out.println("\nVeuillez fournir le titre du manuel.");
        String titre = scanner.nextLine().trim();

        System.out.println("\nVeuillez fournir le nom de l'auteur du manuel.");
        String auteur = scanner.nextLine().trim();

        System.out.println("\nVeuillez fournir le nombre de pages du manuel.");
        int nbPages = validerNombre();

        System.out.println("\nVeuillez fournir le nombre de copies du manuel que vous avez.");
        int nbCopies = validerNombre();

        énumérerDomaines();
        int option = traiterOption(1, Domaine.values().length);
        Domaine domaine = Domaine.values()[option - 1];

        documents.add(new Manuel(titre, nbCopies, auteur, nbPages, domaine));
        System.out.println("\nLe manuel a été créé et ajouté avec succès!");
    }

    private static void créerRevue() {
        System.out.println("\n==========CRÉATION D'UNE REVUE==========");
        System.out.println("\nVeuillez fournir le titre de la revue.");
        String titre = scanner.nextLine().trim();

        System.out.println("\nVeuillez fournir le nombre de copies de la revue que vous avez.");
        int nbCopies = validerNombre();

        énumérerMois();
        int option = traiterOption(1, Mois.values().length);
        Mois moisPublication = Mois.values()[option - 1];

        int annéePublication = validerAnnéePublication();

        documents.add(new Revue(titre, nbCopies, moisPublication, annéePublication));
        System.out.println("\nLa revue a été créée et ajoutée avec succès!");
    }

    private static int validerAnnéePublication() {
        int annéePublication = 0;
        boolean valide = false;

        System.out.println("\nVeuillez fournir l'année de publication de la revue.");

        while (!valide) {
            try {
                annéePublication = Integer.parseInt(scanner.nextLine().trim());
                if (annéePublication >= 1663) {
                    valide = true;
                } else {
                    System.out.println("\nAucune revue n'était publiée à cette époque. Réessayez.");
                }
            } catch (Exception e) {
                System.out.println("\nCeci est une entrée invalide. Recommencez.");
            }
        }
        return annéePublication;
    }

    private static void créerDictionnaire() {
        System.out.println("\n==========CRÉATION D'UN DICTIONNAIRE==========");
        System.out.println("\nVeuillez fournir le titre du dictionnaire.");
        String titre = scanner.nextLine().trim();

        System.out.println("\nVeuillez fournir le nombre de copies du dictionnaire que vous avez.");
        int nbCopies = validerNombre();

        énumérerLangues();
        int option = traiterOption(1, Langue.values().length);
        Langue langue = Langue.values()[option - 1];

        documents.add(new Dictionnaire(titre, nbCopies, langue));
        System.out.println("\nLe dictionnaire a été créé et ajouté avec succès!");
    }

    private static void supprimerDocument() {
        System.out.println("\n==========SUPPRIMER UN DOCUMENT==========\n");
        afficherDocuments();
        Document document = trouverDocumentParTitreEtNoEnregistrement();

        System.out.println("\nVoulez-vous supprimer ce document ?\n1. Oui\n2. Non");
        int option = traiterOption(1, 2);

        if (option == 1) {
            documents.remove(document);
            System.out.println("\nLe document a été supprimé avec succès !");
        } else {
            System.out.println("\nLe document n'a pas été supprimé.");
        }
    }

    private static void afficherDocuments() {
        System.out.println("Liste des documents");
        for (int i = 0; i < documents.size(); i++) {
            System.out.println(documents.get(i).getNoEnregistrement() + " - " + documents.get(i).getTitre());
        }
    }

    private static Document trouverDocumentParTitreEtNoEnregistrement() {
        Document document = null;
        boolean succès = false;

        while (!succès) {
            try {
                System.out.println("\nVeuillez fournir le titre d'un document.");
                String titre = scanner.nextLine().trim();

                System.out.println("\nVeuillez fournir le numéro d'enregistrement d'un document.");
                String noEnregistrement = scanner.nextLine().trim();

                document = documents.stream().filter(roman -> roman.getTitre().equalsIgnoreCase(titre)
                        && roman.getNoEnregistrement().equals(noEnregistrement)).findFirst().get();

                if (document != null) {
                    succès = true;
                } else {
                    System.out.println("\nAucun document ne correspond à ces informations. Réessayez.");
                }
            } catch (Exception e) {
                System.out.println("\nUne erreur s'est produite. Veuillez recommencer.");
            }
        }
        return document;
    }

    private static void afficherCaractéristiques() {
        System.out.println("\n==========AFFICHER LES CARACTÉRISTIQUES D'UN DOCUMENT==========");
        Document document = trouverDocumentParNoEnregistrement();
        System.out.println("\n" + document.toString());
    }

    private static Document trouverDocumentParNoEnregistrement() {
        Document document = null;
        boolean succès = false;

        while (!succès) {
            try {
                System.out.println("\nVeuillez fournir le numéro d'enregistrement d'un document.");
                String noEnregistrement = scanner.nextLine().trim();

                document = documents.stream().filter(roman -> roman.getNoEnregistrement().equals(noEnregistrement))
                        .findFirst().get();

                if (document != null) {
                    succès = true;
                } else {
                    System.out.println("\nAucun document ne correspond à ce numéro d'enregistrement. Réessayez.");
                }
            } catch (Exception e) {
                System.out.println("\nUne erreur s'est produite. Veuillez recommencer.");
            }
        }
        return document;
    }

    private static void afficherPrixLittéraires() {
        System.out.println("\n==========AFFICHER LES PRIX LITTÉRAIRES D'UN ROMAN==========");
        ArrayList<Roman> romans = trouverDocumentsRoman();

        if (romans.size() > 0) {
            afficherRomans(romans);
            Roman roman = trouverRomanParTitreEtAuteur(romans);
            roman.afficherListePrixLittéraires();
        } else {
            System.out.println("\nIl n'y a aucun roman dans la liste de documents.");
        }
    }

    private static ArrayList<Roman> trouverDocumentsRoman() {
        ArrayList<Roman> romans = new ArrayList<Roman>();

        for (Document document : documents) {
            if (document instanceof Roman) {
                romans.add((Roman) document);
            }
        }
        return romans;
    }

    private static void afficherRomans(ArrayList<Roman> romans) {
        System.out.println("\nListe des romans");
        for (int i = 0; i < romans.size(); i++) {
            System.out.println(romans.get(i).getTitre() + " - " + romans.get(i).getAuteur());
        }
    }

    private static Roman trouverRomanParTitreEtAuteur(ArrayList<Roman> romans) {
        Roman roman = null;
        boolean succès = false;

        while (!succès) {
            try {
                System.out.println("\nVeuillez fournir le titre d'un roman.");
                String titre = scanner.nextLine().trim();

                System.out.println("\nVeuillez fournir l'auteur d'un roman.");
                String auteur = scanner.nextLine().trim();

                roman = romans.stream().filter(romanRecherché -> romanRecherché.getTitre().equalsIgnoreCase(titre)
                        && romanRecherché.getAuteur().equalsIgnoreCase(auteur)).findFirst().get();

                if (roman != null) {
                    succès = true;
                } else {
                    System.out.println("\nAucun roman ne correspond à ces informations. Réessayez.");
                }
            } catch (Exception e) {
                System.out.println("\nUne erreur s'est produite. Veuillez recommencer.");
            }
        }
        return roman;
    }

    private static void modifierNbCopies() {
        System.out.println("\n==========MODIFIER LE NOMBRE DE COPIES D'UN DOCUMENT==========");
        Document doc = trouverDocumentParNoEnregistrement();
        System.out.println("\nNombre de copies actuel : " + doc.getNbCopies());

        System.out.println("\nVoulez-vous augmenter ou diminuer le nombre de copies?\n1. Augmenter\n2. Diminuer");
        int option = traiterOption(1, 2);

        switch (option) {
            case 1: {
                System.out.println("\nVeuillez fournir le nombre de copies à ajouter.");
                int nbCopiesAugmenter = validerNombre();
                doc.setNbCopies(doc.getNbCopies() + nbCopiesAugmenter);
                break;
            }
            case 2: {
                System.out.println("\nVeuillez fournir le nombre de copies à enlever.");
                int nbCopiesDiminuer = validerNbCopiesDiminuer(doc);
                doc.setNbCopies(doc.getNbCopies() - nbCopiesDiminuer);
                break;
            }
        }
        System.out.println("\nLe nombre de copies a été modifié avec succès!");
    }

    private static int validerNbCopiesDiminuer(Document doc) {
        int nb = 0;
        boolean valide = false;

        while (!valide) {
            try {
                nb = Integer.parseInt(scanner.nextLine().trim());
                if (nb > 0 && nb <= doc.getNbCopies()) {
                    valide = true;
                } else {
                    System.out.println(
                            "\nVeuillez fournir un nombre entier positif et inférieur au nombre de copies du document. Réessayez.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un entier valide.");
            }
        }
        return nb;
    }

    private static void modifierTitreDocument() {
        System.out.println("\n==========MODIFIER LE TITRE D'UN DOCUMENT==========\n");
        afficherDocuments();
        Document doc = trouverDocumentParTitreEtNoEnregistrement();

        System.out.println("\nEntrez le nouveau titre");
        String nouveauTitre = scanner.nextLine().trim();

        System.out.println("\nNouveau titre proposé : " + nouveauTitre);
        System.out.println("Confirmez-vous la modification ?\n1. Oui\n2. Non");
        int option = traiterOption(1, 2);

        if (option == 1) {
            doc.setTitre(nouveauTitre);
            System.out.println("\nLe titre du document a été modifié avec succès!");
        } else {
            System.out.println("\nModification annulée.");
        }
    }

    private static void modifierAuteurLivre() {
        System.out.println("\n==========MODIFIER L'AUTEUR D'UN LIVRE==========");
        ArrayList<Livre> livres = trouverDocumentsLivre();
        if (livres.size() > 0) {
            afficherLivres(livres);
            Livre livre = trouverLivreParTitreEtAuteur(livres);

            System.out.println("\nEntrez le nouvel auteur : ");
            String nouvelAuteur = scanner.nextLine().trim();

            System.out.println("\nNouvel auteur proposé : " + nouvelAuteur);
            System.out.println("Confirmez-vous la modification ?\n1. Oui\n2. Non");
            int option = traiterOption(1, 2);

            if (option == 1) {
                livre.setAuteur(nouvelAuteur);
                System.out.println("\nL'auteur du livre a été modifié avec succès!");
            } else {
                System.out.println("Modification annulée.");
            }
        } else {
            System.out.println("\nIl n'y a aucun livre dans la liste de documents.");
        }
    }

    private static ArrayList<Livre> trouverDocumentsLivre() {
        ArrayList<Livre> livres = new ArrayList<Livre>();

        for (Document doc : documents) {
            if (doc instanceof Livre) {
                livres.add((Livre) doc);
            }
        }
        return livres;
    }

    private static void afficherLivres(ArrayList<Livre> livres) {
        System.out.println("\nListe des livres");
        for (Livre livre : livres) {
            System.out.println(livre.getTitre() + " - " + livre.getAuteur());
        }
    }

    private static Livre trouverLivreParTitreEtAuteur(ArrayList<Livre> livres) {
        Livre livreRecherché = null;
        boolean succès = false;

        while (!succès) {
            try {
                System.out.println("\nVeuillez fournir le titre d'un livre.");
                String titre = scanner.nextLine().trim();

                System.out.println("\nVeuillez fournir l'auteur d'un livre.");
                String auteur = scanner.nextLine().trim();

                livreRecherché = livres.stream().filter(
                                livre -> livre.getTitre().equalsIgnoreCase(titre) && livre.getAuteur().equalsIgnoreCase(auteur))
                        .findFirst().get();

                if (livreRecherché != null) {
                    succès = true;
                } else {
                    System.out.println("\nAucun livre ne correspond à ces informations. Réessayez.");
                }
            } catch (Exception e) {
                System.out.println("\nUne erreur s'est produite. Veuillez recommencer.");
            }
        }
        return livreRecherché;
    }

    private static void ajoutDocumentsPrédéfinis() {
        ArrayList<String> prixRoman1 = new ArrayList<String>();
        ArrayList<String> prixRoman2 = new ArrayList<String>();
        ArrayList<String> prixRoman3 = new ArrayList<String>();
        prixRoman1.add("Prix Goncourt");
        prixRoman3.add("Prix Renaudot");
        documents.add(new Roman("Les Misérables", 6, "Victor Hugo", 1734, prixRoman1));
        documents.add(new Roman("Le Seigneur des Anneaux", 10, "J.R.R. Tolkien", 1536, prixRoman2));
        documents.add(new Roman("1984", 3, "George Orwell", 2051, prixRoman3));
        documents.add(new Manuel("Les softskills pour les nuls", 2, "Nelly Magré", 277, Domaine.Médecine));
        documents.add(new Manuel("Éducation alimentaire : 21 ateliers d'éveil au goût et aux 5 sens", 1,
                "Carole Ligniez", 176, Domaine.Nutrition));
        documents.add(new Manuel("SOS mal de dos : les bons gestes et les bonnes postures", 4, "Frédéric Srour", 127,
                Domaine.Ergonomie));
        documents.add(new Revue("Protégez-vous", 2, Mois.Janvier, 2024));
        documents.add(new Revue("Protégez-vous", 1, Mois.Février, 2024));
        documents.add(new Revue("Protégez-vous", 2, Mois.Mars, 2024));
        documents.add(new Dictionnaire("Larousse de l'anglais", 1, Langue.Anglais));
        documents.add(new Dictionnaire("Dictionnaire de français", 3, Langue.Français));
        documents.add(new Dictionnaire("Dictionnaire de l'allemand", 1, Langue.Allemand));
        System.out.println("\nDocuments prédéfinis ajoutés avec succès!");
    }
}
