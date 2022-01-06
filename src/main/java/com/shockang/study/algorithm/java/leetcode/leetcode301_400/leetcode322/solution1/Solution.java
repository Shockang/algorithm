package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode322.solution1;

import java.util.Arrays;

/**
 * 动态规划
 *
 * @author Shockang
 */
public class Solution {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
}
