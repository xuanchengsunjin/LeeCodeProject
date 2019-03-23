package com.jimsun.String;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class PrimaryAlgorithm {
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
            //大写英文字母转化为小写英文，
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
    /*字符串转换整数 (atoi)
     *请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     *当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     *该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     *注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     *在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * */
     public int myAtoi(String str) {
    	 int num=0;
         int flag=0;
         for(int i = 0;i< str.length();i++) {
         	int number = str.charAt(i)-48;
         	if(flag > 0) {
         		if(number>=0 && number<=9) {
         			if(flag ==1 && (num >Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && number >= 7))){
         				return Integer.MAX_VALUE;
         			}else if(flag ==2 && (num >Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && number >= 8))) {
         				return Integer.MIN_VALUE;
         			}
         			num = num*10 +number;
         		}else {
         			if(num == 0)
         				return 0;
         			else
         				break;
         		}
         	}else {
         		if(number == -3)
         			flag = 2;
                 else if(number == -5)
                     flag=1;
         		else if(number>=0 && number<=9) {
         			num = number;
         			flag =1;
         		}else if(number == -16) {}	
         		else {
         			return 0;
         		}
         	}
         }
         if(flag == 2)
         	num = -num;
         return num;
     }
     public int myAtoiImprove(String str) {
         str=str.trim();
         if (str.isEmpty()) return 0; 
         int sign = 1;
         int base = 0;
         int i = 0;
         if(str.charAt(i)=='-'||str.charAt(i)=='+'){
             sign = str.charAt(i++)=='-'? -1:1;
         }
         while(i < str.length()&&str.charAt(i) <='9'&&str.charAt(i)>='0' ){
             if(base > Integer.MAX_VALUE/10||(base == Integer.MAX_VALUE/10 &&(str.charAt(i)-'0'>7))){
                 return (sign==1)? Integer.MAX_VALUE: Integer.MIN_VALUE;
             }
             base = base*10+(str.charAt(i++)-'0');
         }
         return base*sign;
      }
      /*
       *实现 strStr() 函数。
       *给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
       *如果不存在，则返回  -1。
       *输入: haystack = "hello", needle = "ll"
       *输出: 2
       * */
       public int strStr(String haystack, String needle) {
    	   if(needle.equals(""))
    		   return 0;
    	   
    	   return -1;
       }
       /*报数序列
        *报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
        *1.     1
        *2.     11
        *3.     21
        *4.     1211
        * 5.     111221
        * */
       public String countAndSay(int n) {
         Queue<Integer> que = new LinkedList<Integer>();
         que.add(1);
         int length = 1;
         int newLength = 0;
         while(--n>0) {	
        	 int num=1;
        	 int temp=que.poll();
        	 --length;
        	 while(length-->0) {
        		 int number = que.poll();
        		 if(number == temp) {
        			 num++;
        		 }else {
        			 que.add(num);
        			 que.add(temp);
        			 temp = number;
        			 num=1;
        			 newLength +=2;
        		 }
        	 }
        	 if(num != 0) {
        		 que.add(num);
    			 que.add(temp);
    			 newLength +=2;
        	 }
        	 length = newLength;
        	 newLength = 0;
         }
         String a ="";
         while(!que.isEmpty()) {
        	 a += que.poll();
         }
         return a;
       }
       public String countAndSayImprove(int n) {
           if (n < 1) {
               throw new IllegalArgumentException();
           }
           if (n == 1) {
               return "1";
           }
           String preData = countAndSay(n - 1);

           char[] arr = preData.toCharArray();

           char preChar = arr[0];
           int charCount = 1;

           StringBuilder sb = new StringBuilder();

           for (int i = 1; i < arr.length; i++) {
               if (arr[i] == preChar) {
                   charCount++;
               } else {
                   sb.append(charCount).append(preChar);
                   preChar = arr[i];
                   charCount = 1;
               }
           }
           sb.append(charCount).append(preChar);

           return sb.toString();
       }
}
