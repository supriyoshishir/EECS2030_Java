package fms;

public class PassengerInfo implements Comparable<PassengerInfo> {

	public String name;
	public double TicketAmount;
	public int FlightId;

	public PassengerInfo(String name, double TicketAmount, int FlightId) {
		this.setName(name);
		this.setTicketAmount(TicketAmount);
		this.setFlightId(FlightId);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTicketAmount() {
		return this.TicketAmount;
	}

	public void setTicketAmount(double TicketAmount) {
		this.TicketAmount = TicketAmount;
	}

	public int getFlightId() {
		return this.FlightId;
	}

	public void setFlightId(int FlightId) {
		this.FlightId = FlightId;
	}

	public int compareTo(PassengerInfo other) {
		int result = (int) Math.rint(this.getTicketAmount() - other.getTicketAmount());
		if (result == 0) {
			result = other.getFlightId() - this.getFlightId();
		}
		return result;
	}

	public boolean equals(Object obj) {
		if (obj instanceof PassengerInfo) {
			PassengerInfo other = (PassengerInfo) obj;
			return (this.getName() == other.getName() && this.getTicketAmount() == other.getTicketAmount()
					&& this.getFlightId() == other.getFlightId());
		} else {
			return false;
		}
	}
}