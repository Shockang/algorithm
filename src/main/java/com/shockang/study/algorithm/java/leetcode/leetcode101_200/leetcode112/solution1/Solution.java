package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode112.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * DFS
 *
 * @author Shockang
 */
public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		if (sum - root.val == 0 && root.left == null && root.right == null) return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}