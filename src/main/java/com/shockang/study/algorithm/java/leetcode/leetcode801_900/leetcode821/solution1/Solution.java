package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode821.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int[] shortestToChar(String s, char c) {
		int n = s.length();
		int[] ans = new int[n];

		for (int i = 0, idx = -n; i < n; ++i) {
			if (s.charAt(i) == c) {
				idx = i;
			}
			ans[i] = i - idx;
		}

		for (int i = n - 1, idx = 2 * n; i >= 0; --i) {
			if (s.charAt(i) == c) {
				idx = i;
			}
			ans[i] = Math.min(ans[i], idx - i);
		}
		return ans;
	}
}