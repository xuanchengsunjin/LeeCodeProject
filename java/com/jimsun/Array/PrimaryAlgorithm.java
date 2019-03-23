package com.jimsun.Array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
	    /*反转字符串
	     *编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
	     *不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
	     *你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
	     * */   
	    public void reverseString(char[] s) {
	        	if(s.length == 0)
	        		return;
	            for(int start = 0,end = s.length-1;start<end;++start,--end) {
	            	char temp = s[start];
	            	s[start] = s[end];
	            	s[end] = temp;
	            }
	    }
	    /*整数反转
	     *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
	     *输入: 123
	     *输出: 321
	     * */
	    public int reverse(int x) {
	        Stack<Integer> stack = new Stack<Integer>();
	        int a = 0;
	        if(x < 0)
	        	a  = -x;
	        else 
	        	a =x;
	        long num = 0;
	        while(a>0) {
	        	stack.push(a%10);
	        	a = a/10;
	        }
	        long b=1;
	        while(!stack.isEmpty()) {
	        	num += b*stack.pop();
	        	b *=10;
	        }
	        if(x < 0) {
	        	num = -num;
	        }
	        if(num <= Integer.MIN_VALUE || num >= Integer.MAX_VALUE)	
	        	return 0;
	        return (int) num;
	    }
	    public int reverseImprove(int x) {
	    	int num=0;
	    	while(x != 0) {
	    		int pop = x%10;
	    		if(num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && pop >7))
	    			return 0;
	    		if(num < Integer.MIN_VALUE/10 || (num == Integer.MIN_VALUE/10 && pop <-8))
	    			return 0;
	    		num = num*10 + pop;
	    		x /=10;
	    	}
		    return  num;
	    }
	    /*字符串中的第一个唯一字符
	     *给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
	     *s = "leetcode"
	     *返回 0
	     * */
	    public int firstUniqChar(String s) {
	    	char[] arr = s.toCharArray();
	    	Set<Character> setA = new HashSet<Character>();
	    	Set<Character> setB = new HashSet<Character>();
	    	for(int i = 0;i < arr.length;i++) {
	           if(setA.contains(arr[i])) {
	        	   setB.add(arr[i]);
	        	   continue;
	           }
	           setA.add(arr[i]);
	    	}
	    	for(int i = 0;i < arr.length;i++) {
	    		if(!setB.contains(arr[i]))
	    			return i;
	    	}
	        return -1;
	    }
	    public int firstUniqCharImprove(String s) {
	    	char[] charArr = s.toCharArray();
	    	int [] arr = new int[26];
	    	for(int i=0;i<charArr.length;i++) {
	    		arr[charArr[i]-'a']++;
	    	}
	    	for(int i=0;i<charArr.length;i++) {
	    		if(arr[charArr[i]-'a'] ==1)
	    			return i;
	    	}
	    	return -1;
	    }
	    /*有效的字母异位词
	     *给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
	     *输入: s = "anagram", t = "nagaram"
	     *输出: true
	     * */
	    public boolean isAnagram(String s, String t) {
	    	if(s.length() != t.length())
	    		return false;
	    	int[] sumA = new int[26];
	    	int[] sumB = new int[26];
	    	for(int i=0;i<s.length();i++) {
	    		sumA[s.charAt(i) - 'a']++;
	    		sumB[t.charAt(i) - 'a']++;
	    	}
	    	for(int j = 0;j < 26;j++) {
	    		if(sumA[j] != sumB[j])
	    			return false;
	    	}
	        return true;
	    }
	    public boolean isAnagramImprove(String s, String t) {
	    	if(s.length() != t.length())
	    		return false;
	    	int[] sumA = new int[26];
	    	for(int i=0;i<s.length();i++) {
	    		sumA[s.charAt(i) - 'a']++;
	    		sumA[t.charAt(i) - 'a']--;
	    	}
	    	for(int j = 0;j < 26;j++) {
	    		if(sumA[j] !=0)
	    			return false;
	    	}
	    	return true;
	    }
	    /*验证回文字符串 
	     *给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	     *说明：本题中，我们将空字符串定义为有效的回文串。
	     *输入: "A man, a plan, a canal: Panama"
	     *输出: true
	     **/
	    public boolean isPalindrome(String s) {
	    	if(s == "")
	    		return true;
	    	char[] a = s.toCharArray();
 	    	for(int i = 0,j = s.length()-1;i < j;i++,j--) {
	            while(!((a[i]>=65&&a[i]<=90)||(a[i]>=97&&a[i]<=122)||(a[i]>=48&&a[i]<=57)) && i<j)
	    			i++;
	            while(!((a[j]>=65&&a[j]<=90)||(a[j]>=97&&a[j]<=122)||(a[j]>=48&&a[j]<=57)) && i<j)
	    			j--;
	    		int difference = a[i] - a[j];
	    		if(difference !=0) {
	    			if((difference == 32 || difference == -32) && a[i] >= 65 && a[j] >= 65 )
	    				continue;
	    			else
	    				return false;
	    		}
	    	}
	        return true;
	    }
	    public boolean isPalindromeImprove(String s) {
	        int low = 0;
	        int high = s.length() - 1;
	        for (; ; ) {
	            if (low >= high) {
	                return true;
	            }
	            int start = (int) s.charAt(low);
	            if (start >= 65 && start <= 90) {
	                start += 32;
	            }
	            if ((start >= 97 && start <= 122) || (start >= 48 && start <= 57)) {
	                int end = (int) s.charAt(high);
	                if (end >= 65 && end <= 90) {
	                    end += 32;
	                }
	                if ((end >= 97 && end <= 122) || (end >= 48 && end <= 57)) {
	                    if (start != end) {
	                        return false;
	                    } else {
	                        low++;
	                        high--;
	                    }
	                } else {
	                    high--;
	                }
	            } else {
	                low++;
	            }
	        }
	 
	    }
}
