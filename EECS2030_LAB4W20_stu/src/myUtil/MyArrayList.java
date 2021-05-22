package myUtil;

public class MyArrayList<E> implements MyList<E> {

	private static final int DEFAULT_CAPACITY = 10;

	int size; // non-private for testing purpose
	E[] elementData; // non-private for testing purpose

	/**
	 * Create an empty list of capacity capa
	 * 
	 * @param capa
	 *            the initial capacity. Assume greater than 0.
	 */
	@SuppressWarnings({ "unchecked" })
	public MyArrayList(int capa) {
		this.elementData = (E[]) new Object[capa];
	}

	/**
	 * Create an empty list of default capacity
	 * 
	 */
	@SuppressWarnings({ "unchecked" })
	public MyArrayList() {
		this.elementData = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public boolean contains(E o) {
		boolean result = false;
		for (E e : this.elementData) {
			if (o.equals(e)) {
				return true;
			}
		}
		return result;
	}

	@SuppressWarnings({ "unchecked" })
	private E[] getTempArr() {
		int temp = ((this.size() / DEFAULT_CAPACITY)) + 1;
		return (E[]) new Object[temp * DEFAULT_CAPACITY];
	}

	public void add(E o) {
		this.size++;
		E[] tempArray = getTempArr();
		for (int i = 0; i < this.size(); i++) {
			if (i == (this.size() - 1)) {
				tempArray[i] = o;
			} else {
				tempArray[i] = this.elementData[i];
			}
		}
		this.elementData = tempArray;
	}

	public void remove(E o) {
		boolean found = false;
		E[] tempArray = getTempArr();
		int j = 0;
		int limit = this.size();
		for (int i = 0; i < limit; i++) {
			if (!found && o.equals(this.elementData[i])) {
				found = true;
				this.size--;
			} else if (!found && j >= this.size() - 1) {
				break;
			} else {
				tempArray[j] = this.elementData[i];
				j++;
			}
		}
		this.elementData = found ? tempArray : this.elementData;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		for (int i = 0; i < this.size(); i++) {
			if (i == index) {
				return this.elementData[i];
			}
		}
		throw new IndexOutOfBoundsException("Index is out of bounds");
	}

	public E set(int index, E element) throws IndexOutOfBoundsException {
		for (int i = 0; i < this.size(); i++) {
			if (i == index) {
				E prev = this.elementData[i];
				this.elementData[i] = element;
				return prev;
			}
		}
		throw new IndexOutOfBoundsException("Index is out of bounds");
	}

	public void add(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		this.size++;
		E[] tempArray = getTempArr();
		int j = 0;
		for (int i = 0; i < this.size(); i++) {
			if (i == index) {
				tempArray[i] = element;
			} else {
				tempArray[i] = this.elementData[j];
				j++;
			}
		}
		this.elementData = tempArray;
	}

	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		E result = null;
		E[] tempArray = getTempArr();
		int j = 0;
		for (int i = 0; i <= this.size(); i++) {
			if (i == index) {
				result = this.elementData[i];
			} else {
				tempArray[j] = this.elementData[i];
				j++;
			}
		}
		this.size--;
		this.elementData = tempArray;
		return result;
	}

	public int indexOf(E o) {
		for (int i = 0; i <= this.size(); i++) {
			if (o.equals(this.elementData[i])) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(E o) {
		for (int i = this.size() - 1; i >= 0; i--) {
			if (o.equals(this.elementData[i])) {
				return i;
			}
		}
		return -1;
	}
}