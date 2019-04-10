package com.jimsun.Array;

import java.util.Deque;
import java.util.LinkedList;

public class SecondaryAlgorithm {
	/*滑动窗口最大值:
	 *给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
	 *你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。返回滑动窗口最大值。
	 *示例:
	 *输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
	 *输出: [3,3,5,5,6,7]  
	 * */
	public int[] maxSlidingWindow(int[] nums,int k) {
		int len = nums.length;
		if(len<k || len == 0 ||k == 0)
			return new int[]{};
		if(k == 1)
			return nums;
		int arr[] = new int[len-k+1];
		int max = nums[0];
		for(int i =1;i<k;++i) {
			max = max > nums[i] ? max : nums[i];
		}
		arr[0] = max;
		for(int j = 1;j <= len-k;++j) {
			int index = j+k-1;
			if(nums[index] > max) {
				max = nums[index];
			}else {
				if(nums[j-1] == max) {
					max = nums[j];
					for(int a = j+1;a<=index;++a) {
						max= max > nums[a] ? max : nums[a];
					}				
				}else {}					
			}
			arr[j]=max;	
		}
		return arr;
	}
	public int[] maxSlidingWindowImprove(int[] nums,int k) {
		int len = nums.length;
		if(len<k || len == 0 ||k == 0)
			return new int[]{};
		if(k == 1)
			return nums;
		Deque<Integer> que = new LinkedList<Integer>();
		int arr[] = new int[len-k+1];
		for(int j = 0,i=0;j <len;++j) {
			while(!que.isEmpty() && nums[j] > nums[que.getLast()]) {
				que.removeLast();
			}
			que.addLast(j);
			/*
			while(!que.isEmpty() && que.getFirst() <= j-k) {
				que.removeFirst();
			}*/
			if(j >= k-1)
				arr[i++] = nums[que.getFirst()];
		}
		return arr;
	}
}
