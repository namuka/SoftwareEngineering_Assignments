package edu.mum.cs.cs425.unitTestDemo.unittestwithjunitandmockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import edu.mum.cs.cs425.unitTestDemo.unittestservice.ArrayFlattenerService;

class ArrayReversorTest {	
	
		
	private ArrayFlattenerService afService = mock(ArrayFlattenerService.class);
	
	private ArrayReversor arrayReversor = new ArrayReversor(afService);

	@BeforeEach
	void setUp() throws Exception {
		this.arrayReversor = new ArrayReversor(afService);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.arrayReversor = null;
	}

	@Test
	void testReverseArray() {
		int[][] testArray = {{1,3},{0},{4,5,9}};
		int[] fArr = {1, 3, 0, 4, 5, 9};
		int[] rArr = {9, 5, 4, 0, 3, 1};
		when(afService.flattenArray(testArray)).thenReturn(fArr);
		int[] reversedArr = arrayReversor.reverseArray(testArray);		
		assertThat(reversedArr, is(rArr));
		verify(afService).flattenArray(testArray);
	}
	
	@Test
	void testCase2ReverseArray() {
		when(afService.flattenArray(null)).thenReturn(null);	
		assertNull(arrayReversor.reverseArray(null));
	}

}
