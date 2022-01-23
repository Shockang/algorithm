package com.shockang.study.algorithm.java.leetcode.leetcode1201_1300.leetcode1221.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int balancedStringSplit(String s) {
		int sum = 0, res = 0;
		for (char c : s.toCharArray()) {
			if (sum == 0) ++res;
			sum += c == 'L' ? -1 : 1;
		}
		return res;
	}
}