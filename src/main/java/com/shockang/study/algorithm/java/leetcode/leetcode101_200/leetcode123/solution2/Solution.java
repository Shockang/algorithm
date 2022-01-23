package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode123.solution2;

/**
 * @author Shockang
 */
public class Solution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int buy1 = -prices[0], sell1 = 0;
		int buy2 = -prices[0], sell2 = 0;
		for (int i = 1; i < n; ++i) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;
	}
}