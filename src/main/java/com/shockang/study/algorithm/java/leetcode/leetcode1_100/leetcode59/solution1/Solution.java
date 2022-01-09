package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode59.solution1;

/**
 * →↓←↑
 *
 * @author Shockang
 */
public class Solution {
	public static int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];
		int left = 0, top = 0;
		int right = n - 1, down = n - 1;
		int count = 1;
		while (left <= right) {
			for (int j = left; j <= right; j++) {
				ret[top][j] = count++;
			}
			top++;
			for (int i = top; i <= down; i++) {
				ret[i][right] = count++;
			}
			right--;
			for (int j = right; j >= left; j--) {
				ret[down][j] = count++;
			}
			down--;
			for (int i = down; i >= top; i--) {
				ret[i][left] = count++;
			}
			left++;
		}
		return ret;
	}
}
