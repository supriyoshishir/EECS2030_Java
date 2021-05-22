package studentSystem;

public class GPA {
	private double gpa;
	private int year;

	public GPA(int year, double gpa) {
		this.year = year;
		this.gpa = gpa;
	}

	public GPA(GPA g) {
		this(g.getYear(), g.getGPA());
	}

	public double getGPA() {
		return this.gpa;
	}

	public void setGPA(double gpa) {
		this.gpa = gpa;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GPA other = (GPA) obj;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
}