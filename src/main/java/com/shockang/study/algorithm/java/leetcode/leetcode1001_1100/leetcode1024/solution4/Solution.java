package com.shockang.study.algorithm.java.leetcode.leetcode1001_1100.leetcode1024.solution4;

import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public int videoStitching(int[][] clips, int time) {
		int[] dp = new int[time + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		for (int i = 1; i <= time; i++) {
			for (int[] clip : clips) {
				if (clip[0] < i && i <= clip[1]) {
					dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
				}
			}
		}
		return dp[time] == Integer.MAX_VALUE - 1 ? -1 : dp[time];
	}
}