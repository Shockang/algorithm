package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode32.solution1;

/**
 * 动态规划+ 字符串中对应的索引为有效子串结尾的最长有效括号子串的长度
 *
 * @author Shockang
 */
public class Solution {
	public int longestValidParentheses(String s) {
		int max = 0;
		int[] dp = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}
}
