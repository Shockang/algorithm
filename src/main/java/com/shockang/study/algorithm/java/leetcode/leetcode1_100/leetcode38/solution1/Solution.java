package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode38.solution1;

/**
 * 递归+sb
 *
 * @author Shockang
 */
public class Solution {
	public String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String str = countAndSay(n - 1);
		char cur = str.charAt(0);
		int count = 0;
		StringBuilder sb = new StringBuilder(str.length());
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != cur) {
				sb.append(count).append(cur);
				cur = str.charAt(i);
				count = 0;
			}
			count++;
		}
		sb.append(count).append(cur);
		return sb.toString();
	}
}