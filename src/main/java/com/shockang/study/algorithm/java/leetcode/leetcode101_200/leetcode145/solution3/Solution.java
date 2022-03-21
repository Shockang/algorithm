package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode145.solution3;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author Shockang
 */
public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				list.add(root.val);
				stack.push(root);
				root = root.right;
			}
			root = stack.pop().left;
		}
		Collections.reverse(list);
		return list;
	}
}
