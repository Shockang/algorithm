package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode144.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	private List<Integer> res = new ArrayList<>();

	public List<Integer> preorderTraversal(TreeNode root) {
		helper(root);
		return res;
	}

	private void helper(TreeNode node) {
		if (node == null) return;
		res.add(node.val);
		helper(node.left);
		helper(node.right);
	}
}