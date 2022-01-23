package com.shockang.study.algorithm.java.leetcode.leetcode1101_1200.leetcode1140.solution1;

/**
 * 动态规划
 * https://leetcode-cn.com/problems/stone-game-ii/solution/java-dong-tai-gui-hua-qing-xi-yi-dong-17xing-by-lg/
 *
 * @author Shockang
 */
public class Solution {
	public int stoneGameII(int[] piles) {
		int n = piles.length, sum = 0;
		// dp[i][j]表示剩余[i : len - 1]堆时，M = j的情况下，先取的人能获得的最多石子数
		int[][] dp = new int[n][n + 1];
		for (int i = n - 1; i >= 0; i--) {
			sum += piles[i];
			for (int M = 1; M <= n; M++) {
				// i + 2M >= len, dp[i][M] = sum[i : len - 1], 剩下的堆数能够直接全部取走，那么最优的情况就是剩下的石子总和
				if (i + 2 * M >= n) {
					dp[i][M] = sum;
				} else {
					// i + 2M < len, dp[i][M] = max(dp[i][M], sum[i : len - 1] - dp[i + x][max(M, x)]),
					// 其中 1 <= x <= 2M，剩下的堆数不能全部取走，那么最优情况就是让下一个人取的更少。
					// 对于我所有的x取值，下一个人从x开始取起，M变为max(M, x)，所以下一个人能取dp[i + x][max(M, x)]，
					// 我最多能取sum[i : len - 1] - dp[i + x][max(M, x)]。
					for (int X = 1; X <= 2 * M; X++) {
						dp[i][M] = Math.max(dp[i][M], sum - dp[i + X][Math.max(M, X)]);
					}
				}
			}
		}
		return dp[0][1];
	}
}