
public class RunL {

	public static void main(String[] args) {
		Integer myInfo = 0;

		L tete = new L(myInfo, null);
		char choix;

		do {
			afficherMenu();
			choix = Lire.c();
			if (choix == 'A' || choix == 'a') {
				afficherListe(tete);
			}
			if (choix == 'B' || choix == 'b') {
				afficherIsListeContientMarche(tete);
			}
			if (choix == 'C' || choix == 'c') {
				entourerMarcheDeZero(tete);
			}
			if (choix == 'D' || choix == 'd') {
				effacerFirstMarch(tete);
			}
		} while (choix != 'Q');

	}

	public static void afficherMenu() {
		System.out.println();
		System.out.println();
		System.out.println("     ----------- ");
		System.out.println("    *    MENU   * ");
		System.out.println("     ----------- ");
		System.out.println();

		System.out.println("A: AFFICHER LA LISTE");
		System.out.println("B: SAVOIR SI LA LISTE CONTIENT AUX MOINS UNE MARCHE ");
		System.out.println("C: ENTOURER LA PREMIERE MARCHE DE ZERO ");
		System.out.println("D: EFFACER LA PREMIERE MARCHE");
		System.out.println();
	}

	public static void addInfo(L tete) {

		Integer info = 0;
		Integer compteur = 0;
		L myLastInfo, myNewInfo;
		L aux;
		myLastInfo = tete;
		myNewInfo = tete;

		char choix2;
		System.out.println("Vous allez remplire la liste ");
		do {
			aux = tete;

			compteur++;
			System.out.print("Element n° " + compteur + " : ");
			info = Lire.i();
			if (info <= 0) {
				myNewInfo = new L(info, null);
				System.out.println(" !! Entrez un entier strictement positif !!");
				compteur = compteur - 1;
			} else {
				myNewInfo = new L(info, null);
				myLastInfo.setSuivant(myNewInfo);
				myLastInfo = myNewInfo;
			}

			System.out.print("Taper C pour continuer.....");
			choix2 = Lire.c();

		} while (choix2 == 'C' || choix2 == 'c');
	}

	public static void afficherListe(L tete) {
		L aux;
		aux = tete;
		char choix;
		if (aux.getSuivant() != null) {
			while (aux.getSuivant() != null) {

				aux = aux.getSuivant();

				System.out.print(aux.getInfo() + " , ");

			}
		} else if (aux.getSuivant() == null) {

			System.out.println("La liste est vide");
			System.out.println("Voulez vous la remplir O/N");
			choix = Lire.c();
			if (choix == 'o' || choix == 'O') {
				addInfo(tete);
			}
		}

	}

	public static boolean isListeContientMarche(L tete) {

		L myLastInfo, aux;
		Integer compteur = 0;

		aux = tete;
		myLastInfo = tete;

		while (aux.getSuivant() != null) {

			aux = aux.getSuivant();
			compteur++;
			if (compteur > 1) {
				if ((aux.getInfo() == (myLastInfo.getInfo() + 1))) {

					return true;
				}

			}
			myLastInfo = aux;
		}

		return false;
	}

	public static void afficherIsListeContientMarche(L tete) {

		if (isListeContientMarche(tete)) {
			System.out.println(" la liste contient au moins une marche ");
		} else {
			System.out.println(" la liste ne contient pas de marche ");
		}
	}

	public static void entourerMarcheDeZero(L tete) {

		Integer compteur = 0;
		L myLastInfo, my2LastInfo, aux;
		myLastInfo = tete;
		my2LastInfo = tete;
		aux = tete;
		L myZeroRight = new L(0, null);
		L myZeroLeft = new L(0, null);

		while (aux.getSuivant() != null) {
			aux = aux.getSuivant();
			compteur++;
			if (compteur > 1) {
				if ((aux.getInfo() == (myLastInfo.getInfo() + 1))) {
					myZeroRight.setSuivant(aux.getSuivant());
					aux.setSuivant(myZeroRight);
					myZeroLeft.setSuivant(my2LastInfo.getSuivant());
					my2LastInfo.setSuivant(myZeroLeft);
				}
			}
			my2LastInfo = myLastInfo;
			myLastInfo = aux;

		}
		System.out.println("Voici le resultat: ");
		afficherListe(tete);
	}

	public static void effacerFirstMarch(L tete) {

		Integer compteur = 0;
		L myLastInfo, my2LastInfo, aux;
		myLastInfo = tete;
		my2LastInfo = tete;
		aux = tete;

		if (isListeContientMarche(tete)) {
			while (aux.getSuivant() != null) {
				aux = aux.getSuivant();
				compteur++;

				if (compteur > 2) {
					if ((aux.getInfo() == (myLastInfo.getInfo() + 1)) 
							&& (myLastInfo.getInfo()!=0)
							&& (my2LastInfo.getInfo()==0)
							&& (aux.getSuivant().getInfo()==0)) {
						my2LastInfo.setSuivant(aux.getSuivant());
						
					}
				}
				my2LastInfo=myLastInfo;
				myLastInfo=aux;
			}
			System.out.println("Voici le resultat: ");
			afficherListe(tete);
		}else {
			System.out.println("la liste ne contient pas de marche");
		}
	}
}