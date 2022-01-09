package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode99.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 中序遍历 + x,y,prev
 *
 * @author Shockang
 */
public class Solution {
	public void recoverTree(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode x = null, y = null, prev = null;

		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (prev != null && root.val < prev.val) {
				y = root;
				if (x == null) {
					x = prev;
				} else {
					break;
				}
			}
			prev = root;
			root = root.right;
		}
		swap(x, y);
	}

	public void swap(TreeNode x, TreeNode y) {
		int tmp = x.val;
		x.val = y.val;
		y.val = tmp;
	}
}
