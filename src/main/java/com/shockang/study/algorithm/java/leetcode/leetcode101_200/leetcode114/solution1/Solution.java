
package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode114.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

/**
 * 寻找前驱节点
 *
 * @author Shockang
 */
public class Solution {
	public void flatten(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left != null) {
				TreeNode next = cur.left;
				TreeNode pre = next;
				while (pre.right != null) {
					pre = pre.right;
				}
				pre.right = cur.right;
				cur.left = null;
				cur.right = next;
			}
			cur = cur.right;
		}
	}
}