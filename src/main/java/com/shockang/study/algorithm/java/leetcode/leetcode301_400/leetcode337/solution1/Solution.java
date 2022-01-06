package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode337.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * @author Shockang
 */
public class Solution {
	public int rob(TreeNode root) {
		int[] res = helper(root);
		return Math.max(res[0], res[1]);
	}

	private int[] helper(TreeNode node) {
		if (node == null) return new int[]{0, 0};
		int[] left = helper(node.left);
		int[] right = helper(node.right);
		return new int[]{
				node.val + left[1] + right[1],
				Math.max(left[0], left[1]) + Math.max(right[0], right[1])
		};
	}
}
