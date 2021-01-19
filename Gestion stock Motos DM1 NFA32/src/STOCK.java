
public class STOCK {

	private MOTO[] tabMoto = new MOTO[50];

	public STOCK(MOTO[] mytabMoto) {
		System.arraycopy(mytabMoto, 0, tabMoto, 0, 50);
	}

	public MOTO[] getTabMoto() {
		return tabMoto;
	}

	public void setTabMoto(MOTO[] tabMoto) {
		this.tabMoto = tabMoto;
	}

	public int NombreElement() {
		for (int i = 0; i < 50; i++) {
			if (getTabMoto()[i] == null) {
				return i;
			}
		}
		return 50;
	}

	public double moyennePrix() {
		double somme = 0;
		for (int i = 0; i < NombreElement(); i++) {
			somme = somme + tabMoto[i].getPrice();
		}
		return somme / NombreElement();
	}

	public void motoSupMoyenne() {
		for (int i = 0; i < NombreElement(); i++) {
			if (tabMoto[i].getPrice() > moyennePrix()) {
				System.out.println("modele : " + tabMoto[i].getName() + " prix :" + tabMoto[i].getPrice());
			}
		}
	}

	public int totalStock() {
		int somme = 0;

		for (int i = 0; i < NombreElement(); i++) {
			somme = somme + tabMoto[i].getStock();
		}
		return somme;
	}

	public void addMoto(MOTO moto) {
		tabMoto[NombreElement()] = moto;
	}

	public void toutLesElements() {
		for (int i = 0; i < NombreElement(); i++) {
			System.out.println("MODELE: " + tabMoto[i].getName() + " Prix: " + tabMoto[i].getPrice() + " GARANTIE: "
					+ tabMoto[i].getGarantie() + " STOCK: " + tabMoto[i].getStock());
		}
	}
}
