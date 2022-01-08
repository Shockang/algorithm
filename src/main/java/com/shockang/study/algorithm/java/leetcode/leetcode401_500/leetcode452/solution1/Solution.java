package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode452.solution1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Shockang
 */
public class Solution {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) return 0;
		Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
		int pos = points[0][1];
		int ans = 1;
		for (int[] balloon : points) {
			if (balloon[0] > pos) {
				pos = balloon[1];
				++ans;
			}
		}
		return ans;
	}
}
