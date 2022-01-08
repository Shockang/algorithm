package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode542.solution3;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		// 初始化动态规划的数组，所有的距离值都设置为一个很大的数
		int[][] dist = new int[m][n];
		for (int i = 0; i < m; ++i) {
			Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
		}
		// 如果 (i, j) 的元素为 0，那么距离为 0
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == 0) {
					dist[i][j] = 0;
				}
			}
		}
		// 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i - 1 >= 0) {
					dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
				}
				if (j - 1 >= 0) {
					dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
				}
			}
		}
		// 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
		for (int i = m - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				if (i + 1 < m) {
					dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
				}
				if (j + 1 < n) {
					dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
				}
			}
		}
		return dist;
	}
}