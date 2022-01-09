package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode103.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归+addList
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		helper(list, root, 0);
		return list;
	}

	private void helper(List<List<Integer>> list, TreeNode node, int level) {
		if (node == null) return;
		addList(list, node, level);
		helper(list, node.left, level + 1);
		helper(list, node.right, level + 1);
	}

	private void addList(List<List<Integer>> list, TreeNode node, int level) {
		List<Integer> cur;
		if (list.size() > level) cur = list.get(level);
		else {
			cur = new ArrayList<>();
			list.add(cur);
		}
		if (level % 2 == 1) cur.add(0, node.val);
		else cur.add(node.val);
	}
}


