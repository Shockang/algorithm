package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode133.solution1;


import com.shockang.study.algorithm.java.leetcode.common.graph.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Shockang
 */
public class Solution {
	private Map<Integer, Node> map = new HashMap<>();

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		if (map.containsKey(node.val))
			return map.get(node.val);
		Node res = new Node(node.val);
		map.put(res.val, res);
		res.neighbors.addAll(node.neighbors.stream().map(this::cloneGraph).collect(Collectors.toList()));
		return res;
	}
}