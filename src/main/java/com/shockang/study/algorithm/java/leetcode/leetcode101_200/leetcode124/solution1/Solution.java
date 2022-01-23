
package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode124.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * 全局变量max，左中右、左中、右中取大，左右和 0 比较
 *
 * @author Shockang
 */
public class Solution {
	private int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper(root);
		return max;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = Math.max(0, helper(root.left));
		int right = Math.max(0, helper(root.right));
		int lmr = left + root.val + right;
		max = Math.max(max, lmr);
		int ret = Math.max(left, right) + root.val;
		max = Math.max(max, ret);
		return ret;
	}
}
