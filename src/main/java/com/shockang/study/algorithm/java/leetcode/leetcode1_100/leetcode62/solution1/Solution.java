package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode62.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int uniquePaths(int cols, int rows) {
		int[] cur = new int[cols];
		for (int i = 1; i < rows; i++)
			for (int j = 1; j < cols; j++)
				cur[j] += cur[j - 1] + 1;
		return cur[cols - 1] + 1;
	}
}