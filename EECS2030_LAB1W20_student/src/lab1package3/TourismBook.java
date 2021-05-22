package lab1package3;

public class TourismBook {
	Attraction[] a;
	static int noa;

	public TourismBook() {
		this.a = new Attraction[100];
		noa = 0;
	}

	public Attraction[] getAttractions() {
		Attraction[] result = new Attraction[noa];
		for (int i = 0; i < noa; i++) {
			if (a[i] != null) {

				result[i] = a[i];
			}
		}
		return result;
	}

	public void addAttraction(Attraction c) {
		a[noa] = c;
		noa++;
	}

	public void addAttraction(String n, double p) {
		Attraction newat = new Attraction(n, p);
		this.addAttraction(newat);
	}

	public String nameBestAttraction() {
		double minprice = a[0].getPrice();
		String name = "";
		for (int i = 0; i < noa; i++) {

			if (a[i].getPrice() <= minprice) {
				minprice = a[i].getPrice();
			}
		}
		for (int j = 0; j < noa; j++) {
			if (a[j].getPrice() == minprice) {
				// no need to break

				name = a[j].getName();
			}
		}
		return name;
	}
}