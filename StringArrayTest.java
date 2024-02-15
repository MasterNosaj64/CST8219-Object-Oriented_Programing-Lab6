package cst8132.sarray.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import cst8132.sarray.StringArray;
import cst8132.sarray.CapacityOutOfBoundsException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertNotSame;

public class StringArrayTest {
	StringArray testArray = new StringArray();
	String A;
	String B;
	String C;
	String D;

	@Test
	public void testStringArray() {// passes

		assertNotNull(testArray);
		assertEquals(10, testArray.capacity());
		assertEquals(0, testArray.size());
	}

	@Test
	public void testStringArrayInt() {
		fail();
	}

	@Test
	public void testStringArrayStringArray() {// doesn't pass
		assertNotNull(testArray.add(A));
	}

	@Test
	public void testAddString() {// doesn't pass
		assertNotNull(A);
	}

	@Test
	public void testAddIntString() {
		fail();
	}

	@Test
	public void testCapacity() {// passes
		assertNotNull(testArray.capacity());
	}

	@Test
	public void testClear() {
		fail();
	}

	@Test
	public void testContains() {
		fail();
	}

	@Test
	public void testEnsureCapacity() {
		fail();
	}

	@Test
	public void testGet() {
		fail();
	}

	@Test
	public void testIndexOf() { // passes
		testArray.add(A);
		testArray.add(B);
		testArray.add(C);
		testArray.add(D);
		assertNotNull(testArray.indexOf(D));
	}

	@Test
	public void testIsEmpty() {// passes
		assertEquals(testArray.size(), 0);
	}

	@Test
	public void testRemoveInt() { // passes
		testArray.add(A);
		assertEquals(testArray.remove(0), A);
	}

	@Test
	public void testRemoveString() {// passes
		testArray.add(A);
		testArray.add(B);
		testArray.add(C);
		testArray.add(D);
		assertTrue(testArray.remove(C));
	}

	@Test
	public void testSet() {// can't pass test
		testArray.add(A);
		testArray.add(B);
		testArray.add(C);
		testArray.add(D);

		assertNotNull(testArray.set(2, D));
	}

	@Test
	public void testSize() {// passes
		assertNotNull(testArray.size());
	}

}
