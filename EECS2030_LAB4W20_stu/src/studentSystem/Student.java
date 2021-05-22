package studentSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Student {

	static int serial = 0; // non-private for testing
	String name; // non-private for testing
	int year; // non-private for testing
	String yorkID; // non-private for testing
	Date joinDate; // non-private for testing
	Set<Course> courses; // assume no duplicate courses so use a set // non-private for testing
	List<GPA> GPAs; // non-private for testing

	/**
	 * create a student with empty courses and GPAs
	 */
	public Student() {
		this.setYorkID(String.format("York-%02d", ++Student.serial));
		this.courses = new HashSet<>();
		this.GPAs = new ArrayList<>();
	}

	public Student(String name, int year, Date joinDate, Set<Course> courses, List<GPA> gpas) {
		this.setName(name);
		this.setYear(year);
		this.setJoinDate(joinDate);
		this.setCourses(courses);
		this.setGPAs(gpas);

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getYorkID() {
		return this.yorkID;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setYorkID(String id) {
		this.yorkID = id;
	}

	/**
	 * @return the joinDate
	 */
	public Date getJoinDate() {
		return new Date(this.joinDate);
	}

	/**
	 * @param joinDate
	 *            the joinDate to set
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = new Date(joinDate);
	}

	/**
	 * @return the course
	 */
	public Set<Course> getCourses() {
		return new HashSet<>(this.courses);
	}

	/**
	 * @param courses
	 *            the course to set
	 */
	public void setCourses(Set<Course> courses) {
		this.courses = new HashSet<>();
		this.courses.addAll(courses);
	}

	/**
	 * @return the gpas
	 */
	public List<GPA> getGPAs() {
		List<GPA> results = new LinkedList<>();
		for (GPA g : this.GPAs) {
			results.add(new GPA(g));
		}
		return results;
	}

	/**
	 * @param gpas
	 *            the gpas to set
	 */
	public void setGPAs(List<GPA> gpas) {
		this.GPAs = new LinkedList<>();
		for (GPA g : gpas) {
			this.GPAs.add(new GPA(g));
		}
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

}
