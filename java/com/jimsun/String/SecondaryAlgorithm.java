package com.jimsun.String;

import javax.swing.Spring;

public class SecondaryAlgorithm {
	/*最长回文子串
	 *给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
	 *示例 1：
	 *输入: "babad"
	 *输出: "bab"
	 *注意: "aba"也是一个有效答案。 
	 * */
	//动态规划
	public String longestPalindrome(String s) {
		int len = s.length();
		if(len == 0)
			return "";
		boolean[][] a = new boolean[len][len];
		int start=0;
		int end=0;
		for(int i=0;i<len;++i) {
			for(int j=i;j>=0;--j) {
				int differ = i - j;
				if(differ < 2) {
					a[i][j] = (s.charAt(i) == s.charAt(j));
				}else {
					a[i][j]=(s.charAt(i) == s.charAt(j) && a[i-1][j+1]);
				}
				
				if(a[i][j] && differ > (end - start)) {
					end = i;
					start = j;
				}
			}
		}
		//System.out.println(start);
		//System.out.println(end);
		return s.substring(start, end + 1);
	}
	//中心扩展法
	public String longestPalindromeAnother(String s) {
		int len = s.length();
		if(len == 0)
			return "";
		int maxStart =0;
		int maxEnd = 0;
		for(int i =0 ;i<len-1;++i) {
			int start = i-1;
			int end = i+1;
			while(start>=0 && end<len && s.charAt(start)==s.charAt(end)) {
					--start;
					++end;				
			}
			++start;--end;
			if(end - start > maxEnd - maxStart) {
				maxStart = start;
				maxEnd = end;
			}
			
			start = i;
			end = i+1;
			while(start>=0 && end<len && s.charAt(start)==s.charAt(end)) {
				--start;
				++end;				
		    }
		    ++start;--end;
		    if(end - start > maxEnd - maxStart) {
		    	maxStart = start;
		    	maxEnd = end;
		    }
			
		}
		return s.substring(maxStart, maxEnd + 1);
	} 
	//Manacher算法
}
