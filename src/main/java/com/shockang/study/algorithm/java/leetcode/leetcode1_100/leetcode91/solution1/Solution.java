package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode91.solution1;

/**
 * 动态规划
 *
 * @author Shockang
 */
public class Solution {
	public int numDecodings(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}
		int[] dp = new int[s.length() + 1];//长度为n时的排列组合种类
		dp[0] = dp[1] = 1;
		if (s.length() == 1) return dp[1];
		for (int i = 2; i <= s.length(); i++) {
			int cur = Integer.parseInt(String.valueOf(s.charAt(i - 1)));//得到当前数；
			int pre = Integer.parseInt(String.valueOf(s.charAt(i - 2)));//得到当前数的前一个数
			if (pre + cur == 0 || (cur == 0 && pre > 2)) {
				return 0;
			} else if (cur == 0 || pre == 0) {
				dp[i] = cur == 0 ? dp[i - 2] : dp[i - 1];
			} else {
				dp[i] = pre * 10 + cur > 26 ? dp[i - 1] : dp[i - 2] + dp[i - 1];
			}
		}
		return dp[s.length()];
	}
}
