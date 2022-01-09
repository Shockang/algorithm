package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode101.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * 递归
 *
 * @author Shockang
 */
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		return root == null || isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}
		if (left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}

}

