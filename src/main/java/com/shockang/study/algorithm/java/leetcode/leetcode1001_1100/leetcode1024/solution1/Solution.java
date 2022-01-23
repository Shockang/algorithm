package com.shockang.study.algorithm.java.leetcode.leetcode1001_1100.leetcode1024.solution1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Shockang
 */
public class Solution {
	public int videoStitching(int[][] clips, int T) {
		Arrays.sort(clips, Comparator.comparingInt(a -> a[0]));
		int[] dp = new int[T + 1];
		Arrays.fill(dp, 101);
		dp[0] = 0;
		int start, end;
		for (int i = 0; i < clips.length; i++) {
			start = clips[i][0];
			end = clips[i][1];
			if (start > T) {
				continue;
			}
			end = Math.min(end, T);
			for (int j = start + 1; j <= end; j++) {
				dp[j] = Math.min(dp[j], dp[start] + 1);
			}
		}
		return dp[T] == 101 ? -1 : dp[T];
	}
}