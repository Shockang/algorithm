package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode172.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int trailingZeroes(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}
}