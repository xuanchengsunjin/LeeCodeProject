package SortAndSerach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SecondaryAlgorithm {
	//二叉搜索树节点
	static class BSTNode{
		private int val ;
		private BSTNode left;
		private BSTNode right;
		private int count;
		void setLeftNode(BSTNode left){
			this.left = left;
		}
		void setRightNode(BSTNode right){
			this.right = right;
		}
		void addCount() {
			++count;
		}
		BSTNode(int val){
			this.val = val;
		}
	}
	/*最大数
	 *给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。 
	 *输入: [3,30,34,5,9]
	 *输出: 9534330
	 * */
	public String largestNumber(int[] nums) {
	     int len = nums.length;
	     int[] arrIndex = new int[len]; 
	  //   ArrayList<Integer> list = new ArrayList<Integer>();
	     for(int i = 0;i < len;++i) {
	    	 int number = nums[i];
	         if(number == 0)
	        	 arrIndex[i] = 1;
	    	 while(number > 0) {
	    		 ++arrIndex[i];
	    		// list.add(number % 10);
		    	 number = number / 10;
	    	 }
	     }
	     for(int i = 1;i < len;++i) {
	    	 int j;
	    	 int tem = nums[i];
	    	 int index_tem = arrIndex[i];
	    	 for(j = i;j > 0;--j) {
	    		 int diff = Math.abs(arrIndex[j-1] - index_tem);
	    		 int numA = tem;
	    		 int numB = nums[j-1];
	    		 if(arrIndex[j-1] - index_tem == 0) {		 
	    		 }else if(arrIndex[j-1] - index_tem >0) {
	    			 numB = (int) (nums[j-1] / Math.pow(10,diff));
	    		 }else {
	    			 numA = (int) (tem / Math.pow(10,diff));
	    		 }
	    		 //int numA = (int) (tem / Math.pow(10,diff));
	    		// int numB = (int) (nums[j-1] / Math.pow(10,diff));
	    		 if(numB > numA) {
	    			 nums[j] = nums[j - 1];
	    			 arrIndex[j] = arrIndex[j -1];
	    		 }else if(numB == numA) {
	    			 int a = (int) (tem*Math.pow(10,arrIndex[j-1]) + nums[j-1]);
	    			 int b = (int) (nums[j-1]*Math.pow(10,index_tem) + tem);
	    			 //System.out.println(a);
	    			// System.out.println(b);
	    			 if(a < b) {
	    				 nums[j] = nums[j - 1];
		    			 arrIndex[j] = arrIndex[j -1];
	    			 }else {
	    				 break;
	    			 }
	    		 }else {
	    			 break;
	    		 }
	    	 }
	    	 nums[j] = tem;
	    	 arrIndex[j] = index_tem;
	     }
	     String str = "";
	     if(nums[len -1] ==0)
	    	 return "0";
	     for(int i = len-1;i>=0;--i) {
	    	 str = str + nums[i];
	     }
	     return str;
	  }
	public String largestNumberImprove(int[] nums) {
        List<String> list=new ArrayList<>();
        for(int num:nums){
            list.add(num+"");
        }
        
        StringBuilder sb=new StringBuilder();
      
        Comparator<String> cmp=new Comparator<String>(){
           public int compare(String a, String b){
               String sum1=a+b;
               String sum2=b+a;
            return sum2.compareTo(sum1);
               
           } 
        };
        Collections.sort(list,cmp);
        for(String s:list){
            sb.append(s);
        }
        if(sb.charAt(0)=='0') return "0";
        return sb.toString();
    }
	/*寻找峰值
	 *峰值元素是指其值大于左右相邻值的元素。
	 *给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
	 *数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
	 *你可以假设 nums[-1] = nums[n] = -∞。
	 *
	 *输入: nums = [1,2,3,1]
	 *输出: 2
	 *解释: 3 是峰值元素，你的函数应该返回其索引 2。
	 *
	 *你的解法应该是 O(logN) 时间复杂度的。
	 * */
	public int findPeakElement(int[] nums) {
		int len = nums.length;
        int flag = 1;
        for(int i =1;i<len;++i) {
        	if(flag == 0 && nums[i] > nums[i-1]) {
        		flag = 1;
        	}else {
        		if(nums[i] < nums[i-1])
        			return i-1;
        		else if(nums[i] == nums[i-1])
        			flag=0;
        		else {} 			
        	}
        }
        if(flag == 1)
            return len -1;
        return -1;
    }
	//二分法
	public int findPeakElementImprove(int[] nums) {
	        int left = 0;
	        int right = nums.length - 1;
	        int mid = 0;
	        while(left < right){
	            mid = left + (right - left)/2;
	            if(mid == 0 && nums[mid] > nums[mid+1] || mid == nums.length - 1 && nums[mid] > nums[mid-1] || nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
	                return mid;
	            }
	            if(nums[mid] > nums[mid+1]){ // 左边肯定有峰值
	                right = mid;
	            }else{
	                left = mid + 1;
	            }
	        }
	        return left;
	}
	/*寻找重复数
	 *给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
	 *可知至少存在一个重复的整数。
	 *假设只有一个重复的整数，找出这个重复的数。 
	 *
	 *输入: [1,3,4,2,2]
	 *输出: 2
	 *
	 *不能更改原数组（假设数组是只读的）。
	 *只能使用额外的 O(1) 的空间。
	 *时间复杂度小于 O(n2) 。
	 *数组中只有一个重复的数字，但它可能不止重复出现一次。
	 * */
	public int findDuplicate(int[] nums) {
		  int len = nums.length;
	        int left = 1,right = len -1,mid = 0;
	        while(left < right) {
	        	mid = (left + right) / 2;
	        	int count = 0;
	        	for(int i =0;i<len;++i) {
	        		if(nums[i] <= mid)
	        			++count;
	        	}
	        	if(count  <= mid) {
	        		left = mid+1;
	        	}else {
	        		right = mid;
	        	}
	        }
	        return left;
    }
	//快慢指针
	 public int findDuplicateImrove(int[] nums) {
	        int fast = nums[0];
	        int slow = nums[0];
	        do{
	            fast = nums[nums[fast]];
	            slow = nums[slow];
	        }while(fast != slow);
	        fast = nums[0];
	        while(fast != slow){
	            fast = nums[fast];
	            slow = nums[slow];
	        }
	        return fast;
	    }
	/*计算右侧小于当前元素的个数
	 *给定一个整数数组 nums，按要求返回一个新数组 counts。
	 *数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
	 *
	 *输入: [5,2,6,1]
	 *输出: [2,1,1,0] 
	 *解释:
	 *5 的右侧有 2 个更小的元素 (2 和 1).
	 *2 的右侧仅有 1 个更小的元素 (1).
	 *6 的右侧有 1 个更小的元素 (1).
	 *1 的右侧有 0 个更小的元素.
	 * */
	 public List<Integer> countSmaller(int[] nums) {
		int len = nums.length;
		List<Integer> li = new ArrayList<Integer>(len);
		int[] arr = new int[len];
		for(int i = len-1;i>0;--i) {
			int num = nums[i];
			for(int j = i-1;j>=0;--j) {
				if(num < nums[j])
					++arr[j];
			}
		}
		for(int i = 0;i<len;++i)
			li.add(i,arr[i]);
	    return li;   
	 }
	 //二叉搜索树
	 public List<Integer> countSmallerImproveOne(int[] nums) {
			int len = nums.length;
			List<Integer> li = new ArrayList<Integer>(len);
			int[] arr = new int[len];
			BSTNode head = null;
			BSTNode pre = null;
		    for(int i = len-1;i>=0;--i) {
		    	int flag =0;
		    	int num = nums[i];
		    	BSTNode tem = head;   	
		    	if(tem == null) {
		    		arr[i] = 0; 
		    		head = new BSTNode(num);
		    		continue;
		    	}else {
		    		while(tem != null) {
		    			pre = tem;
		    			if(num > tem.val) {
		    				arr[i] += tem.count+1;
		    				tem = tem.right;
		    			}
		    			else {
		    				tem.addCount();
		    				if(num == tem.val) {
		    					flag =1;
		    					//if(tem.left != null)
		    					//	arr[i] += tem.count;
		    					//break;
		    				}	    				
		    				tem = tem.left;
		    			}
		    		}
		    		if(flag == 1)
			    			continue;
		    		if(num > pre.val) 
		    			pre.right = new BSTNode(num);
		    		else
		    			pre.left = new BSTNode(num);
		    	}		    	  	    
		    }
		    //printTree(head);
		    for(int i = 0;i<len;++i) {
		    	li.add(i,arr[i]);
		    	//System.out.println(arr[i]);
		    }		
		    return li;   
     }
	 //树状数组
	 public List<Integer> countSmallerImproveTwo(int[] nums){
		 List<Integer> li = new ArrayList<Integer>();
		 return li;
	 }
	 void printTree(BSTNode node) {
		 if(node == null)
			 return;
		 System.out.println(node.val+":" + node.count);
		 printTree(node.left);
		 printTree(node.right);
	 }
	void printArray(int[] arr) {
		System.out.println("打印数组如下：");
		for(int data:arr) {
			System.out.println(data);
		}
		System.out.println("打印结束");
	}
}
