package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode129.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Shockang
 */
public class Solution {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Queue<Integer> numQueue = new LinkedList<>();
		nodeQueue.offer(root);
		numQueue.offer(root.val);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.poll();
			int num = numQueue.poll();
			TreeNode left = node.left, right = node.right;
			if (left == null && right == null) {
				sum += num;
			} else {
				if (left != null) {
					nodeQueue.offer(left);
					numQueue.offer(num * 10 + left.val);
				}
				if (right != null) {
					nodeQueue.offer(right);
					numQueue.offer(num * 10 + right.val);
				}
			}
		}
		return sum;
	}
}