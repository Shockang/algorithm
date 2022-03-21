package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode145.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode prev = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (root.right == null || root.right == prev) {
				list.add(root.val);
				prev = root;
				root = null;
			} else {
				stack.push(root);
				root = root.right;
			}
		}
		return list;
	}
}
