package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode50.solution1;

/**
 * 递归+n/2
 *
 * @author Shockang
 */
public class Solution {
	public double myPow(double x, int n) {
		if (n == 0) return 1;
		if (n == Integer.MIN_VALUE) {
			x = x * x;
			n = n / 2;
		}
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
}