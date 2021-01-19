import java.util.Scanner;

public class Mastermind {

	static String [] TAB_REF_COLORS = { "Rouge", "Jaune", "Vert", "Bleu", "Orange", "Gris", "Noir", "Fuchsia"};

	static int NB_COLORS = 4;
	static void sautLigne() {System.out.println();}
	static boolean isIn(String iStringToFind, String [] iTab) {

		int size = iTab.length; 
		for(int i=0;i<size;i++) { 
			if(iStringToFind.equals(iTab[i])) 
				return true;
		}
		return false;

	}

	static String [] generateRandomCombination() {

		String [] combination = new String[NB_COLORS];
		int currentPosition = 0;
		while(currentPosition!=NB_COLORS) {

			int indexRandom = (int)(Math.random()*TAB_REF_COLORS.length);

			String color = TAB_REF_COLORS[indexRandom];

			if(!isIn(color, combination)) { 
				combination[currentPosition] = color; currentPosition++;

			}

		} return combination;

	}


	public static void main(String args[]) {

		boolean succes=false;
		Scanner sc = new Scanner (System.in);
		String choix="";
		char reponse=' ';
		
		
		
		System.out.println("                       **** WELCOME TO THE MASTERMIND **** BY NOUR CAHAMASSI ****         ");
		System.out.println(" **** \"R\" = Rouge, \"J\" = Jaune, \"V\" = Vert, \"B\" = Bleu, \"O\" = Orange, \"G\" = Gris, \"N\" = Noir, \"F\" = Fuchsia ****          ");
		System.out.println("  ** Le principe est simple: il faut decouvrir la combinaison de 4 couleur sous la forme: \"KLOR\" en 12 ESSAI ");
		sautLigne();

		
			
			do {
				int essai=0;
			String [] combinaisonSecrete = generateRandomCombination();
			for(int i=0;i<4;i++) {
				// System.out.println(combinaisonSecrete[i]); 
			}
			
			
			do {
				
				essai++;
				String []choixtab=new String[4];
				
				String [] CombinaisonChoisit = {combinaisonSecrete[0].substring(0,1),combinaisonSecrete[1].substring(0,1),combinaisonSecrete[2].substring(0,1),combinaisonSecrete[3].substring(0,1)};

				for(int i=0;i<CombinaisonChoisit.length;i++);

				System.out.println("ESSAI N°"+ essai);

			do {
				        
						System.out.println("Entrez votre combinaisons: ");
						choix = sc.nextLine();
						if(choix.length()<=0) {
							System.out.println("Vous n'avez pas fait de choix pour votre Essai N°: "+essai);
						}else if(choix.length()>4){
							System.out.println("vous avez choisit trop de couleur pour votre Essai N°: "+essai);
	
						}else if (choix.length()<4) {
							System.out.println("Entrez un choix des 4 premieres lettres de vos choix de couleur svp pour votre Essai N°: "+essai);
						}else {
							choixtab[0]=choix.substring(0,1).toUpperCase();
							choixtab[1]=choix.substring(1,2).toUpperCase();
							choixtab[2]=choix.substring(2,3).toUpperCase();
							choixtab[3]=choix.substring(3,4).toUpperCase();
						}
						
					}while(choix.length()!=4);

				
				

				if(choixtab[0].equals(CombinaisonChoisit[0])) {
					System.out.println(choixtab[0]+ " bonne place");

				}else if (choixtab[0].equals(CombinaisonChoisit[1])|| choixtab[0].equals(CombinaisonChoisit[2]) ||choixtab[0].equals(CombinaisonChoisit[3])) {
					System.out.println(choixtab[0]+" mal placé");

				}
				if(choixtab[1].equals(CombinaisonChoisit[1])) {
					System.out.println(choixtab[1]+ " bonne place");
				}else if (choixtab[1].equals(CombinaisonChoisit[0])|| choixtab[1].equals(CombinaisonChoisit[2]) ||choixtab[1].equals(CombinaisonChoisit[3])) {
					System.out.println(choixtab[1]+" mal placé");

				}
				if(choixtab[2].equals(CombinaisonChoisit[2])) {
					System.out.println(choixtab[2]+ " bonne place");
				}else if (choixtab[2].equals(CombinaisonChoisit[0])|| choixtab[2].equals(CombinaisonChoisit[1]) ||choixtab[2].equals(CombinaisonChoisit[3])) {
					System.out.println(choixtab[2]+" mal placé");
				}
				if(choixtab[3].equals(CombinaisonChoisit[3])) {
					System.out.println(choixtab[3]+ " bonne place");
				}else if (choixtab[3].equals(CombinaisonChoisit[0])|| choixtab[3].equals(CombinaisonChoisit[1]) ||choixtab[3].equals(CombinaisonChoisit[2])) {
					System.out.println(choixtab[3]+" mal placé");
				}

				if(choixtab[0].equals(CombinaisonChoisit[0]) && choixtab[1].equals(CombinaisonChoisit[1]) && choixtab[2].equals(CombinaisonChoisit[2]) && choixtab[3].equals(CombinaisonChoisit[3])) {
					System.out.println("**** SUCCES VOUS AVEZ TROUVEZ LA BONNE COMBINAISON ****");
					succes=true;
					break;
				}

			}while((!succes) && (essai<12));
			
			if((!succes) || (essai<12)) {
				System.out.println("voulez vous recommencez Oui --> O ou Non --> N");
				reponse=sc.nextLine().charAt(0);
			}
		
			}while(reponse=='O');
		
		System.out.println("**** Merci de votre participation Aurevoir!!! ****");
		sc.close();
	}

}