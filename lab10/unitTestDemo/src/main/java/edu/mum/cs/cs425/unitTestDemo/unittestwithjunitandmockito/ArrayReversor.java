package edu.mum.cs.cs425.unitTestDemo.unittestwithjunitandmockito;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.cs425.unitTestDemo.unittestservice.ArrayFlattenerService;

public class ArrayReversor {

	@Autowired
	private ArrayFlattenerService arrayFlattenerService;
	
	public ArrayReversor(ArrayFlattenerService afs) {
		this.arrayFlattenerService = afs;
	}
	
	public int[] reverseArray(int[][] a1) {
		if(a1==null || a1.length==0) return null;	
		
		int[] tmp = arrayFlattenerService.flattenArray(a1);
		int[] reversed = new int[tmp.length];
		int index = 0;
		for (int i = tmp.length-1; i >= 0; i--) 
		{
			reversed[index] = tmp[i]; 
			index++;
		}
		return reversed;
	}
}
