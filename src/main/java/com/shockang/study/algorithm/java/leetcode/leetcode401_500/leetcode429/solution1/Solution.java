package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode429.solution1;

import com.shockang.study.algorithm.java.leetcode.common.tree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Shockang
 */
public class Solution {
	public List<List<Integer>> levelOrder(Node root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<List<Integer>> ans = new ArrayList<>();
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int cnt = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < cnt; ++i) {
				Node cur = queue.poll();
				level.add(cur.val);
				for (Node child : cur.children) {
					queue.offer(child);
				}
			}
			ans.add(level);
		}

		return ans;
	}
}