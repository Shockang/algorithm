package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode7.solution1;

/**
 * 7. 整数反转
 * <p>
 * 不分正负，两次判断，大于 7 小于-8
 *
 * @author Shockang
 */
public class Solution {
	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
				return 0;
			}
			if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			}
			res = res * 10 + pop;
		}
		return res;
	}
}
