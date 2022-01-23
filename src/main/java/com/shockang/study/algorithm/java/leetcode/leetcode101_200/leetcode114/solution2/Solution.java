package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode114.solution2;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * 递归+反向思维+后序遍历
 *
 * @author Shockang
 */
public class Solution {
	private TreeNode prev = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
}