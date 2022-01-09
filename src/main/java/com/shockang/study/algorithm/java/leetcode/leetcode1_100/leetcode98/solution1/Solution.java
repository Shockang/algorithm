package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode98.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * 递归，long pre
 *
 * @author Shockang
 */
public class Solution {
	long pre = Long.MIN_VALUE; // 记录上一个节点的值，初始值为Long的最小值

	public boolean isValidBST(TreeNode root) {
		return inorder(root);
	}

	// 中序遍历
	private boolean inorder(TreeNode node) {
		if (node == null) return true;
		boolean l = inorder(node.left);
		if (node.val <= pre) return false;
		pre = node.val;
		return l && inorder(node.right);
	}
}
