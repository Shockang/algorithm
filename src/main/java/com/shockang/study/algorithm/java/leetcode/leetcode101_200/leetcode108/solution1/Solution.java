package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode108.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * 中序遍历
 *
 * @author Shockang
 */
public class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		// 总是选择中间位置左边的数字作为根节点
		int mid = (left + right) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		return root;
	}
}
