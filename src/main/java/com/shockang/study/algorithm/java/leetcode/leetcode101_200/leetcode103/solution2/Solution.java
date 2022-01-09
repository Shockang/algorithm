package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode103.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 递归+LinkedList
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
		if (node == null) {
			return;
		}
		if (level < list.size()) {
			if (level % 2 == 0) {
				((LinkedList) list.get(level)).addLast(node.val);
			} else {
				((LinkedList) list.get(level)).addFirst(node.val);
			}
		} else {
			LinkedList<Integer> tmp = new LinkedList<>();
			tmp.add(node.val);
			list.add(tmp);
		}
		helper(list, node.left, level + 1);
		helper(list, node.right, level + 1);
	}
}
