
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RunListeASSURES {

	public static void main(String[] args) {

		HashMap<String, ASSURE> liste = new HashMap<String, ASSURE>();
		ListeASSURES listeASSURES = new ListeASSURES(liste);
		HashSet<String> remboursement = new HashSet<String>();
		char choix;

		do {
			AfficherMenu();
			choix = Lire.c();
			if (choix == 'A') {
				AddElement(listeASSURES);

			}
			if (choix == 'B') {

				AfficherListe(listeASSURES);

			}
			if(choix=='C')
			
				
				AddRemboursement(listeASSURES);
				
			
			if (choix == 'D') {

				SearchClientAudessusMontant(listeASSURES);
			}
			if (choix == 'E') {
				SearchWithIDandNAME(listeASSURES);
			}

		} while (choix != 'F');
		System.out.println("AUREVOIR!!");
	}

	public static void AfficherMenu() {

		System.out.println("*******************************************************");
		System.out.println("                    * MENU *                          ");
		System.out.println("     A: RENTRER LA LISTE DES ASSURES                  ");
		System.out.println("    B: AFFICHER LA LISTE DES ASSURES                  ");
		System.out.println("   C: AJOUTER UN REMBOUSEMENT A UN CLIENT             ");
		System.out.println("   D: CHERCHER CLIENT AUX DESSUS D'UN MONTANT X       ");
		System.out.println("    E: CHERCHER LES REMBOURSEMENTs WITH ID ET NAME    ");
		System.out.println("     F: QUITTER                                       ");
		System.out.println("*******************************************************");

	}

	public static void AddElement(ListeASSURES listeASSURES) {
		System.out.println("");
		String name;
		int numId = 0;
		String dateR;

		double montantR;
		String ligneR;
	HashSet<String>remboursement=new HashSet<>();

		ASSURE assure;
	

		System.out.print("Nom du client: ");
		name = Lire.S();
		int nombre;
		do {
			System.out.print("ID client: ");
			numId = Lire.i();
			nombre = String.valueOf(numId).length();

		} while (nombre != 6);

		System.out.print("montant :");
		montantR = Lire.d();
		System.out.print("Date: ");
		dateR = Lire.S();
		ligneR = "Date: " + dateR.concat(" montant: " + montantR);
		remboursement.add(ligneR);
		assure = new ASSURE(name, numId, remboursement);
		listeASSURES.getListe().put(name, assure);

		System.out.println("");
	}

	public static void AfficherListe(ListeASSURES listeASSURES) {
		System.out.println("");
		Iterator<String> iter;
		Set<String> tabcles;
		String cle;
		ASSURE aux;
		tabcles = listeASSURES.getListe().keySet();
		iter = tabcles.iterator();
		System.out.println("*********       LISTE DE TOUT LES ASSURE         ******");
		System.out.println("");
		while (iter.hasNext()) {

			cle = iter.next();
			aux = listeASSURES.getListe().get(cle);

			System.out.println(aux.getName());
			
			System.out.println(aux.getRembourement());

		}

		System.out.println("");
		System.out.println("*******************************************************");
		System.out.println("");
	}

	public static void AddRemboursement(ListeASSURES listeASSURES) {

		String dateR;

		double montantR;
		String ligneR;

		
		

		Iterator<String> iter;
		Set<String> tabcles;
		String cle;
		ASSURE aux;
       
		String nomClient;
		System.out.println("Nom du client: ");
		nomClient = Lire.S();
		int ID = 0;

		tabcles = listeASSURES.getListe().keySet();
		iter = tabcles.iterator();
		System.out.println();

		while (iter.hasNext()) {
			cle = iter.next();
			aux = listeASSURES.getListe().get(cle);

			if (aux.getName().equalsIgnoreCase(nomClient)) {
               
				
               System.out.println("Montant:");
				montantR = Lire.d();
				System.out.println("Date : ");
				dateR = Lire.S();
			    ligneR = "Date: " + dateR.concat(" montant: " + montantR);
			    aux.getRembourement().add(ligneR);
			}
		

			    
			  
			  
			

		}
	}

	public static void SearchClientAudessusMontant(ListeASSURES listeASSURES) {

		System.out.println("Au dessus de quel montant voulez vous affichez les client?");
		int montantTest = Lire.i();
		Iterator<String> iter;
		Set<String> tabcles;
		String cle;
		ASSURE aux;
		tabcles = listeASSURES.getListe().keySet();
		iter = tabcles.iterator();

		System.out.println("***** LISTE DES CLIENT AU DESSU DE " + montantTest + " €   ****");

		System.out.println("");
		while (iter.hasNext()) {

			cle = iter.next();
			aux = listeASSURES.getListe().get(cle);
            final String separateur=",";
			String chaine = aux.getRembourement().toString();
			String chaine1=chaine.substring(1, chaine.length()-1);
			String mots[] = chaine1.split(separateur);

	        for (int i = 0; i < mots.length; i++) {
	          
	            int pos = mots[i].indexOf("montant:") + 9; 
	            String mot = mots[i].substring(pos,mots[i].length()-2 );
	            int montantR = Integer.parseInt(mot);
	            
     			//System.out.println(pos);
				//System.out.println(nombre);
	           // System.out.println(mots[i]);
				if (montantR > montantTest) {
				    System.out.println(aux.getName()+" "+ montantR + "€");
					
			}
	        }


		}

	}

	public static void SearchWithIDandNAME(ListeASSURES listeASSURES) {
		String name;
		int id;
		Iterator<String> iter;
		Set<String> tabcles;
		String cle;
		ASSURE aux;
		System.out.println("Nom du client: ");
		name = Lire.S();
		System.out.println("Id client: ");
		id = Lire.i();

		tabcles = listeASSURES.getListe().keySet();
		iter = tabcles.iterator();
		System.out.println();

		while (iter.hasNext()) {
			cle = iter.next();
			aux = listeASSURES.getListe().get(cle);

			if (aux.getName().equalsIgnoreCase(name) && aux.getNumID() == id) {

				System.out.println(aux.getRembourement());
			}

		}

	}
}
