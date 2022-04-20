package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode806.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int[] numberOfLines(int[] widths, String s) {
		int rowCount = 1, rowWidth = 0, n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			int width = widths[c - 'a'];
			if (rowWidth + width > 100) {
				rowCount++;
				rowWidth = width;
				continue;
			}
			rowWidth += width;
		}
		return new int[]{rowCount, rowWidth};
	}
}