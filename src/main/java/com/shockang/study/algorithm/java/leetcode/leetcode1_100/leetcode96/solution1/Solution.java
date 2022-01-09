package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode96.solution1;

/**
 * 动态规划
 *
 * @author Shockang
 */
public class Solution {
	public int numTrees(int n) {
		// G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
		int[] G = new int[n + 1];
		G[0] = G[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				G[i] += G[j - 1] * G[i - j];
			}
		}
		return G[n];
	}
}
