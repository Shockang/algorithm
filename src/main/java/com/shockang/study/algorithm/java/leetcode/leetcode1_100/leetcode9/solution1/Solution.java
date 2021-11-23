package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode9.solution1;

/**
 * 9. 回文数
 * <p>
 * 中间折叠判断，x==rev||x==rev/10
 *
 * @author Shockang
 */
public class Solution {
	public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) return false;
		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return x == rev || x == rev / 10;
	}
}
