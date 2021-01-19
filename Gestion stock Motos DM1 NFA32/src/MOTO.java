
public class MOTO {
	
	private String name;
	private double price;
	private int stock;
	private int garantie;
	

	public MOTO(String name, double price, int stock, int garantie) {
		
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.garantie = garantie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getGarantie() {
		return garantie;
	}

	public void setGarantie(int garantie) {
		this.garantie = garantie;
	}

}
