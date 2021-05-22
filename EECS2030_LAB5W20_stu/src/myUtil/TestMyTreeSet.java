package myUtil;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMyTreeSet extends TestSet {
	
	@Override
	protected MySet<String> loadSet() {
		return new MyTreeSet<>();
	}
	
	// add some methods
	@Test
	public void testAddTree() {
		// add a new method for ordering
		MySet <String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");
		s.add("Cindy");
		s.add("Joe");
		
		assertEquals(5, ((MyTreeSet<String>)s).map.size());
		
		String exp = "[ Alice Bob Cindy Joe Sue ]";  // natural (lexicographical) order
		 
		assertEquals(exp, s.toString());
	
	}
	
	@Test
	public void testSetUnionTree() {
		MySet <String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");
		
		MySet <String> s2 = loadSet();
		s2.add("Cindy");
		s2.add("Sue");
		s2.add("Joe");
		
		s.addAll(s2);
		
		assertEquals(5, ((MyTreeSet<String>)s).map.size());
		
		String exp = "[ Alice Bob Cindy Joe Sue ]";  // natural (lexicographical) order 
		assertEquals(exp, s.toString());
	} 
	
	@Test
	public void testSetClearTree() {
		MySet <String> s = loadSet();
		s.add("Alice");
		s.add("Sue");
		s.add("Bob");
		
		s.clear();
		
		assertEquals(0, ((MyTreeSet<String>)s).map.size());
		
	} 
	
 }