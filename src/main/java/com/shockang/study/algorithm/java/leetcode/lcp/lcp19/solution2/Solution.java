package com.shockang.study.algorithm.java.leetcode.lcp.lcp19.solution2;

/**
 * @author Shockang
 */
public class Solution {
	public int minimumOperations(String leaves) {
		int n = leaves.length();
		int g = leaves.charAt(0) == 'y' ? 1 : -1;
		int gmin = g;
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i < n; ++i) {
			int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
			g += 2 * isYellow - 1;
			if (i != n - 1) {
				ans = Math.min(ans, gmin - g);
			}
			gmin = Math.min(gmin, g);
		}
		return ans + (g + n) / 2;
	}
}