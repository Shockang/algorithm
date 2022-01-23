package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode111.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * BFS
 *
 * @author Shockang
 */
public class Solution {
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		int level = 1;
		while (!deque.isEmpty()) {
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = deque.poll();
				if (cur.right == null && cur.left == null) {
					return level;
				}
				if (cur.left != null) {
					deque.offer(cur.left);
				}
				if (cur.right != null) {
					deque.offer(cur.right);
				}
			}
			level++;
		}
		return level;
	}
}
