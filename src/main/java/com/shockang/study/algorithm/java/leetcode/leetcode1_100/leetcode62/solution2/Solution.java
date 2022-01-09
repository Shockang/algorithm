package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode62.solution2;

/**
 * @author Shockang
 */
public class Solution {
	public int uniquePaths(int m, int n) {
		long ans = 1;
		for (int x = n, y = 1; y < m; ++x, ++y) {
			ans = ans * x / y;
		}
		return (int) ans;
	}
}