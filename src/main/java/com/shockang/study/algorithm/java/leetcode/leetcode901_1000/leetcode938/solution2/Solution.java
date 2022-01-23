package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode938.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Shockang
 */
public class Solution {
	public int rangeSumBST(TreeNode root, int low, int high) {
		int sum = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node == null) {
				continue;
			}
			if (node.val > high) {
				q.offer(node.left);
			} else if (node.val < low) {
				q.offer(node.right);
			} else {
				sum += node.val;
				q.offer(node.left);
				q.offer(node.right);
			}
		}
		return sum;
	}
}