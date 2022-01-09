package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode64.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[] dp = new int[n];
		dp[0] = grid[0][0];
		for(int j = 1; j < n; j++){
			dp[j] = dp[j - 1] + grid[0][j];
		}
		for(int i = 1; i < m; i++){
			for(int j = 0; j < n; j++){
				if(j == 0){
					dp[0] += grid[i][0];
				}else{
					dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
				}
			}
		}
		return dp[n - 1];
	}
}
