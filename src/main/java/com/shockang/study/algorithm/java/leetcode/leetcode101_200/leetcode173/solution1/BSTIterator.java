package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode173.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Shockang
 */
public class BSTIterator {

	private Deque<Integer> list = new LinkedList<>();

	public BSTIterator(TreeNode root) {
		postorder(root);
	}

	public int next() {
		return list.pollFirst();
	}

	public boolean hasNext() {
		return !list.isEmpty();
	}

	private void postorder(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			root = root.right;
		}
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */