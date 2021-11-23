package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode6.solution1;

/**
 * 6. Z 字形变换
 * <p>
 * sb+几行+单次循环多长
 *
 * @author Shockang
 */
public class Solution {
	public String convert(String s, int numRows) {
		if (s == null || s.length() == 0 || numRows < 2) {
			return s;
		}
		StringBuilder result = new StringBuilder();
		int n = s.length();
		int cycleLength = 2 * numRows - 2;

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < n; j += cycleLength) {
				result.append(s.charAt(i + j));
				if (i != 0 && i != numRows - 1 && (j + cycleLength - i) < n) {
					result.append(s.charAt(j + cycleLength - i));
				}
			}
		}

		return result.toString();
	}
}
