package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode714.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int maxProfit(int[] prices, int fee) {
		if (prices.length < 2) return 0;
		int n = prices.length, hold = -prices[0] - fee, notHold = 0;
		for (int i = 1; i < n; i++) {
			notHold = Math.max(notHold, hold + prices[i]);
			hold = Math.max(hold, notHold - prices[i] - fee);
		}
		return notHold;
	}
}