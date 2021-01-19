import java.util.HashSet;

public class ASSURE {
	private String name;
    private int numID;
    private HashSet<String>remboursement=new HashSet<String>();
	public ASSURE(String name, int numID, HashSet<String> remboursement) {
		super();
		this.name = name;
		this.numID = numID;
		this.remboursement = remboursement;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumID() {
		return numID;
	}
	public void setNumID(int numID) {
		this.numID = numID;
	}
	public HashSet<String> getRembourement() {
		return remboursement;
	}
	public void setRembourement(HashSet<String> rembourement) {
		this.remboursement = rembourement;
	}

}
