package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode73.solution1;

import java.util.Arrays;

/**
 * first row + first col
 *
 * @author Shockang
 */
public class Solution {
	public void setZeroes(int[][] matrix) {
		boolean fr = false, fc = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) fr = true;
					if (j == 0) fc = true;
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (fr) {
			Arrays.fill(matrix[0], 0);
		}
		if (fc) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}