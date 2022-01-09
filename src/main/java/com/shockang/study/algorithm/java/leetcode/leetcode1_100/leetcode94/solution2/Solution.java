package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode94.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 迭代
 *
 * @author Shockang
 */
public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
		return list;
	}
}
