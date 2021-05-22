package lab1package3;

public class Attraction {
	public String name;
	public double price;

	public Attraction() {
	}

	public Attraction(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String printString() {

		return "(" + this.getName() + ", " + this.getPrice() + ")";

	}
}