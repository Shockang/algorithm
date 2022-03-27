package com.shockang.study.algorithm.java.leetcode.interview.interview_01_07.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return;
		int n = matrix.length;
		int[][] res = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = matrix[n - j - 1][i];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = res[i][j];
			}
		}
	}
}