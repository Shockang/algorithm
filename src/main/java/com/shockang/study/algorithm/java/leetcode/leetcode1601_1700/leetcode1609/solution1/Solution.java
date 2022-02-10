package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1609.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Shockang
 */
public class Solution {
	public boolean isEvenOddTree(TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			int prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				int value = node.val;
				if (level % 2 == value % 2) {
					return false;
				}
				if ((level % 2 == 0 && value <= prev) || (level % 2 == 1 && value >= prev)) {
					return false;
				}
				prev = value;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			level++;
		}
		return true;
	}
}