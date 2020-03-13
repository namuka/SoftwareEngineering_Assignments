package edu.mum.cs.cs425.unitTestDemo.unittestservice.impl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.unitTestDemo.unittestservice.ArrayFlattenerService;

@Service
public class ArrayFlattenerServiceImpl implements ArrayFlattenerService {

	@Override
	public int[] flattenArray(int[][] a1) {
		if(a1==null || a1.length==0) return null;
		
		return Arrays.stream(a1).flatMapToInt(Arrays::stream).toArray();
	}

}
