package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode107.solution3;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 迭代 + list.add(0, x)
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> levelOrder = new LinkedList<>();
		if (root == null) return levelOrder;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				TreeNode left = node.left, right = node.right;
				if (left != null) {
					queue.offer(left);
				}
				if (right != null) {
					queue.offer(right);
				}
			}
			levelOrder.add(0, level);
		}
		return levelOrder;
	}
}