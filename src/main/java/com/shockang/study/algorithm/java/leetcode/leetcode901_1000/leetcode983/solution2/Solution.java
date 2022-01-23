package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode983.solution2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	int[] costs;
	Integer[] memo;
	Set<Integer> daySet;

	public int mincostTickets(int[] days, int[] costs) {
		this.costs = costs;
		memo = new Integer[366];
		daySet = new HashSet<>();
		for (int d : days) {
			daySet.add(d);
		}
		return dp(1);
	}

	public int dp(int i) {
		if (i > 365) {
			return 0;
		}
		if (memo[i] != null) {
			return memo[i];
		}
		if (daySet.contains(i)) {
			memo[i] = Math.min(Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]), dp(i + 30) + costs[2]);
		} else {
			memo[i] = dp(i + 1);
		}
		return memo[i];
	}
}