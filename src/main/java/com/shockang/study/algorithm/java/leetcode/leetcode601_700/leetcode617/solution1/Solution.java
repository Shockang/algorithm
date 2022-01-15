package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode617.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * 递归
 *
 * @author Shockang
 */
public class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		TreeNode res;
		if (t1 == null && t2 == null) {
			res = null;
		} else if (t1 == null) {
			res = new TreeNode(t2.val);
			res.left = mergeTrees(null, t2.left);
			res.right = mergeTrees(null, t2.right);
		} else if (t2 == null) {
			res = new TreeNode(t1.val);
			res.left = mergeTrees(t1.left, null);
			res.right = mergeTrees(t1.right, null);
		} else {
			res = new TreeNode(t1.val + t2.val);
			res.left = mergeTrees(t1.left, t2.left);
			res.right = mergeTrees(t1.right, t2.right);
		}
		return res;
	}
}