package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode95.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归
 *
 * @author Shockang
 */
public class Solution {
	public List<TreeNode> generateTrees(int n) {
		return genTreeList(1, n);
	}

	private List<TreeNode> genTreeList(int start, int end) {
		List<TreeNode> list = new ArrayList<>();
		if (start > end) list.add(null);
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftList = genTreeList(start, i - 1);
			List<TreeNode> rightList = genTreeList(i + 1, end);
			for (TreeNode left : leftList) {
				for (TreeNode right : rightList) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					list.add(root);
				}
			}
		}
		return list;
	}
}