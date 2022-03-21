package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode174.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length, n = dungeon[0].length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		int health;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				health = Math.min(dp[i + 1][j], dp[i][j + 1]);
				if (i == m - 1 && j == n - 1) health = 1;
				dp[i][j] = Math.max(1, health - dungeon[i][j]);
			}
		}
		return dp[0][0];
	}
}