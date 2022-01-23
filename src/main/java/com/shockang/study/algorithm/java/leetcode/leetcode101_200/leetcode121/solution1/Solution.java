package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode121.solution1;

/**
 * 比我小，那你就成为我，差值比我大，那最大利润就找到了~
 *
 * @author Shockang
 */
public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length == 1) return 0;
		int cur = prices[0], max = 0;
		for (int price : prices) {
			if (price < cur) {
				cur = price;
			}
			if (price - cur > max) {
				max = price - cur;
			}
		}
		return max;
	}
}