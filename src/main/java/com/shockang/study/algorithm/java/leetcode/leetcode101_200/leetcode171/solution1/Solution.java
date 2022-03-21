package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode171.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int titleToNumber(String columnTitle) {
		int res = 0;
		for (char c : columnTitle.toCharArray()) {
			res = res * 26 + (c - 'A' + 1);
		}
		return res;
	}
}