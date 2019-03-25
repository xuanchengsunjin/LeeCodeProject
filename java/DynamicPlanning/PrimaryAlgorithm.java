package DynamicPlanning;
	
public class PrimaryAlgorithm {
	/*爬楼梯
	 *假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	 *每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	 *注意：给定 n 是一个正整数。
	 *输入： 3
	 *输出： 3
	 *解释： 有三种方法可以爬到楼顶。
	 *1.  1 阶 + 1 阶 + 1 阶
	 *2.  1 阶 + 2 阶
	 *3.  2 阶 + 1 阶
	 * */
	 //递归方式：
	 public int climbStairs(int n) {
		 if(n <= 0)
			 return 0;
		 if(n == 1)
			 return 1;
	     return  climbStairs(n-1) + climbStairs(n-2);
	 }
	 //迭代方式
	 public int climbStairsImprove(int n) {
         if(n == 0)
             return 0;
         if(n == 1)
             return 1;
         int[] arr = new int[n];
         arr[0] =1;
         arr[1] =2;
         for(int i = 2;i <n;i++){
             arr[i] = arr[i-1] + arr[i-2];                 
         }
        return arr[n-1];
    }
	/*买卖股票的最佳时机
	 *给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
	 *如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
	 *注意你不能在买入股票前卖出股票。
	 *输入: [7,1,5,3,6,4]
	 *输出: 5
	 *解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	 *注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。 
	 * */
	 public int maxProfit(int[] prices) {
		 int result = 0;
	        if( prices == null || prices.length == 0)
	            return 0;
	        int minbuy = prices[0];        
	        for(int i = 1;i< prices.length ;i++){
	            // 最小的购买，最大的卖
	            result = Math.max(result,prices[i] - minbuy);
	            minbuy = Math.min(minbuy,prices[i]);
	        }
	        return result; 
	 }
	 /*最大子序和
	  *给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
	  *示例:
	  *输入: [-2,1,-3,4,-1,2,1,-5,4],
	  *输出: 6
	  *解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
	  *
	  *进阶:
	  *如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
	  * */
	 //扫描法
	  public int maxSubArray(int[] nums) {	
		  if(nums.length == 1)
              return nums[0];
          int max = nums[0];//初始化最大值
		  int sum = max;//初始化累加和
		  for(int i = 1;i < nums.length;++i) {
              if(sum <= 0) {//若之前的累加和小于等于0则抛弃，重新开始
				  sum = 0;
			  }
			  sum += nums[i];
			  max = Math.max(max, sum);//记录最大值		 
		  }
		  return max;
	  }
	  //动态规划
	  public int maxSubArrayImprove(int[] nums) {
		  int length = nums.length;
		  if(length == 1)
			  return nums[0];
		  //arr索引index：以nums数组索引为index为结尾元素的最大累加和
		  int[] arr = new int[length];
		  arr[0] = nums[0];
		  int max = arr[0];
		  for(int i =1;i < length;i++) {
			  arr[i] = Math.max(nums[i],nums[i]+arr[i-1]);
			  if(arr[i] > max)
				  max = arr[i];
		  }
		  return max;
	  }
	  //优化上述的动态规划(减小空间复杂度),仅需要arr一个保存上一个以index为结尾的累加和
	  public int maxSubArrayImprovePlus(int[] nums) {
		  int length = nums.length;
		  if(length == 1)
			  return nums[0];
		  //arr表示上一个以index为结尾的累加和
		  int arr = nums[0];
		  int max = arr;
		  for(int i =1;i < length;i++) {
			  arr = Math.max(nums[i], nums[i] + arr);
			  if(arr > max)
				  max = arr;
		  }
		  return max;
	  }
	  /*打家劫舍
	   *你是一个专业的小偷，计划偷窃沿街的房屋。
	   *每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
	   *如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
	   *给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
	   *
	   *输入: [1,2,3,1]
	   *输出: 4
	   *解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
	   *偷窃到的最高金额 = 1 + 3 = 4 。
	   * */
	   //动态规划：
	   public int rob(int[] nums) {
          int length = nums.length;
          if(length == 0)
              return 0;
          if(length == 1)
        	  return nums[0];
          //arr数组的索引index表示偷到第index+1家的最大金额
          int[] arr = new int[length];
          arr[0] = nums[0];
          arr[1] = Math.max(nums[0], nums[1]);
          int max = Math.max(nums[0], nums[1]);
          for(int i=2;i < length;++i) {
        	  arr[i] = Math.max(nums[i]+arr[i-2], arr[i-1]);
        	  if(arr[i] > max)
        		  max = arr[i];
          }
          return max;
	   }
	   //改进:减小空间复杂度
	   public int robImprove(int[] nums) {
		   int length = nums.length;
		   if(length == 0)
	              return 0;
	          if(length == 1)
	        	  return nums[0];
	          int sumBefore = nums[0];
	          int sumNeighbor =Math.max(nums[0], nums[1]);
	          int max = Math.max(sumBefore,sumNeighbor);
	       for(int i=2;i < length;++i) {
	          int sumNow = Math.max(nums[i]+sumBefore, sumNeighbor);
	          if(sumNow > max)
	        	  max = sumNow;
	          sumBefore = sumNeighbor;
	          sumNeighbor = sumNow;
	       }
	       return max;  
	   }
	   //摘自LeeCode
	   public int robLeeCode(int[] nums) {
	        int rob = 0, notRob = 0, n = nums.length;
	        for(int i = 0; i < n; ++i){
	            int preRob = rob, preNotRob = notRob;
	            rob = preNotRob + nums[i];
	            notRob = Math.max(preRob, preNotRob);
	        }
	        return Math.max(rob, notRob);
	    }
}
