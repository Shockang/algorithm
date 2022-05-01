package com.shockang.study.algorithm.java.leetcode.leetcode1301_1400.leetcode1305.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author Shockang
 */
public class Solution {
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		inorder(root1, stack, pq);
		inorder(root2, stack, pq);
		List<Integer> res = new ArrayList<>(pq.size());
		while (!pq.isEmpty()) {
			res.add(pq.poll());
		}
		return res;
	}

	private void inorder(TreeNode node, Deque<TreeNode> stack, PriorityQueue<Integer> pq) {
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			pq.add(node.val);
			node = node.right;
		}
	}
}