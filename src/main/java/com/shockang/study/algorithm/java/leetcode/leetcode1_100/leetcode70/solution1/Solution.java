package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode70.solution1;

/**
 * 动态规划
 *
 * @author Shockang
 */
public class Solution {
	public int climbStairs(int n) {
		if (n == 1) return 1;
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < n; i++) dp[i] = dp[i - 1] + dp[i - 2];
		return dp[n - 1];
	}
}