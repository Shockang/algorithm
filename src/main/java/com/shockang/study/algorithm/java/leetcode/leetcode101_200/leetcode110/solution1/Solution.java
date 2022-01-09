package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode110.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * ↓ 递归
 *
 * @author Shockang
 */
public class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
		}
	}

	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(height(root.left), height(root.right)) + 1;
		}
	}
}
