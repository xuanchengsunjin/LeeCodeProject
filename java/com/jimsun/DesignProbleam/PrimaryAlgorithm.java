package com.jimsun.DesignProbleam;

import java.util.Arrays;
import java.util.Random;

public class PrimaryAlgorithm {
	/*Shuffle the Array
	 *打乱一个没有重复元素的数组。
	 *示例:
	 *以数字集合 1, 2 和 3 初始化数组。
	 *int[] nums = {1,2,3};
	 *Solution solution = new Solution(nums);
	 *打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
	 *solution.shuffle();
	 *重设数组到它的初始状态[1,2,3]。
	 *solution.reset();
	 *随机返回数组[1,2,3]打乱后的结果。
	 *solution.shuffle();
	 * */
	//拓展：池塘采样
	class Solution {
	    private int[] arr = null;
	    private int[] a = null;
	    public Solution(int[] nums) {
	        this.arr = Arrays.copyOf(nums, nums.length);
	        this.a = nums;
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return this.arr;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	    	int res =0;
	    	Random r=new Random();
	    	int[] arr = this.a;
	        for(int i =1;i<a.length;i++) {
	        	if(r.nextInt(i + 1) == 0) {
	        		int temp = arr[i];
	        		arr[i] = arr[res];
	        		arr[res] = temp;
	        		res = i;
	        	}
	        }
	        return arr;
	    }
	}
	class SolutionImprove {
	    private int[] p;
	    private int[] q;
	    public SolutionImprove(int[] nums) {
	        p = nums;
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return p;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        int len = p.length;
	        q = new int[len];
	        for(int i = 0;i<len;i++)
	            q[i] = p[i];
	        int pos;//记录要交换元素的位置
	        int temp; //记录要交换的值
	        Random ran = new Random();
	        for(int i=len-1;i>=0;i--){
	            pos = ran.nextInt(i+1);
	            temp = q[pos];
	            q[pos] = q[i];
	            q[i] = temp;
	        }
	        return q;
	    }
	}
    /*最小栈
     *设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     *push(x) -- 将元素 x 推入栈中。
     *pop() -- 删除栈顶的元素。
     *top() -- 获取栈顶元素。
     *getMin() -- 检索栈中的最小元素。
     *MinStack minStack = new MinStack();
     *minStack.push(-2);
     *minStack.push(0);
     *minStack.push(-3);
     *minStack.getMin();   --> 返回 -3.
     *minStack.pop();
     *minStack.top();      --> 返回 0.\
     *minStack.getMin();   --> 返回 -2.
     * */
	public static class MinStack {
		private int initLength = 8;
		private int minLength = 8;
		private int[] stack = new int[initLength];
        private int[] stackMin = new int[minLength];
        private int stackIndex = -1;
        private int stackMinIndex = -1;
	    /** initialize your data structure here. */
	    public MinStack() {
	 	        
	    }
	    
	    public void push(int x) {
	    	  if(++stackIndex >= initLength) {
		        	//扩容
	    		    initLength = initLength<<1;
	    		    int[] arr = new int[initLength];
	    		    System.arraycopy(stack, 0, arr, 0, stack.length);
	    		    stack = arr;
		       }
		       stack[stackIndex] = x;
               if(stackMinIndex == -1) {
		    	   stackMin[++stackMinIndex] = x;
		    	   return;
		       }
	    	   if( x <= stackMin[stackMinIndex]) {
	    		   if(++stackMinIndex >= minLength) {
	    			  //扩容
	    			   minLength = minLength<<1;
		    		   int [] arr = new int[minLength];
		    		   System.arraycopy(stackMin, 0, arr, 0, stackMin.length);
		    		   stackMin = arr;
	    		   }
	    		   stackMin[stackMinIndex] = x;
	    	   }
	    		    
	    }
	    
	    public void pop() {
	    	if(stackIndex < 0)
	    		return;
	        if(stackMinIndex >=0 && stackMin[stackMinIndex] == stack[stackIndex])
	        	--stackMinIndex;
	        --stackIndex;
	    }
	    
	    public int top() {
            if(stackIndex >= 0)
                return stack[stackIndex];
             return 0;
	    }
	    
	    public int getMin() {
            if(stackMinIndex >=0)
	    	    return stackMin[stackMinIndex];
            else
                return stack[stackIndex];
	    }
	}
}
