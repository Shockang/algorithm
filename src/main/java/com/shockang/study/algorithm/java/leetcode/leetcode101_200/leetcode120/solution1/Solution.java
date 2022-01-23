
package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode120.solution1;

import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] dp = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
	}
}