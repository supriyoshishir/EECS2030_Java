package fms;

public class FlightInfo {

	public String name;
	public String airline;

	public FlightInfo(String name, String airline) {
		this.setName(name);
		this.setAirline(airline);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAirline() {
		return this.airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		FlightInfo other = (FlightInfo) obj;
		if (other.getName().equals(this.getName()) && other.getAirline().equals(this.getAirline())) {
			return true;
		} else {
			return false;
		}

	}
}
