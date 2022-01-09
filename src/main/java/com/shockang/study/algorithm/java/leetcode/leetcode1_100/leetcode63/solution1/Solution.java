package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode63.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1) return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					if (i > 0) dp[i][j] += dp[i - 1][j];
					if (j > 0) dp[i][j] += dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
