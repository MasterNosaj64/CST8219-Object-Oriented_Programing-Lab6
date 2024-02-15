/*
 * Name:Jason Waid
 * Student ID:040912687
 * Course & Section: CST8132 304
 * Assignment: Lab 6
 * Date: Nov 4th, 2018
 */
package cst8132.sarray;

/**
 * This Java class consists of an array that can be modified and manipulated
 * without leaving unused memory allocated
 * 
 * @author Jason Waid
 *
 */
public class StringArray {

	private int capacity; // The current capacity of the array
	private int size; // The current size of the array
	private String[] stringArray; // The current String array

	/**
	 * Constructor initializes the size and capacity variables for the array. The
	 * capacity value determines the number of index's available in the array
	 * 
	 * @param capacity
	 *            is the number of slots available to the array
	 * @param size
	 *            is the number of objects inhabiting the array
	 */
	public StringArray() {
		// Default constructor, Constructs an empty StringArray with an initial capacity
		// of 10
		capacity = 10; // Size of the array
		size = 0; // Number of objects in the array
		stringArray = new String[capacity];

	}

	/**
	 * Constructs the initial number of index's available to the array
	 * 
	 * @param initialCapacity
	 *            is the number of index's initially available to the array
	 * @throws IllegalArgumentException
	 *             is run when the initial capacity is negative or not an integer
	 */
	public StringArray(int initialCapacity) throws IllegalArgumentException {
		try {
			stringArray = new String[initialCapacity];

		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException);
		}
	}

	/**
	 * a copy constructor creates a copy of the first array which can then be
	 * further modified
	 * 
	 * @param sa
	 *            is the term that is assigned to the copy of the array
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public StringArray(StringArray sa) throws NullPointerException {
		try {
			stringArray = new String[sa.size];
			for (int i = 0; i <= stringArray.length; i++) {
				stringArray[i] = sa.stringArray[i];
			}

		} catch (NullPointerException nullPointerException) {
			System.out.println(nullPointerException);
		}
	}

	/**
	 * adds the designated object to the end of the array, will increment capacity
	 * of array if it is full
	 * 
	 * @param s
	 *            the object to be added to the array
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public void add(String s) throws NullPointerException {
		try {
			if (size() == capacity()) {
				capacity++;
			}
			add(size, s);
			size++;
		} catch (NullPointerException nullPointerException) {
			System.out.println(nullPointerException);
		}
	}

	/**
	 * Adds the object at the desired index of the array without overwriting any
	 * information, if the capacity of the array isn't already large enough to allow
	 * this, the capacity will be incremented
	 * 
	 * @param index
	 *            is the desire position in the array
	 * @param s
	 *            the object to be inserted into the array
	 * @throws IndexOutOfBoundsException
	 *             will run when the requested index is larger than the array itself
	 *             or a negative index
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public void add(int index, String s) throws IndexOutOfBoundsException, NullPointerException {
		try {
			while (size() + 1 > capacity()) {
				capacity++;
			}
			for (int i = size() + 1; i >= index; i--) {
				stringArray[i + 1] = stringArray[i];
			}
			size++;
		} catch (NullPointerException nullPointerException) {
			System.out.println(nullPointerException);
		}
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException found");
		}
	}

	/**
	 * returns the current capacity of the array (the number of index's)
	 * 
	 * @return capacity is the max size possible for the array
	 */
	public int capacity() {
		return capacity;
	}

	/**
	 * clears the array of all objects
	 * 
	 * @param size
	 *            is the number of objects in the array
	 */
	public void clear() {
		for (int i = size; i >= 0; i--) {
			stringArray[i] = null;
			size--;
		}
	}

	/**
	 * Determines if the requested object is already in the array, returns true if
	 * it is
	 * 
	 * @param s
	 *            the object
	 * @return true will be returned if the object being looked for is in the array
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public boolean contains(String s) throws NullPointerException {
		try {
			for (int i = 0; i < stringArray.length; i++) {

				if (stringArray[i].equals(s)) {
					return true;
				}
			}
		} catch (NullPointerException nullPointerException) {
			System.out.println(nullPointerException);

		}
		return false;
	}

	/**
	 * Determines if the current array needs to increase in size by comparing the
	 * current capacity to the requested minimum
	 * 
	 * @param minCapacity
	 *            is set by the user
	 * @throws CapacityOutOfBoundsException
	 *             runs if the minimum capacity requested is smaller than the number
	 *             of objects in the array
	 */
	public void ensureCapacity(int minCapacity) throws CapacityOutOfBoundsException {
		while (capacity() < minCapacity) {
			capacity++;
		}
		if (minCapacity <= size())
			throw new CapacityOutOfBoundsException("CapacityOutOfBoundsException is found");
	}

	/**
	 * gets the object at the specified index in the array
	 * 
	 * @param index
	 *            the address in the array
	 * @return the object stored in the defined index
	 * @throws IndexOutOfBoundsException
	 *             will run when the requested index is larger than the array itself
	 *             or a negative index
	 */
	public String get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size()) {
			throw new CapacityOutOfBoundsException("CapacityOutOfBoundsException is found");
		}
		return stringArray[index];
	}

	/**
	 * located the index number of a specified string
	 * 
	 * @param s
	 *            is the string being looked for in the array
	 * @return the index number of the specified string
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public int indexOf(String s) throws NullPointerException {
		try {
			for (int i = 0; i <= stringArray.length; i++) {

				if (stringArray[i] == s) {
					return i;
				} else if (stringArray[i] != s && i == stringArray.length) {
					return -1;
				}
			}
		} catch (NullPointerException nullPointerException) {
			System.out.println(nullPointerException);
		}
		return 0;
	}

	/**
	 * determines if the array is empty
	 * 
	 * @return true if the array is empty, false if it is not
	 */
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * removed an object from the array at a specified index, shifts all objects in
	 * the array to remove any gaps
	 * 
	 * @param index
	 *            the specified position in the array
	 * @return the removed object from the array
	 * @throws IndexOutOfBoundsException
	 *             will run when the requested index is larger than the array itself
	 *             or a negative index
	 */
	public String remove(int index) throws IndexOutOfBoundsException {
		String removedString = null;
		stringArray[index] = removedString;
		for (int i = index; i <= size(); i++) {
			stringArray[i] = stringArray[i + 1];
		}
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsExceptions is found");
		}
		return removedString;
	}

	/**
	 * checks the array for a specified object and removes the first occurrence if
	 * it is found
	 * 
	 * @param s
	 *            the object being looked for in the array
	 * @return true one the object has been removed, false if it was not found
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public boolean remove(String s) throws NullPointerException {
		try {
			for (int i = 0; i <= stringArray.length; i++) {

				if (stringArray[i] == s) {
					remove(i);
					return true;
				}
			}
		} catch (NullPointerException nullPointerException) {
			System.out.println(nullPointerException);

		}
		return false;
	}

	/**
	 * 
	 * @param index
	 *            is the address in the array
	 * @param s
	 *            is the object to be inserted into the array
	 * @return value of replaced object in the array
	 * @throws IndexOutOfBoundsException
	 *             will run when the requested index is larger than the array itself
	 *             or a negative index
	 * @throws NullPointerException
	 *             will run if the object being inserted into the array is null
	 */
	public String set(int index, String s) throws IndexOutOfBoundsException, NullPointerException {
		try {
			String oldValue;
			oldValue = stringArray[index];
			// stringArray[index] = s;
			set(index, s);
			return oldValue;
		} catch (NullPointerException nullPointerException) {
			System.out.println(nullPointerException);
		}
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException is found");
		}
		return null;
	}

	/**
	 * This method returns the number of object in the given array
	 * 
	 * @param the
	 *            number of objects in the array defined by size
	 * @return Returns number of objects in the Array
	 */
	public int size() {
		return size;
	}
}
