package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode968.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * @author Shockang
 */
public class Solution {
	int res = 0;

	public int minCameraCover(TreeNode root) {
		return (dfs(root) < 1 ? 1 : 0) + res;
	}

	public int dfs(TreeNode root) {
		if (root == null) return 2;
		int left = dfs(root.left), right = dfs(root.right);
		if (left == 0 || right == 0) {
			res++;
			return 1;
		}
		return left == 1 || right == 1 ? 2 : 0;
	}
}