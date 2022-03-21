package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode144.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				list.add(root.val);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop().right;
		}
		return list;
	}
}