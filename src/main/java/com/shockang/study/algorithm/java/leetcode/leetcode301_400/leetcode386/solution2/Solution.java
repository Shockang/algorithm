package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode386.solution2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<Integer> lexicalOrder(int n) {
		Tries r = new Tries();
		r.insert(r.root, n, 0);
		return r.ls;
	}

	public class Tries {
		Node root = new Node();
		List<Integer> ls = new ArrayList<>();

		class Node {
			Node[] values = new Node[10];
			int curr;
		}

		public void insert(Node node, int target, int preval) {
			for (int i = 0; i < 10; i++) {
				if (node.values[i] == null) {
					node.values[i] = new Node();
					node.values[i].curr = preval * 10 + i;
				}
				if (node.values[i].curr > target) {
					return;
				}
				if (node.values[i].curr != 0) {
					ls.add(node.values[i].curr);
					//此处递归
					insert(node.values[i], target, node.values[i].curr);
				}
			}
		}
	}
}