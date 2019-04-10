package com.jimsun.Array;


import org.junit.Test;

import com.jimsun.MathProblem.PrimaryAlgorithm;

public class TestArray {
	public void testSampleOne() {
		PrimaryAlgorithm a= new PrimaryAlgorithm();
		System.out.println(a.romanToInt("MCMXCIV"));	
	}
	@Test
	public void testSampleTwo() {
		SecondaryAlgorithm a = new SecondaryAlgorithm();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		printArray(a.maxSlidingWindowImprove(nums, 3));
	}
	void printArray(int[] arr) {
		System.out.println("打印数组如下：");
		for(int data:arr) {
			System.out.println(data);
		}
		System.out.println("打印结束");
	}
}
