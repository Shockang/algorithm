package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode110.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * ↑ 递归
 *
 * @author Shockang
 */
public class Solution {
	public boolean isBalanced(TreeNode root) {
		return height(root) >= 0;
	}

	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
