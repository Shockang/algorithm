package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode145.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	private List<Integer> res = new ArrayList<>();

	public List<Integer> postorderTraversal(TreeNode root) {
		helper(root);
		return res;
	}

	private void helper(TreeNode node) {
		if (node == null) return;
		helper(node.left);
		helper(node.right);
		res.add(node.val);
	}
}
