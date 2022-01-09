package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode103.solution5;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 迭代 + queue + deque
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<>();
		if (root == null) {
			return ans;
		}
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.offer(root);
		boolean isOrderLeft = true;
		while (!nodeQueue.isEmpty()) {
			Deque<Integer> levelList = new LinkedList<>();
			int size = nodeQueue.size();
			for (int i = 0; i < size; ++i) {
				TreeNode curNode = nodeQueue.poll();
				if (isOrderLeft) {
					levelList.offerLast(curNode.val);
				} else {
					levelList.offerFirst(curNode.val);
				}
				if (curNode.left != null) {
					nodeQueue.offer(curNode.left);
				}
				if (curNode.right != null) {
					nodeQueue.offer(curNode.right);
				}
			}
			ans.add(new LinkedList<>(levelList));
			isOrderLeft = !isOrderLeft;
		}
		return ans;
	}
}