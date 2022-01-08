package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode48.solution1;

/**
 * 先上下颠倒，再反斜杆翻转
 *
 * @author Shockang
 */
public class Solution {
	public void rotate(int[][] matrix) {
		int s = 0, e = matrix.length - 1;
		while (s < e) {
			int[] temp = matrix[s];
			matrix[s] = matrix[e];
			matrix[e] = temp;
			s++;
			e--;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}