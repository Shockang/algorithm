package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode138.solution1;


import com.shockang.study.algorithm.java.leetcode.common.random.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shockang
 */
public class Solution {
	public Node copyRandomList(Node head) {
		if (head == null) return null;

		Map<Node, Node> map = new HashMap<>();

		// loop 1. copy all the nodes
		Node node = head;
		while (node != null) {
			map.put(node, new Node(node.val));
			node = node.next;
		}

		// loop 2. assign next and random pointers
		node = head;
		while (node != null) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}

		return map.get(head);
	}
}