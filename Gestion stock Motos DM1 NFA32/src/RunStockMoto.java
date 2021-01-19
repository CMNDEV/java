
public class RunStockMoto {

	public static void main(String[] args) {

		MOTO[] matable = new MOTO[50];
		STOCK monStock = new STOCK(matable);
		int Choix;
		char choix;

		// menu
		do {
			System.out.println();
			System.out.println("*********************************************************************");
			System.out.println("*                               MENU                                *");
			System.out.println("*********************************************************************");
			System.out.println("*   1: Ajouter un element au a mon stock                            *");
			System.out.println("*   2: Connaitre la valeur moyenne des motos                        *");
			System.out.println("*   3: Connaitre les modele au dessu du prix moyen                  *");
			System.out.println("*   4: Connaitre le Stock Total                                     *");
			System.out.println("*   5: Afficher tous les elements                                   *");
			System.out.println("*   6: Quitter                                                      *");
			System.out.println("*********************************************************************");
			System.out.println();
			Choix = Lire.i();

			if (Choix == 1) {
				do {
					AddElement(monStock);
					System.out.print("Ajouter un autre element O/N: ");
					choix = Lire.c();
				} while (choix == 'o' || choix == 'O');
			}
			if (Choix == 2) {
				afficherMoyenne(monStock);
			}
			if (Choix == 3) {
				AfficherMotoSuperieur(monStock);
			}
			if (Choix == 4) {
				afficherTotalStock(monStock);
			}
			if (Choix == 5) {
				afficherToutLesElements(monStock);
				;
			}
		} while (Choix != 6);
		System.out.println("AUREVOIR");

		afficherStock(monStock);
		System.out.println("Moyenne: " + monStock.moyennePrix());
		System.out.println("Modele au dessu de la moyenne");
		monStock.motoSupMoyenne();
		System.out.println("Stock: " + monStock.totalStock());

	}

	public static void afficherStock(STOCK stock) {
		for (int i = 0; i < stock.NombreElement(); i++) {

			System.out.println("MODELE : " + stock.getTabMoto()[i].getName() + " Stock: "
					+ stock.getTabMoto()[i].getStock() + " Prix: " + stock.getTabMoto()[i].getPrice() + " Guarantie "
					+ stock.getTabMoto()[i].getGarantie() + " mois");
		}

	}

	public static void AddElement(STOCK stock) {
		String modele;
		double prix;
		int quantite;
		int garantie;

		System.out.print("Modele: ");
		modele = Lire.S();
		System.out.print(" prix: ");
		prix = Lire.d();
		System.out.print(" quantite: ");
		quantite = Lire.i();
		System.out.print(" garantie: ");
		garantie = Lire.i();
		MOTO moto = new MOTO(modele, prix, quantite, garantie);
		stock.addMoto(moto);
		
	}

	public static void afficherMoyenne(STOCK stock) {
		System.out.println("Prix moyen: " + stock.moyennePrix());
	}

	public static void afficherTotalStock(STOCK stock) {
		System.out.println("Stock Total: " + stock.totalStock());
	}

	public static void AfficherMotoSuperieur(STOCK stock) {
		System.out.println("Liste des motos au dessus de la moyenne de prix");
		stock.motoSupMoyenne();
	}

	public static void afficherToutLesElements(STOCK stock) {
		System.out.println("Liste completes des modeles");
		stock.toutLesElements();
	}
}