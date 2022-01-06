package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode309.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
		int n = prices.length;
		int f0 = -prices[0], f1 = 0, f2 = 0, F0 = 0, F1 = 0, F2 = 0;
		for (int i = 1; i < n; i++) {
			F0 = Math.max(f0, f2 - prices[i]);
			F1 = f0 + prices[i];
			F2 = Math.max(f1, f2);
			f0 = F0;
			f1 = F1;
			f2 = F2;
		}
		return Math.max(f1, f2);
	}
}