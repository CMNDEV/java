import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DM2 {

	public static void main(String[] args) throws IOException {

		//NOM FICHIER DEJA CREER ** Client IDF **
		int choix;
		do {
			affichermenu();
			System.out.print("Choix :");
			choix = Lire.i();

			if (choix == 1) {
				creerNewFile();
			}
			if(choix==2) {
				openFile();
			}

		} while (choix != 3);

	}

	public static void affichermenu() {

		System.out.println("----------------- MENU -----------------");
		System.out.println("1: CREER UN NOUVEAU FICHIER");
		System.out.println("2: OUVRIR FICHIER");
		System.out.println("3: QUITTER");
		System.out.println("----------------------------------------");

	}

	public static void creerNewFile() throws IOException {
		String ligne;
		char choix;
		

		String nomFichier;
		System.out.print("Nom Fichier: ");
		nomFichier = Lire.S();
		File f = new File(nomFichier);
		FileWriter FW = new FileWriter(f);
		BufferedWriter BW = new BufferedWriter(FW);

		System.out.println("voulez vous ajouter une ville et un departement au fichier " + nomFichier + " O/N");
		choix = Lire.c();

		while (choix =='O') {
			System.out.print("Entrez la ville et departement séparé par le signe * :");
			ligne = Lire.S();
			BW.write(ligne.toUpperCase(), 0, ligne.length());
			BW.newLine();
			System.out.print("voulez vous ajouter une autre ville et un departement O/N :");
			choix = Lire.c();
		}
		
		BW.close();
		System.out.println("---- Fin de la creation du fichier ----");

	}
	
	public static void openFile() throws IOException{
		
		//Nom fichier deja present:
		String monFichier,ligne;
		String departement;
		System.out.print("Quel fichier voulez vous ouvrir : ");
		monFichier=Lire.S();
		
		File f = new File(monFichier);
		FileReader FR = new FileReader(f);
		BufferedReader BR = new BufferedReader(FR);
		
		System.out.print("vous voulez voir les clients de quel departement : ");
		departement=Lire.S();
		
		try {
			
		
		do {
			ligne=BR.readLine();
			if(ligne.contains(departement)) {
				String separateur="*"; 
				int index=ligne.indexOf(separateur);
				ligne=ligne.substring(0, index);
				
				System.out.println(ligne.toUpperCase());
			}
			
			
		} while (ligne!=null);
		BR.close();
		} catch (NullPointerException e) {
			System.out.println("------- Fin de la liste -------");
			e.printStackTrace();
		}
	}
}
