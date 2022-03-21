package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode146.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shockang
 */
public class LRUCache {

	private int capacity;
	private Node head, tail;
	private Map<Integer, Node> map;

	public LRUCache(int capacity) {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		this.capacity = capacity;
		map = new HashMap<>(capacity);
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			moveToHead(node);
			return node.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			moveToHead(node);
			return;
		}
		Node node = new Node(key, value);
		map.put(key, node);
		addToHead(node);
		if (map.size() > capacity) {
			Node tailNode = tail.prev;
			deleteNode(tailNode);
			map.remove(tailNode.key);
		}
	}

	private void moveToHead(Node node) {
		deleteNode(node);
		addToHead(node);
	}

	private void addToHead(Node node) {
		Node oldHead = head.next;
		head.next = node;
		node.prev = head;
		node.next = oldHead;
		oldHead.prev = node;
	}

	private void deleteNode(Node node) {
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;
	}

	private static class Node {
		int key;
		int value;
		Node prev, next;

		Node() {
		}

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}