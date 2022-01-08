package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode538.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * @author Shockang
 */
public class Solution {
	private int sum = 0;

	public TreeNode convertBST(TreeNode root) {
		if (root == null) {
			return root;
		}
		convertBST(root.right);
		root.val += sum;
		sum = root.val;
		convertBST(root.left);
		return root;
	}
}
