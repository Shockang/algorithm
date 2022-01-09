package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode98.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈迭代+long pre
 *
 * @author Shockang
 */
public class Solution {
	private boolean flag = true;
	private long pre = Long.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		helper(root);
		return flag;
	}

	private void helper(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (root.val <= pre) {
				flag = false;
				break;
			}
			pre = root.val;
			root = root.right;
		}
	}
}

