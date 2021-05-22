package studentSystem;

public class Date {
	private int month;
	private int year;

	public Date(int year, int month) throws IllegalArgumentException {
		this.setYear(year);
		this.setMonth(month);
	}

	public Date(Date date) {
		this(date.getYear(), date.getMonth());
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) throws IllegalArgumentException {
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("Month is invalid");
		}
		this.month = month;
	}
	
	public int getYear() {
		return this.year;
	}

	public void setYear(int year) throws IllegalArgumentException {
		if (year < 0) {
			throw new IllegalArgumentException("Year is invalid");
		}
		this.year = year;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Date) {
			Date other = (Date) o;
			return (other.getYear() == this.getYear() && other.getMonth() == this.getMonth());
		} else {
			return false;
		}
	}
}