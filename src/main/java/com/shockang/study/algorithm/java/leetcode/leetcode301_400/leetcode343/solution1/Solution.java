package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode343.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int integerBreak(int n) {
		if (n == 2 || n == 3) return n - 1;
		int i = 1;
		while (n > 4) {
			n -= 3;
			i *= 3;
		}
		return n * i;
	}
}