package carsharing;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Car Class
 */
public class Car {

	private int idNo;
	private int destination;
	private int location;
	private ArrayList<Passenger> passengers;
	private double faresCollected;
	private int milesDriven;
	final private double FARESPERMILE = 1.0;
	final private int MAXPASSENGERS = 3;

	/**
	 * Initializes a Passenger.
	 * 
	 * @param idNo
	 *            reference for the car
	 * @param location
	 *            numerical representation of its current location
	 * @param destination
	 *            numerical representation of the destination - finishes at station
	 *            4
	 */
	public Car(int idNo, int location, int destination) {
		this.setidNo(idNo);
		this.setLocation(location);
		this.setDesintation(destination);
		this.passengers = new ArrayList<Passenger>();
	}

	/**
	 * Sets the idNo of the passenger
	 * 
	 * @param idNo
	 *            used for reference
	 */
	private void setidNo(int idNo) {
		this.idNo = idNo;
	}

	/**
	 * Sets the location of the car
	 * 
	 * @param location
	 *            - numerical representation of where the car is
	 */
	private void setLocation(int location) {
		this.location = location;
	}

	/**
	 * Sets the desintation of the passenger
	 * 
	 * @param destimation
	 *            numerical representation, max is 4, cannot be negative
	 */
	private void setDesintation(int desintation) {
		this.destination = desintation;
	}

	/**
	 * Updates the miles driven
	 * 
	 * @param miles
	 *            miles driven
	 */
	private void setMilesDriven(int miles) {
		this.milesDriven = this.milesDriven + miles;
	}

	/**
	 * Updates the fares collected based on a fix amount
	 * 
	 * @param milesDriven
	 *            - the amount of miles to collect the fare for
	 */
	private void setFaresCollected(int milesDriven) {
		this.faresCollected += this.FARESPERMILE * milesDriven;
	}

	/**
	 * 
	 * @return idNo
	 */
	public int getIdNo() {
		return this.idNo;
	}

	/**
	 * 
	 * @return location
	 */
	public int getLocation() {
		return this.location;
	}

	/**
	 * 
	 * @return destination
	 */
	public int getDestination() {
		return this.destination;
	}

	/**
	 * 
	 * @return faresCollected
	 */
	public double getFares() {
		return this.faresCollected;
	}

	/**
	 * 
	 * @return milesDriven
	 */
	public int getMilesDriven() {
		return this.milesDriven;
	}

	/**
	 * 
	 * @return passengers
	 */
	public ArrayList<Passenger> getPassengers() {
		return this.passengers;
	}

	public boolean hasArrived() {
		return (this.getLocation() == this.getDestination()) ? true : false;
	}

	public boolean hasRoom() {
		return (this.getPassengers().size() < this.MAXPASSENGERS) ? true : false;
	}

	/**
	 * Drives to the next station - defaults distance between stations to 1 mile If
	 * location is equal to destination nothing happens Otherwise - updates the
	 * miles driven by the default and then updates the fares collected
	 */
	public void drive() {
		if (!this.hasArrived()) {
			int MILES_TO_NEXT_STATION = 1;
			this.setLocation(this.getLocation() + MILES_TO_NEXT_STATION);
			this.setMilesDriven(MILES_TO_NEXT_STATION);

			// Collect fares based on passengers
			for (int i = 0; i < this.getPassengers().size(); i++) {
				this.setFaresCollected(MILES_TO_NEXT_STATION);
			}

			System.out.println(String.format("Car %d drives to station %d", this.getIdNo(), this.getLocation()));
		}
	}

	public boolean dropOff() {
		boolean result = false;
		Iterator<Passenger> iter = this.getPassengers().iterator();
		while (iter.hasNext()) {
			Passenger passenger = iter.next();
			if (passenger.getDestimation() == this.getLocation()) {
				result = true;
				iter.remove();
				System.out.println(String.format("Car %d drops off %s at station %d. Car now has %d passengers",
						this.getIdNo(), passenger, this.getLocation(), this.getPassengers().size()));
			}
		}
		return result;
	}

	/**
	 * Checks if there is room to add another passenger
	 * 
	 * @param p
	 *            - passenger to be added
	 */
	public boolean add(Passenger p) {
		boolean result = false;
		if (this.hasRoom()) {
			this.passengers.add(p);
			result = true;
		}
		return result;
	}

	/**
	 * Override toString method to outline car id, current location and where it is
	 * traveling to.
	 */
	public String toString() {
		return String.format("Car[idNo=%d, location=%d, destination=%d, passengers=%s]", this.getIdNo(),
				this.getLocation(), this.getDestination(), this.getPassengers());
	}
}
