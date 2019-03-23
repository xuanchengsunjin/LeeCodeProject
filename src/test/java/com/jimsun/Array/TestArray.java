package com.jimsun.Array;

import org.junit.Test;

import com.jimsun.String.PrimaryAlgorithm;

public class TestArray {
	@Test
	public void testSampleOne() {
		int[] arr = {0,9,0,4,9};
		//PrimaryAlgorithm a = new PrimaryAlgorithm();
		PrimaryAlgorithm b = new PrimaryAlgorithm();
		System.out.println(b.countAndSay(6));
		//System.out.println(Integer.MAX_VALUE);2147483647
		
		
	}
	void printArray(int[] arr) {
		System.out.println("打印数组如下：");
		for(int data:arr) {
			System.out.println(data);
		}
		System.out.println("打印结束");
	}
}
