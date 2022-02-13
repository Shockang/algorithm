package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode129.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * @author Shockang
 */
public class Solution {
	public int sumNumbers(TreeNode root) {
		return dfs(root, 0);
	}

	public int dfs(TreeNode root, int prevSum) {
		if (root == null) {
			return 0;
		}
		int sum = prevSum * 10 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		} else {
			return dfs(root.left, sum) + dfs(root.right, sum);
		}
	}
}
