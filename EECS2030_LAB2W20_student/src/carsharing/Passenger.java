package carsharing;

/**
 * Passenger Class
 */
public class Passenger {

	private String name;
	private int destination;

	/**
	 * Initializes a Passenger.
	 * 
	 * @param name
	 *            name to reference the passenger by
	 * @param destination
	 *            numerical representation of the destination - finishes at station
	 *            4
	 */
	public Passenger(String name, int destination) {
		this.setName(name);
		this.setDesintation(destination);
	}

	/**
	 * Sets the name of the passenger
	 * 
	 * @param name
	 *            used for reference
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the destination of the passenger
	 * 
	 * @param destimation
	 *            numerical representation, max is 4, cannot be negative
	 */
	private void setDesintation(int desintation) {
		this.destination = desintation;
	}

	public int getDestimation() {
		return this.destination;
	}

	public String toString() {
		return String.format("%s->%d", this.name, this.getDestimation());
	}
}