package carsharing;

import java.util.ArrayList;

/**
 * Class for Station
 */
public class Station {
	private int stationNumber;
	private ArrayList<Passenger> people;

	/**
	 * Constructor
	 * 
	 * @param number
	 *            - station id number
	 */
	public Station(int number) {
		setStationNumber(number);
		this.people = new ArrayList<Passenger>();
	}

	/**
	 * sets the stationNumber
	 * 
	 * @param number
	 */
	private void setStationNumber(int number) {
		this.stationNumber = number;
	}

	/**
	 * Returns the stationNumber;
	 */
	public int getNumber() {
		return this.stationNumber;
	}

	/**
	 * Adds a passenger to the station list
	 * 
	 * @param p
	 *            - passenger to be added
	 */
	public void add(Passenger p) {
		this.people.add(p);
	}

	/**
	 * Returns the passenger at
	 * 
	 * @param index
	 * @return passenger at this index in the ArrayList
	 */
	public Passenger get(int index) {
		return this.people.get(index);
	}

	/**
	 * Removes a specific passenger from the list
	 * 
	 * @param p
	 *            - passener to be removed
	 * @return - true of false based on operation
	 */
	public boolean remove(Passenger p) {
		return this.people.remove(p);
	}

	/**
	 * Getter for people ArrayList
	 * 
	 * @return this.people
	 */
	public ArrayList<Passenger> peopleWaitingList() {
		return this.people;
	}

	public String toString() {
		StringBuilder stringBuilderConcat = new StringBuilder().append("The following people are at this station: ");
		for (Passenger p : this.peopleWaitingList()) {
			stringBuilderConcat.append(" " + p);
		}
		return stringBuilderConcat.toString();
	}
}