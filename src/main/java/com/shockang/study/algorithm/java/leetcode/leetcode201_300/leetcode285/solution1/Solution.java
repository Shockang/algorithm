package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode285.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈迭代中序遍历+flag
 *
 * @author Shockang
 */
public class Solution {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		boolean flag = false;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (flag) return root;
			if (root == p) flag = true;
			root = root.right;
		}
		return null;
	}
}