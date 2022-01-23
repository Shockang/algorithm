package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode938.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * @author Shockang
 */
public class Solution {
	private int sum = 0;

	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root.left != null) rangeSumBST(root.left, L, R);
		if (root.val >= L && root.val <= R) sum += root.val;
		if (root.right != null) rangeSumBST(root.right, L, R);
		return sum;
	}
}