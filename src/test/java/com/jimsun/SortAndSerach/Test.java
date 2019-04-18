package com.jimsun.SortAndSerach;

import SortAndSerach.SecondaryAlgorithm;

public class Test {
	@org.junit.Test
	public void testSampleOne() {
		SecondaryAlgorithm test = new SecondaryAlgorithm ();
		int[] arr = new int[] {5,2,6,3,4,2,2};
		test.countSmallerImproveOne(arr);
	}
	void printArray(int[] arr) {
		System.out.println("打印数组如下：");
		for(int data:arr) {
			System.out.println(data);
		}
		System.out.println("打印结束");
	}
}
