package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode100.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * 递归
 *
 * @author Shockang
 */
public class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.val != q.val) {
			return false;
		} else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}
}
