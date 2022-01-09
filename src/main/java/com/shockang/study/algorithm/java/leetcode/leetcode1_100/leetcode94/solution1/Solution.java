package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode94.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 *
 * @author Shockang
 */
public class Solution {
	private List<Integer> res = new ArrayList<>();

	public List<Integer> inorderTraversal(TreeNode root) {
		helper(root);
		return res;
	}

	private void helper(TreeNode node) {
		if (node == null) return;
		helper(node.left);
		res.add(node.val);
		helper(node.right);
	}
}
