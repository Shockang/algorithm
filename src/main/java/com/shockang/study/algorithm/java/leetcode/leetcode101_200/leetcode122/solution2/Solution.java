package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode122.solution2;

/**
 * @author Shockang
 */
public class Solution {
	public int maxProfit(int[] prices) {
		int res = 0, n = prices.length;
		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i - 1]) {
				res += prices[i] - prices[i - 1];
			}
		}
		return res;
	}
}
