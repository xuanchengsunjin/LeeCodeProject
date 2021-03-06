package com.jimsun.Array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import javax.management.Query;
import javax.print.attribute.SetOfIntegerSyntax;

public class PrimaryAlgorithm {
	/*
 	给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    返回新的长度。
    空间复杂度：O(1)
	*/
	public int removeDuplicates(int[] nums) {
		int index=0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i] != nums[index]) {
				nums[++index]=nums[i];
			}
		}
		return ++index;
	}
	/*
	 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
	 * 输入: [1,2,3,4,5,6,7] 和 k = 3
	 * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 空间复杂度：O(1)
	 * */
	 public void rotate(int[] nums, int k) {
		 int length = nums.length;
		 while(k-->0) { 
			 int j=length-1;
			 int temp = nums[j];
			 while(j>0) {
				 nums[j]=nums[--j];
			 }
			 nums[0]=temp;
		 }
	 }
	 /*
	  *给定一个整数数组，判断是否存在重复元素。
      *如果任何值在数组中出现至少两次，函数返回 true。
      *如果数组中每个元素都不相同，则返回 false。 */ 
	  public boolean containsDuplicate(int[] nums) {
		   if(nums.length ==0)
               return false;
		    Set<Integer> set = new TreeSet<Integer>();
		    set.add(nums[0]);
		    for(int i=1;i<nums.length;i++) {
		    	if(!set.add(nums[i])) {
		    		return true;
		    	}    	
		    }
		    return false;
	  }
	  /*
	   *给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
       *最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
       *你可以假设除了整数 0 之外，这个整数不会以零开头。
       *输入: [1,2,3]
       *输出: [1,2,4]
       *解释: 输入数组表示数字 123。*/
	  public int[] plusOne(int[] digits) {
	        int length = digits.length;
	        int add=1;
	        for(int i=length-1;i>=0;i--) {
	        	int temp=digits[i]+add;
	        	add = temp/10;
	        	digits[i]=temp%10;
	        	if(add>0) {
	        		continue;
	        	}
	        	break;
	        }
	        
	        if(add>0) {
	        	int[] a = new int[length+1];
	        	a[0]= add;
	        	for(int i=0;i<length;i++) {
	        		a[i+1] = digits[i];
	        	}
	        	digits=a;
	        }
	        return digits;
	  }
	  /*
	   * 移动零
	   * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	   * */
	   public void moveZeroes(int[] nums) {
	       int index=0;
	       for(int i=0;i<nums.length;i++) {
	    	   if(nums[i] != 0) {
	    		   nums[index++] = nums[i];
	    	   }
	       }
	       for(int j=index;j<nums.length;j++) {
	    	   nums[j]=0;
	       }        
	   }
	   /*
	    * 两数之和
	    * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
	    * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	    * 给定 nums = [2, 7, 11, 15], target = 9
	    * 因为 nums[0] + nums[1] = 2 + 7 = 9
	    * 所以返回 [0, 1]
	    * */
	    public int[] twoSum(int[] nums, int target) {
	    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    	map.put(target - nums[0], 0);
	    	for(int i=1;i<nums.length;i++) {
	    		if(map.containsKey(nums[i])) {
	    			return new int[] {map.get(nums[i]),i};
	    		}
	    		map.put(target - nums[i], i);
	    	}
	        return null;  
	    }
	    public int[] twoSumImprove(int[] nums, int target) {
	    	int[] arr = new int[2];
	    	int length = nums.length;
	    	//拷贝数组
 	    	int[] copyArr = new int[length];
 	    	System.arraycopy(nums,0, copyArr, 0 , length);
 	    	//排序
 	    	Arrays.sort(nums);
 	    	//i和j同时寻址
	    	for(int i=0,j=length-1;i != j;) {
	    		if(nums[i]+nums[j] == target) {
	    			int fromNumber = nums[i];
	    			int toNumber = nums[j];
	    			for(int a=0,flag = 0; a<length ;a++) {
	    	    		if(copyArr[a] == fromNumber && flag !=1) {
	    	    			arr[0] = a;
	    	    			if(flag != 0)
	    	    			   return arr;
	    	    		    flag = 1;
	    	    		}else if(copyArr[a] == toNumber && flag !=2) {
	    	    			arr[1] = a;
	    	    			if(flag != 0)
	    	    			   return arr;
	    	    		    flag = 2;
	    	    		}
	    	    	}
	    			break;
	    		}else if(nums[i]+nums[j] > target) {
	    			j--;
	    		}else {
	    			i++;
	    		}
	    	}  	
	        return null;  
	    }
	    public int[] twoSumImprovePlus(int[] nums, int target) {
	    	int size = 2048;
	    	int[] map = new int[size];
	    	int length = 2047;
	    	int index;
	    	for (int i = 0; i < nums.length; i++) {
				index = nums[i]&length; 
				if (map[index] != 0) {
					return new int[] { map[index] - 1, i };
				} else {
					map[(target - index)&length ] = i + 1;
				}
			}
			throw new IllegalArgumentException("No two sum solution");
	    }
        /*
         * 旋转图像
         * 给定一个 n × n 的二维矩阵表示一个图像。
         * 将图像顺时针旋转 90 度。
         * */
	    public void rotate(int[][] matrix) {
	        int length = matrix.length-1;
	        for(int i=0,j=0,k=length,q=length; i<k && j<q; ++i,++j,--k,--q) {
	        	for(int a = 0;a<k-i;a++) {
	        		int temp = matrix[i][j+a];
	        		matrix[i][j+a] = matrix[k-a][j];
	        		matrix[k-a][j] = matrix[k][q-a];
	        		matrix[k][q-a] = matrix[i+a][q];
	        		matrix[i+a][q] = temp;
	        	}
	        }
	    }
	    public void rotateImprove(int[][] matrix) {
	        int n = matrix.length;
	        float translate = (n - 1) / 2.0f;
	        int last;
	        int col, row;
//	        剥洋葱
	        for (int i = 0; i < n / 2; i++) { // 圈
	            for (int j = i; j < n - i - 1; j++) { // 边
	                last = matrix[i][j];
	                row = i;
	                col = j;
	                for (int k = 0; k < 3; k++) { // 点
//	                    pre_point
	                    int pre_col = row;
	                    int pre_row = (int) (2 * translate - col);

	                    matrix[row][col] = matrix[pre_row][pre_col];
	                    row = pre_row;
	                    col = pre_col;
	                }
	                matrix[row][col] = last;
	            }
	        }
	    }
	    /*
	     * 只出现一次的数字
	     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
	     * 输入: [2,2,1]
	     * 输出: 1
	     * */
	    public int singleNumber(int[] nums) {
	        int num = 0;
	        Arrays.sort(nums);
	        //所有奇数和减去偶数和,即........(求差法)
	        for(int i = 0;i<nums.length;i++){
	            num = i%2 == 0 ? num + nums[i]: num - nums[i];
	        }
	       return num;
	    }
	    //异或法
	    public int singleNumberImprove(int[] nums) {
	    	 int num = 0;
	         for (int i = 0; i < nums.length; i++) {
	                 num = num ^ nums[i];
	         }
	         return num;
	    }
	    /*两个数组的交集II
	     *给定两个数组，编写一个函数来计算它们的交集。
	     *示例 1:
	     *输入: nums1 = [1,2,2,1], nums2 = [2,2]
	     *输出: [2,2] 
	     *说明：
	     *输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
	     *我们可以不考虑输出结果的顺序。
	     *
	     *进阶:
	     *如果给定的数组已经排好序呢？你将如何优化你的算法？
	     *如果 nums1 的大小比 nums2 小很多，哪种方法更优？
	     *如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
	     * */
	    //排序再比较：循环次数：nums1.length + nums2.length
	    public int[] intersect(int[] nums1, int[] nums2) {
	        if(nums1.length == 0 || nums2.length  == 0)
	            return nums1.length == 0 ? nums1 :nums2;
		    Arrays.sort(nums1);
		    Arrays.sort(nums2);
		    List<Integer> list = new ArrayList<Integer>();
		    int length = 0;
		 
		    for(int i = 0,j = 0;i<nums1.length && j<nums2.length;) {
		    	if(nums1[i] < nums2[j])
		    		++i;
		    	else if(nums1[i] > nums2[j])
		    		++j;
		    	else {
		    		list.add(nums1[i]);
		    	    ++length;
		    	    ++i;
		    	    ++j;
		    	}
		    }
		    int[] a = new int[length];
		    int index=-1;
		    while(++index<length) {
		        a[index] = list.get(index);
		    }
		    return a;
	    }
	    public int[] intersectImprove(int[] nums1, int[] nums2) {
	        if (nums1.length > nums2.length) {
	            return intersect(nums2, nums1);
	        }
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        int nums[] = new int[nums1.length];
	        int len = 0;
	        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
	            if (nums1[i] == nums2[j]) {
	                nums[len++] = nums1[i];
	                ++i;
	                ++j;
	            } else if (nums1[i] < nums2[j]) {
	                i++;
	            } else {
	                j++;
	            }
	        }
	        int num[] = new int[len];
	        System.arraycopy(nums, 0, num, 0, len);
	        return num;
	    }
	    //使用map:
	    public int[] intersectMap(int[] nums1, int[] nums2) {
	        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
	        for (Integer num : nums1)
	            if (map1.containsKey(num))
	                 map1.replace(num, map1.get(num) + 1);
	            else
	            map1.put(num, 1);

	        ArrayList<Integer> intersection = new ArrayList<Integer>(16);
	        for (Integer num : nums2) {
	             if (map1.containsKey(num) && map1.get(num) > 0) {
	                  intersection.add(num);
	              map1.replace(num, map1.get(num) - 1);
	              }
	        }

	        int[] ret = new int[intersection.size()];
	        for (int i = 0; i < intersection.size(); i++)
	            ret[i] = intersection.get(i);
	        return ret;
	    }
	    //暴力：
	    public int[] intersectViolent(int[] nums1, int[] nums2) {
	        int numllength =  nums1.length;
	        int num2length =  nums2.length;
	        int num3length =numllength>num2length?num2length:numllength;
	        num3length = 0;
	        int[] tmp1 =null;
	        int[] tmp2 =null;
	        if(numllength>num2length){
	            tmp1=nums2;
	            tmp2=nums1;
	        }else{
	             tmp1=nums1;
	            tmp2=nums2;
	        };
	       for(int i=0; i<tmp1.length;i++){
	           for(int y=num3length; y<tmp2.length;y++){
	               if(tmp1[i]==tmp2[y]){
	                   int tmp3 =tmp2[num3length];
	                   tmp2[num3length]=tmp2[y];
	                   tmp2[y]=tmp3;
	                   num3length++;
	                   break;
	               }    
	           }
	           
	       }
	        
	       int[] num4 = new int[num3length];
	        for(int i =0 ; i<num3length;i++){
	            num4[i]=tmp2[i];
	        }	        
	        return num4;	        
	    }
	    
}
