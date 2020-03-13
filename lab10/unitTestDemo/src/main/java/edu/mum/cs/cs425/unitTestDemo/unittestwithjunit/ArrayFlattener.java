package edu.mum.cs.cs425.unitTestDemo.unittestwithjunit;

import java.util.Arrays;

public class ArrayFlattener {
		
	public int[] flattenArray(int[][] a1) {
		if(a1==null || a1.length==0) return null;
	
		return Arrays.stream(a1).flatMapToInt(Arrays::stream).toArray();
	}

}
