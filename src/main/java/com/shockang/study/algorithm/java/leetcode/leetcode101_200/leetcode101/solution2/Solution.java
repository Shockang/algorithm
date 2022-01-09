package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode101.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Shockang
 */
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		// ArrayDeque 不能 push null
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root.left);
		stack.push(root.right);
		while (!stack.isEmpty()) {
			TreeNode n1 = stack.pop(), n2 = stack.pop();
			if (n1 == null && n2 == null) {
				continue;
			}
			if (n1 == null || n2 == null || n1.val != n2.val) {
				return false;
			}
			stack.push(n1.left);
			stack.push(n2.right);
			stack.push(n1.right);
			stack.push(n2.left);
		}
		return true;
	}
}
