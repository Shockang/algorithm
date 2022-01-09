package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode107.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归 + list.add(0, x)
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		helper(list, root, 0);
		return list;
	}

	private void helper(List<List<Integer>> list, TreeNode node, int level) {
		if (node == null) {
			return;
		}
		if (list.size() > level) {
			list.get(list.size() - level - 1).add(node.val);
		} else {
			List<Integer> cur = new ArrayList<>();
			cur.add(node.val);
			list.add(0, cur);
		}
		helper(list, node.left, level + 1);
		helper(list, node.right, level + 1);
	}
}
