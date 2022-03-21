package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode138.solution2;

import com.shockang.study.algorithm.java.leetcode.common.random.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shockang
 */
public class Solution {
	private Map<Node, Node> map = new HashMap<>();

	public Node copyRandomList(Node head) {
		if (head == null) return null;
		Node node = checkAndPut(head);
		node.next = copyRandomList(head.next);
		node.random = checkAndPut(head.random);
		return node;
	}

	private Node checkAndPut(Node head) {
		if (head == null) return null;
		if (!map.containsKey(head)) {
			map.put(head, new Node(head.val));
		}
		return map.get(head);
	}
}