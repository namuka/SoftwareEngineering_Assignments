package edu.mum.cs.cs425.unitTestDemo.unittestwithjunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayFlattenerTest {

	private ArrayFlattener arrayFlattner = new ArrayFlattener();
	
	@Test
	public void testFlattenArray() {
		int[][] testArray = {{1,3},{0},{4,5,9}};
		int[] expected = {1, 3, 0, 4, 5, 9};
		int[] actual = arrayFlattner.flattenArray(testArray);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testCase2FlattenArray() {
		int[] actual = arrayFlattner.flattenArray(null);
		assertNull(actual);
	}

}
