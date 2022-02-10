package com.shockang.study.algorithm.java.leetcode.leetcode1301_1400.leetcode1314.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int[][] matrixBlockSum(int[][] mat, int K) {
		if (mat == null || mat.length == 0 || mat[0].length == 0) {
			return mat;
		}
		int[][] res = new int[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				res[i][j] = helper(mat, i, j, K);
			}
		}
		return res;
	}

	private int helper(int[][] mat, int x, int y, int K) {
		int res = 0;
		for (int i = Math.max(0, x - K); i <= Math.min(mat.length - 1, x + K); i++) {
			for (int j = Math.max(0, y - K); j <= Math.min(mat[0].length - 1, y + K); j++) {
				res += mat[i][j];
			}
		}
		return res;
	}
}
