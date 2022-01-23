package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode867.solution2;

/**
 * @author Shockang
 */
public class Solution {
	public int[][] transpose(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] res = new int[n][m];

		for (int i = 0; i < m * n; i++) {
			res[i / m][i % m] = matrix[i % m][i / m];
		}

		return res;
	}
}