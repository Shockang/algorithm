package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode104.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * 递归，DFS
 *
 * @author Shockang
 */
public class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
