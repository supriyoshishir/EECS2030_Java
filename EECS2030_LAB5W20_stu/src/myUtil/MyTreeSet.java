package myUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class MyTreeSet<E> extends MyAbstractSet<E> {

	protected TreeMap<E, Object> map; // non-private for testing purposes

	// Dummy value to associate with an Object in the backing Map
	private static final Object PRESENT = new Object();

	/**
	 * Constructs a new, empty set;
	 */
	public MyTreeSet() {
		this.map = new TreeMap<>();
	}

	// addAll
	@Override
	public Iterator<E> iterator() {
		return this.map.keySet().iterator();
	}

	@Override
	public boolean contains(E o) {
		boolean result = false;
		Iterator<E> iter = this.iterator();
		while (iter.hasNext() && !result) {
			E e = iter.next();
			result = o.equals(e);
		}
		return result;
	}

	@Override
	public boolean add(E e) {
		boolean result = this.map.put(e, PRESENT) != PRESENT;
		if (result) {
			this.size++;
		}
		return result;

	}

	@Override
	public boolean remove(E o) {
		boolean result = false;
		Iterator<E> iter = this.iterator();
		while (iter.hasNext() && !result) {
			E e = iter.next();
			result = o.equals(e);
			if (result) {
				this.map.remove(o);
				this.size--;
			}
		}
		return result;
	}

	@Override
	public void clear() {
		this.size = 0;
		this.map = new TreeMap<>();

	}

}
