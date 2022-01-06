package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode363.solution1;

import java.util.TreeSet;

/**
 * @author Shockang
 */
public class Solution {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int res = Integer.MIN_VALUE, m = matrix.length, n = matrix[0].length;
		int[] columns;
		for (int i = 0; i < m; i++) {
			columns = new int[n];
			for (int j = i; j < m; j++) {
				for (int c = 0; c < n; c++) {
					columns[c] += matrix[j][c];
				}
				TreeSet<Integer> numSet = new TreeSet<>();
				numSet.add(0);
				int s = 0;
				for (int c : columns) {
					s += c;
					Integer ceil = numSet.ceiling(s - k);
					if (ceil != null) {
						res = Math.max(res, s - ceil);
					}
					numSet.add(s);
				}
			}
		}
		return res;
	}
}
