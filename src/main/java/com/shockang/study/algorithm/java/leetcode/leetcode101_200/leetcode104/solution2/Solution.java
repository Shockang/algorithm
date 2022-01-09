package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode104.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 迭代，BFS
 *
 * @author Shockang
 */
public class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int ans = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				size--;
			}
			ans++;
		}
		return ans;
	}
}
