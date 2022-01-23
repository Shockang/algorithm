package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode111.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * DFS
 *
 * @author Shockang
 */
public class Solution {
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		if (left == 0 || right == 0) return left + right + 1;
		return Math.min(left, right) + 1;
	}
}