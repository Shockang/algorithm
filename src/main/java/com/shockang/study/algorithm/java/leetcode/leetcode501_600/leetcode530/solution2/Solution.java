package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode530.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈迭代中序遍历
 *
 * @author Shockang
 */
public class Solution {
	private int min = Integer.MAX_VALUE;
	private Integer pre = null;

	public int getMinimumDifference(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (pre != null) {
				min = Math.min(min, root.val - pre);
			}
			pre = root.val;
			root = root.right;
		}
		return min;
	}
}
