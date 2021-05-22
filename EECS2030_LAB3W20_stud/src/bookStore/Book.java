package bookStore;

import java.util.Objects;

public class Book implements Comparable<Book> {

	private String title;
	private int yearofpublish;
	private double price;

	public Book() {
		this("", 0, 0.0);
	}

	public Book(String title, int yearPublished, double price) {
		this.title = title;
		this.yearofpublish = yearPublished;
		this.price = price;
	}

	Book(Book book) {
		this(book.getTitle(), book.getYearPublished(), book.getPrice());
	}

	public int getYearPublished() {
		return this.yearofpublish;
	}

	public String getTitle() {
		return this.title;
	}

	public double getPrice() {
		return this.price;
	}

	public String toString() {
		return String.format("%s, %d, %d, %.2f", this.getTitle(), this.getYearPublished(), this.hashCode(),
				this.getPrice());
	}

	public int hashCode() {
		return Objects.hash(this.getTitle(), this.getYearPublished(), this.getPrice());
	}

	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book other = (Book) obj;
			return (this.hashCode() == other.hashCode() && this.getPrice() == other.getPrice());
		} else {
			return false;
		}
	}

	public int compareTo(Book other) {
		return (int) Math.round(this.getPrice() - other.getPrice());
	}

}