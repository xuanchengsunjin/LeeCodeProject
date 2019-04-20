package com.jimsun.Other;

public class PrimaryAlgorithm {
	/*盛最多水的容器
	 *给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
	 *在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
	 *找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
	 *说明：你不能倾斜容器，且 n 的值至少为 2。 
	 * */
	 public int maxArea(int[] height) {
		 int len = height.length;
		 int max = 0;
	     int tem = 0;
		 for(int i =0;i<len;++i) {
			 int j = len-1;
			 while(j>i){ 
                  tem = (j-i)*Math.min(height[i], height[j]);
			      if(tem > max)
				     max = tem;
			      if(height[j] == height[i])
	                     break;
                  --j;
             }
		 }
		 return max;
	 }
	 public int maxAreaImprove(int[] height) {
		 int len = height.length;
		 int l = 0;
		 int r = len -1;
		 int max = 0;
		 while(l < r) {
			 max = Math.max(max, Math.min(height[l], height[r])*(r-l));
			 if(height[l]<height[r])
				 ++l;
			 else
				 --r;
		 }
		 return max;
	 }
	 /*接雨水
	  *给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
	  *输入: [0,1,0,2,1,0,1,3,2,1,2,1]
	  *输出: 6
	  * */
	 public int trap(int[] height) {
		  int len = height.length;
		  if(len == 0)
	            return 0;
		  int sum = 0;
		  int max = height[0];
		  int maxIndex =0;
		  for(int i = 1;i<len;++i) {
			  if(height[i] > max) {
				  max = height[i];
				  maxIndex = i;
			  }
		  }
		  int a = height[0];
		  for(int i=1;i<maxIndex;++i) {
			  if(height[i]<a) {
				  sum += a - height[i];
			  }else {
				  a = height[i];
			  }
		  }
		  a = height[len-1];
		  for(int i=len-2;i>=maxIndex;--i) {
			  if(height[i]<a) {
				  sum += a - height[i];
			  }else {
				  a = height[i];
			  }
		  }
	      return sum;
	 }
}
