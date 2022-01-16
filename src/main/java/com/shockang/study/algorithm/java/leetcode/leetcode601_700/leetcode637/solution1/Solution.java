package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode637.solution1;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		if (root == null) {
			return list;
		}
		deque.add(root);
		TreeNode cur;
		while (!deque.isEmpty()) {
			int n = deque.size();
			double sum = 0.0;
			for (int i = 0; i < n; i++) {
				cur = deque.poll();
				sum += cur.val;
				if (cur.left != null) {
					deque.add(cur.left);
				}
				if (cur.right != null) {
					deque.add(cur.right);
				}
			}
			list.add(sum / n);
		}
		return list;
	}
}