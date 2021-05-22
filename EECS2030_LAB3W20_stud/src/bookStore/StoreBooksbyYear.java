package bookStore;

import java.util.Comparator;

public class StoreBooksbyYear implements Comparator<Book> {
	public int compare(Book o1, Book o2) {
		if (o1.getYearPublished() > o2.getYearPublished()) {
			return 1;
		} else if (o1.getYearPublished() < o2.getYearPublished()) {
			return -1;
		} else {
			return 0;
		}
	}
}
