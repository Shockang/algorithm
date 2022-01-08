package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode530.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * 递归中序遍历
 *
 * @author Shockang
 */
public class Solution {
	private int min = Integer.MAX_VALUE;
	private Integer pre = null;

	public int getMinimumDifference(TreeNode root) {
		if (root == null) {
			return min;
		}
		getMinimumDifference(root.left);
		if (pre != null) {
			min = Math.min(min, root.val - pre);
		}
		pre = root.val;
		getMinimumDifference(root.right);
		return min;
	}
}