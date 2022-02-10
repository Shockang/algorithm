package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1611.solution1;

/**
 * 格雷码
 *
 * @author Shockang
 */
public class Solution {
	public int minimumOneBitOperations(int n) {
		int ans = 0;
		while (n != 0) {
			ans ^= n;
			n >>= 1;
		}
		return ans;
	}
}