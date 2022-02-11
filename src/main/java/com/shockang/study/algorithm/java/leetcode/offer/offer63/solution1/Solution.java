package com.shockang.study.algorithm.java.leetcode.offer.offer63.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int maxProfit(int[] prices) {
		int cost = Integer.MAX_VALUE, profit = 0;
		for (int price : prices) {
			cost = Math.min(cost, price);
			profit = Math.max(profit, price - cost);
		}
		return profit;
	}
}