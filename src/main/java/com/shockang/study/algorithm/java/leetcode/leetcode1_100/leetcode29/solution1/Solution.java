package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode29.solution1;

/**
 * 减法代替除法，O(logN)
 *
 * @author Shockang
 */
public class Solution {
	public int divide(int A, int B) {
		int sign = ((((A ^ B) >> 31) & 1) == 1) ? -1 : 1;
		long a = Math.abs((long) A), b = Math.abs((long) B), res = 0;
		while (a >= b) {
			long i = 1;
			long tmp = b;
			while (a >= tmp) {
				a -= tmp;
				res += i;
				i = i << 1;
				tmp = tmp << 1;
			}
		}
		res *= sign;
		if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int) res;
	}
}