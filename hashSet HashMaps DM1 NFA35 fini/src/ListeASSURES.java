import java.util.HashMap;



public class ListeASSURES {
	
	private HashMap<String, ASSURE>liste=new HashMap<String, ASSURE>();

	public ListeASSURES(HashMap<String, ASSURE> liste) {
	
		this.liste = liste;
	}

	public HashMap<String, ASSURE> getListe() {
		return liste;
	}

	public void setListe(HashMap<String, ASSURE> liste) {
		this.liste = liste;
	}


}
		
	

