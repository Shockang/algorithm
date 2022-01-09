package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode102.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) return new ArrayList<>(0);
		List<List<Integer>> res = new ArrayList<>();
		helper(root, res, 0);
		return res;
	}

	private void helper(TreeNode node, List<List<Integer>> list, int level) {
		if (node == null) return;
		if (level < list.size()) {
			List<Integer> tmp = list.get(level);
			tmp.add(node.val);
		} else {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(node.val);
			list.add(tmp);
		}
		helper(node.left, list, level + 1);
		helper(node.right, list, level + 1);
	}
}
