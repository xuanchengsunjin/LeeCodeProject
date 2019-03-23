package com.jimsun.Array;

import org.junit.Test;

public class TestArray {
	@Test
	public void testSampleOne() {
		int[] arr = {0,9,0,4,9};
		PrimaryAlgorithm a = new PrimaryAlgorithm();
		//System.out.println(Integer.MAX_VALUE);2147483647
		System.out.println(a.isPalindrome("0P"));
		
	}
	void printArray(int[] arr) {
		System.out.println("打印数组如下：");
		for(int data:arr) {
			System.out.println(data);
		}
		System.out.println("打印结束");
	}
}
