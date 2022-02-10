package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode968.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * @author Shockang
 */
public class Solution {
	public int minCameraCover(TreeNode root) {
		int[] array = dfs(root);
		return array[1];
	}

	public int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[]{Integer.MAX_VALUE / 2, 0, 0};
		}
		int[] l = dfs(root.left);
		int[] r = dfs(root.right);
		int[] array = new int[3];
		// root 有监控，整棵树被覆盖，这时只需要保证 2 个子树的所有子树都被覆盖
		array[0] = l[2] + r[2] + 1;
		// 整棵树被覆盖，root 有没有监控无所谓，左孩子有监控然后右子树被覆盖或者右孩子有监控左子树被覆盖
		array[1] = Math.min(array[0], Math.min(l[0] + r[1], r[0] + l[1]));
		// 2 个子树被覆盖，root 有没有被覆盖无所谓
		array[2] = Math.min(array[0], l[1] + r[1]);
		return array;
	}
}