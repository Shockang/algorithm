package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode85.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 构造柱形图，求柱形图中最大的矩形
 *
 * @author Shockang
 */
public class Solution {
	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if (m == 0) return 0;
		int n = matrix[0].length;
		if (n == 0) return 0;
		int[][] heights = new int[m][n];
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && matrix[i][j] == '1') {
					heights[i][j] = 1;
				} else if (matrix[i][j] == '1') {
					heights[i][j] = heights[i - 1][j] + 1;
				} else {
					heights[i][j] = 0;
				}
			}
			max = Math.max(max, getMaxArea(heights[i], n));
		}
		return max;
	}

	private int getMaxArea(int[] heights, int n) {
		int[] h = new int[n + 2];
		System.arraycopy(heights, 0, h, 1, n);
		Deque<Integer> stack = new ArrayDeque<>();
		int max = 0;
		for (int i = 0; i < n + 2; i++) {
			while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
				int height = h[stack.pop()];
				int width = i - stack.peek() - 1;
				max = Math.max(max, width * height);
			}
			stack.push(i);
		}
		return max;
	}
}