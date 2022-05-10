package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode188.solution2;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public int maxProfit(int k, int[] prices) {
		if (prices.length == 0 || k == 0) return 0;
		int[] buy = new int[k];
		int[] sell = new int[k];
		Arrays.fill(buy, -prices[0]);
		for (int i = 1; i < prices.length; i++) {
			buy[0] = Math.max(buy[0], -prices[i]);
			sell[0] = Math.max(sell[0], buy[0] + prices[i]);
			for (int j = 1; j < k; j++) {
				buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
				sell[j] = Math.max(sell[j], buy[j] + prices[i]);
			}
		}
		return sell[k - 1];
	}
}