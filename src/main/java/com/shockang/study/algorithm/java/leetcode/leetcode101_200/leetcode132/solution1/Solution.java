package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode132.solution1;

import java.util.stream.IntStream;

/**
 * @author Shockang
 */
public class Solution {
	public int minCut(String s) {
		// validate input
		if (s == null || s.length() <= 1) {
			return 0;
		}
		// dp
		int N = s.length();
		int[] dp = IntStream.range(0, N).toArray(); // initial value: dp[i] = i

		for (int mid = 1; mid < N; mid++) { // iterate through all chars as mid point of palindrome
			// CASE 1. odd len: center is at index mid, expand on both sides
			for (int start = mid, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end); start--, end++) {
				int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
				dp[end] = Math.min(dp[end], newCutAtEnd);
			}
			// CASE 2: even len: center is between [mid-1,mid], expand on both sides
			for (int start = mid - 1, end = mid; start >= 0 && end < N && s.charAt(start) == s.charAt(end); start--, end++) {
				int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
				dp[end] = Math.min(dp[end], newCutAtEnd);
			}
		}
		return dp[N - 1];
	}
}