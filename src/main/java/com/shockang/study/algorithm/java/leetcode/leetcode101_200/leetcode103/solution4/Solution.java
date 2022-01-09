package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode103.solution4;

import com.shockang.study.algorithm.java.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 迭代 + 2个栈
 *
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if (root == null) return ret;
		Deque<TreeNode> queue = new ArrayDeque<>(), stack = new ArrayDeque<>();
		queue.add(root);
		int level = 1;///层数为奇数时，正常顺序遍历,层数为偶数,倒序遍历
		while (!queue.isEmpty() || !stack.isEmpty()) {
			boolean isOrder = (level & 1) == 1;
			int n = isOrder ? queue.size() : stack.size();
			List<Integer> sub = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (isOrder) {
					TreeNode cur = queue.poll();
					sub.add(cur.val);
					if (cur.left != null) {
						stack.push(cur.left);
					}
					if (cur.right != null) {
						stack.push(cur.right);
					}
				} else {
					TreeNode cur = stack.poll();
					sub.add(cur.val);
					if (cur.right != null) {
						queue.addFirst(cur.right);
					}
					if (cur.left != null) {
						queue.addFirst(cur.left);
					}
				}
			}
			level++;
			ret.add(sub);
		}
		return ret;
	}
}
