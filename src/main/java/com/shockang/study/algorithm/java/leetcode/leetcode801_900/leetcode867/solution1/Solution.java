package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode867.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int[][] transpose(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] transposed = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				transposed[j][i] = matrix[i][j];
			}
		}
		return transposed;
	}
}