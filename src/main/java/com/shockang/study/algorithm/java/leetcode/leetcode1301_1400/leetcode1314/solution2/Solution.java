package com.shockang.study.algorithm.java.leetcode.leetcode1301_1400.leetcode1314.solution2;

/**
 * 二维前缀和
 *
 * @author Shockang
 */
public class Solution {
	public int[][] matrixBlockSum(int[][] mat, int k) {
		int n = mat.length, m = mat[0].length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + mat[i - 1][j - 1] - dp[i - 1][j - 1];
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int x1 = i - k, y1 = j - k, x2 = i + k, y2 = j + k;
				if (x1 < 1) x1 = 1;
				if (y1 < 1) y1 = 1;
				if (x2 > n) x2 = n;
				if (y2 > m) y2 = m;
				mat[i - 1][j - 1] = dp[x2][y2] + dp[x1 - 1][y1 - 1] - dp[x1 - 1][y2] - dp[x2][y1 - 1];
			}
		}
		return mat;
	}
}