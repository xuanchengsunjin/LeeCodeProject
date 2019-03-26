package com.jimsun.Array;


import org.junit.Test;

import com.jimsun.MathProblem.PrimaryAlgorithm;

public class TestArray {
	@Test
	public void testSampleOne() {
		PrimaryAlgorithm a= new PrimaryAlgorithm();
		System.out.println(a.romanToInt("MCMXCIV"));
		
		
	}
	void printArray(int[] arr) {
		System.out.println("打印数组如下：");
		for(int data:arr) {
			System.out.println(data);
		}
		System.out.println("打印结束");
	}
}
