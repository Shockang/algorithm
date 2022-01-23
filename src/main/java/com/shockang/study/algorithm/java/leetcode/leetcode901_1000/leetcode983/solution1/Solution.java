package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode983.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[30];
		int d = 0; // d 代表下一次旅行的索引
		int pre = days[days.length - 1];
		for (int i = days[0]; i <= pre; i++) {
			if (i != days[d]) dp[i % 30] = dp[(i - 1) % 30];
			else {
				dp[i % 30] = Math.min(dp[(i - 1) % 30] + costs[0], Math.min(dp[Math.max(i - 7, 0) % 30] + costs[1], dp[Math.max(i - 30, 0) % 30] + costs[2]));
				d++;
			}
		}
		return dp[pre % 30];
	}
}