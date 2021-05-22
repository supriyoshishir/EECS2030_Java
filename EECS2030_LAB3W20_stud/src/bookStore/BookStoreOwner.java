package bookStore;

import java.util.Objects;

public class BookStoreOwner {
	private String name;
	private long id;

	BookStoreOwner(String name) {
		this.name = name;
		this.id = this.hashCode();
	}

	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int hashCode() {
		return Objects.hash(this.name);
	}

	public boolean equals(Object obj) {
		if (obj instanceof BookStoreOwner) {
			BookStoreOwner other = (BookStoreOwner) obj;
			return this.getId() == other.getId();
		} else {
			return false;
		}
	}

	public String toString() {
		return String.format("%s, %d", this.getName(), this.getId());
	}
}
