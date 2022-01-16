package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode746.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int minCostClimbingStairs(int[] cost) {
		int f0, f1 = 0, f2 = 0;
		for (int i = cost.length - 1; i >= 0; i--) {
			f0 = cost[i] + Math.min(f1, f2);
			f2 = f1;
			f1 = f0;
		}
		return Math.min(f1, f2);
	}
}