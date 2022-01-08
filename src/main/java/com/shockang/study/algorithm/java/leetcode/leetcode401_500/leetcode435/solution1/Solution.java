package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode435.solution1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Shockang
 */
public class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
		int n = intervals.length;
		int right = intervals[0][1];
		int ans = 1;
		for (int i = 1; i < n; ++i) {
			if (intervals[i][0] >= right) {
				++ans;
				right = intervals[i][1];
			}
		}
		return n - ans;
	}
}