package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode783.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * @author Shockang
 */
public class Solution {
	private Integer pre = null;
	private int min = Integer.MAX_VALUE;

	public int minDiffInBST(TreeNode root) {
		if (root.left != null) minDiffInBST(root.left);
		if (pre != null) min = Math.min(min, root.val - pre);
		pre = root.val;
		if (root.right != null) minDiffInBST(root.right);
		return min;
	}
}
