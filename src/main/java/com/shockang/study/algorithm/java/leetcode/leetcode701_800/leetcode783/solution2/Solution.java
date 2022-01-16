package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode783.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayDeque;

/**
 * @author Shockang
 */
public class Solution {
	public int minDiffInBST(TreeNode root) {
		TreeNode node = root;
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		TreeNode pre = null;
		TreeNode cur = null;
		int min = Integer.MAX_VALUE;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			cur = stack.pop();
			if (pre != null) {
				min = Math.min(min, cur.val - pre.val);
			}
			pre = cur;
			node = cur.right;
		}
		return min;
	}
}