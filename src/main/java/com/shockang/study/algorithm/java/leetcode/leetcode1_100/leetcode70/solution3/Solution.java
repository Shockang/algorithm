package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode70.solution3;

/**
 * a = (b += a) - a
 *
 * @author Shockang
 */
public class Solution {
	public int climbStairs(int n) {
		int a = 1, b = 1;
		while (n-- > 0) a = (b += a) - a;
		return a;
	}
}