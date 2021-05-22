package lab1package;

public class Student {
	private static final int SIZE = 30;
	private String name;
	private String address;
	private String[] courses;
	private double[] grades;
	private int currentSize;
	// Constructor

	public Student(String name, String address) {
		this.name = name;
		this.address = address;
		courses = new String[SIZE];
		grades = new double[SIZE];
		currentSize = 0;
	}
	// getters and setters

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void addCourseGrade(String course, int grade) {
		if (currentSize >= SIZE)
			System.err.println("Cannot take more courses...");
		else {
			courses[currentSize] = course;
			grades[currentSize] = grade;
			currentSize++;
			// System.out.println("Course Added Successfully.....");
		}
	}

	public void printGrades() {
		System.out.print(name + " ");
		for (int i = 0; i < currentSize; i++) {
			System.out.print(courses[i] + ":" + grades[i] + " ");
		}
		System.out.println();
	}

	public double getAverageGrade() {
		if (currentSize == 0) {
			System.err.println("No courses added...");
			return -1;
		} else {
			double sum = 0;
			for (int i = 0; i < currentSize; i++) {
				sum += grades[i];
			}
			return sum / currentSize;
		}
	}

	@Override
	public String toString() {
		return name + "(" + address + ")";
	}
}