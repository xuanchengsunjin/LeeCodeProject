package com.jimsun.MathProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimaryAlgorithm {
	/*计数质数
	 *统计所有小于非负整数 n 的质数的数量。
	 *输入: 10
	 *输出: 4
	 *解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
	 * */
     public int countPrimes(int n) {
    	 if(n <= 2)
    		 return 0;
    	 if(n <=4)
    		 return n-2;
         if(n == 5)
             return 2;
         if(n == 6)
             return 3;
    	 int number = 2;
    	 for(int i = 6;i-1 < n;i += 6){
    		 if(isPrime(i-1))
    			 ++number;
    		 if(i+1 <n && isPrime(i+1))
    			 ++number;
    	 }
    	 return number;
     }
     boolean isPrime(int n) {
    	 if(n == 2 || n == 3)
    		 return true;
    	 if(n%6 !=1 && n%6 !=5)
    		 return false;
    	 for(int i = 5;i <= (int)Math.sqrt(n);i+=6) {
    		 if(n % i == 0 || n  % (i+2) == 0)
    			 return false;
    	 }
    	 return true;
     }
     //埃拉托色尼筛法
     //素数的整数倍非素数
     public int countPrimesImprove(int n) {
    	 //空间换时间
    	boolean[] notPrimes = new boolean[n+1];
 		int count = 0;
 		for(int i=2; i<n; i++){
 			if(notPrimes[i])
 				continue;
 			count++;
 			// k*i（k<i）在之前被去掉了
 			for(long j=(long)i*i; j<n; j+=i){
 				notPrimes[(int) j] = true;
 			}
 		}
 		return count;
     }
     /*3的幂
      *给定一个整数，写一个函数来判断它是否是 3 的幂次方。
      * */
     public boolean isPowerOfThree(int n) {
         if(n <= 0)
        	 return false;
         int num = (int) (Math.log(Integer.MAX_VALUE)/Math.log(3));
         num = (int) Math.pow(3, num);
         if(num % n != 0)
        	 return false;
         return true;
     }
     public boolean isPowerOfThreeImprove(int n) {
         return n>0&&1162261467%n==0;
     }
     public boolean isPowerOfThreeSimple(int n) {
         //先尝试着用递归,大数字的时候会栈溢出
         /*
         if(n==1) return true;
         if(n%3==0) return isPowerOfThree(n/3);
         return false;
         */
         //用数学的方法
         return (Math.log10(n) / Math.log10(3)) % 1 == 0;
     }
     //迭代方式
     public boolean isPowerOfThreeOther(int n) {
         if (n < 1) {
             return false;
         }
         while (n > 1) {
             if (n % 3 != 0) {
                 return false;
             }
             n /= 3;
         }
         return true;
     }
     /*罗马数字转整数
      *罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
      *字符          数值
      *I             1
      *V             5
      *X             10
      *L             50
      *C             100
      *D             500
      *M             1000
      *通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例:
      *I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
      *X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
      *C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
      * */
     public int romanToInt(String s) {  	 
    	 int[] arr = new int[s.length()];
         for(int i = 0; i < arr.length;i++) 
        	 arr[i] = getNum(s.charAt(i));
         int num = 0;
         int pre = arr[0];
         int temp;
         for(int j = 1; j <arr.length;++j) {
        	 temp = arr[j];
        	 if(temp <= pre) {
        		 num +=pre;
        	 }else {
        		 num -= pre;
        	 } 
        	 pre = temp;
         }
         return num+pre; 
     }
     public int getNum(char c) {
    	 int num =0;
    	 switch(c) {
    	 case'I':
    		 num =1;
    		 break;
    	 case'V':
    		 num =5;
    		 break;
    	 case'X':
    		 num =10;
    		 break;
    	 case'L':
    		 num =50;
    		 break;
    	 case'C':
    		 num =100;
    		 break;
    	 case'D':
    		 num =500;
    		 break;
    	 case'M':
    		 num =1000;
    		 break; 
    	 } 
    	 return num;
     }
     //使用Map
     public int romanToIntOther(String s) {
         Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
      // I             1
      // V             5
      // X             10
      // L             50
      // C             100
      // D             500
      // M             1000
       hashMap.put('I', 1);
       hashMap.put('V', 5);
       hashMap.put('X', 10);
       hashMap.put('L', 50);
       hashMap.put('C', 100);
       hashMap.put('D', 500);
       hashMap.put('M', 1000);

       int sum = 0;
       char[] tmpArr = s.toCharArray();
       for (int i = tmpArr.length - 1; i >= 0; i--) {
           if ((i - 1) >= 0 && (hashMap.get(tmpArr[i]) > hashMap.get(tmpArr[i - 1]))) {
               sum = sum + hashMap.get(tmpArr[i]) - hashMap.get(tmpArr[i - 1]);
               i--;
           } else {
               sum += hashMap.get(tmpArr[i]);
           }
       }

       return sum;
      }
     /*FizzBuzz
      *写一个程序，输出从 1 到 n 数字的字符串表示。
      *1. 如果 n 是3的倍数，输出“Fizz”；
      *2. 如果 n 是5的倍数，输出“Buzz”；
      *3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
      * */
     public List<String> fizzBuzz(int n) {
    	 List<String> list = new ArrayList<String>(n);
    	 for(int i =1 ;i <= n;++i) {
    		 if(i % 3 == 0 && i % 5 == 0) {
    			 list.add("FizzBuzz");
    			 continue;
    		 }  			
    		 if(i % 3 == 0) {
    			 list.add("Fizz");
    			 continue;
    		 }
    			 
    		 if(i % 5 == 0) {
    			 list.add("Buzz");
    			 continue;
    		 }
    		 list.add(String.valueOf(i));
    	 }
    	 return list;
     }
}
