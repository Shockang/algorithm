package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode107.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.*;

/**
 * 迭代 + reverse
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int levelCount = queue.size();
			for (int i = 0; i < levelCount; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				level.add(node.val);
			}
			res.add(level);
		}
		Collections.reverse(res);
		return res;
	}
}