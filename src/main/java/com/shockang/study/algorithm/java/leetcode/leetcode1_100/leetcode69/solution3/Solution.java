package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode69.solution3;

/**
 * 牛顿迭代法
 *
 * @author Shockang
 */
public class Solution {
	public int mySqrt(int x) {
		if (x == 0) {
			return 0;
		}
		double C = x, x0 = x;
		while (true) {
			double xi = 0.5 * (x0 + C / x0);
			if (Math.abs(x0 - xi) < 1e-7) {
				break;
			}
			x0 = xi;
		}
		return (int) x0;
	}
}
