package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode518.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] += dp[i - coin];
			}
		}
		return dp[amount];
	}
}
