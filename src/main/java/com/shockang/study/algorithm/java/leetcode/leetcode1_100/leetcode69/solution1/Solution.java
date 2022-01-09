package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode69.solution1;

/**
 * 数学等价转换
 *
 * @author Shockang
 */
public class Solution {
	public int mySqrt(int x) {
		if (x == 0) return 0;
		int ans = (int) Math.exp(0.5 * Math.log(x));
		return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
	}
}
