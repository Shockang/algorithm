package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode199.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	private List<Integer> list = new ArrayList<>();

	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) return list;
		helper(root, 0);
		return list;
	}

	private void helper(TreeNode node, int level) {
		if (node == null) return;
		if (level < list.size()) {
			list.set(level, node.val);
		} else {
			list.add(node.val);
		}
		helper(node.left, level + 1);
		helper(node.right, level + 1);
	}
}