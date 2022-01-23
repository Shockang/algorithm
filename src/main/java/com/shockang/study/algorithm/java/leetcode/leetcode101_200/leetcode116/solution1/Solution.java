
package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode116.solution1;


import com.shockang.study.algorithm.java.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	private List<Node> list = new ArrayList<>();

	public Node connect(Node root) {
		if (root == null) return null;
		helper(root, 0);
		return list.get(0);
	}

	private void helper(Node node, int level) {
		if (node == null) return;
		if (level < list.size()) {
			Node pre = list.get(level);
			pre.next = node;
			list.set(level, node);
		} else {
			list.add(node);
		}
		helper(node.left, level + 1);
		helper(node.right, level + 1);
	}
}