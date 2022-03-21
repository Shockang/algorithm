package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode139.solution2;

import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		boolean[] dp = new boolean[len];

		for (int i = 0; i < len; i++) {
			for (String word : wordDict) {
				if (word.length() <= i + 1 && s.substring(i - word.length() + 1, i + 1).equals(word)) {
					int index = i - word.length();
					if (index < 0) {
						dp[i] = true;
					} else {
						dp[i] = dp[index];
					}
					if (dp[i]) break;
				}
			}
		}

		return dp[len - 1];
	}
}