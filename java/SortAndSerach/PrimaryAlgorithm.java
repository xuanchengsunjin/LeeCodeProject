package SortAndSerach;

import java.util.Arrays;

public class PrimaryAlgorithm {
	/*合并有序数组
	 *给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
	 *说明:
	 *初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
	 *你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
	 *nums1 = [1,2,3,0,0,0], m = 3
	 *nums2 = [2,5,6],       n = 3
	 *输出: [1,2,2,3,5,6]
	 * */
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
		 if(nums1.length < m + n || n==0)
			 return;
		 for(int i = 0;i < m;i++) {
			 if(nums1[i] <= nums2[0])
				 continue;
			 else {
				 int temp = nums1[i];
				 nums1[i] = nums2[0];
				 nums2[0] = temp;
				 Arrays.sort(nums2);//建议用构建堆的方式
			 }
		 }
		 for(int j=m,i=0;j < m+n;j++,i++) {
			 nums1[j] = nums2[i];
		 }
	 }
	 //后入式
	 public void mergeImprove(int[] nums1, int m, int[] nums2, int n) {
	        int index = m + n - 1;
	        int indexA = m - 1;
	        int indexB = n - 1;
	        for (int i = index; i >= 0; i--) {
	            if (indexA == -1 || indexB == -1) {
	                break;
	            }
	            if (nums1[indexA] > nums2[indexB]) {
	                nums1[i] = nums1[indexA];
	                indexA--;
	            } else {
	                nums1[i] = nums2[indexB];
	                indexB--;
	            }   
	        }
	        while (indexB >= 0) {
	            nums1[indexB] = nums2[indexB];
	            indexB--;
	        }
	    }
	 /*第一个错误的版本
	  *你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
	  *由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
	  *假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
	  *你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
	  *实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
	  *
	  *给定 n = 5，并且 version = 4 是第一个错误的版本。
	  *调用 isBadVersion(3) -> false
	  *调用 isBadVersion(5) -> true
	  *调用 isBadVersion(4) -> true
	  *所以，4 是第一个错误的版本。
	  * */
	  boolean isBadVersion(int version) {
		  //有待开发........
		  return true;
	  }
	  public int firstBadVersion(int n) {
		  int low = 1;
		  int hight = n;
		  //相对于(hight+ low)/2,前者容易发生溢出
		  int middle = low + (hight - low)/2;
		  if(isBadVersion(low))
			  return low;
		  while(hight - low >1) {
			  if(isBadVersion(middle)) 
				  hight = middle;
			  else 
				  low = middle;
			  middle = low + (hight - low)/2;
		  }
		  return isBadVersion(low) ? low : hight;
	  }
	  //改进：更加简洁，效率更加高
	   public int firstBadVersionImprove(int n) {
	        int l = 1, r = n;
	        while(l <= r) {
	            int mid = l+(r-l) / 2;
	            if (isBadVersion(mid)) {	               
	                r = mid -1;
	            }
	            else
	                l = mid + 1;
	        }
	        return l;
	    }
}
