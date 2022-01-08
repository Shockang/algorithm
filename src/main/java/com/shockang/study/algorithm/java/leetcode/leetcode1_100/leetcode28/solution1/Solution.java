package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode28.solution1;

/**
 * 暴力解法
 *
 * @author Shockang
 */
public class Solution {
	public int strStr(String haystack, String needle) {
		//i代表主串指针，j模式串
		int i, j;
		//主串长度和模式串长度
		int halen = haystack.length();
		int nelen = needle.length();
		//循环条件，这里只有 i 增长
		for (i = 0, j = 0; i < halen && j < nelen; ++i) {
			//相同时，则移动 j 指针
			if (haystack.charAt(i) == needle.charAt(j)) {
				++j;
			} else {
				//不匹配时，将 j 重新指向模式串的头部，将 i 本次匹配的开始位置的下一字符
				i -= j;
				j = 0;
			}
		}
		//查询成功时返回索引，查询失败时返回 -1；
		return j == nelen ? i - nelen : -1;
	}
}