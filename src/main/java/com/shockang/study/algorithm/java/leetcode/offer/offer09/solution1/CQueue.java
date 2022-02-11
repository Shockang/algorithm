package com.shockang.study.algorithm.java.leetcode.offer.offer09.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shockang
 */
public class CQueue {
	private Deque<Integer> stackEnque;
	private Deque<Integer> stackDeque;

	public CQueue() {
		stackEnque = new ArrayDeque<>();
		stackDeque = new ArrayDeque<>();
	}

	public void appendTail(int value) {
		while (!stackDeque.isEmpty()) {
			stackEnque.push(stackDeque.pop());
		}
		stackEnque.push(value);
	}

	public int deleteHead() {
		while (!stackEnque.isEmpty()) {
			stackDeque.push(stackEnque.pop());
		}
		if (stackDeque.isEmpty()) {
			return -1;
		}
		return stackDeque.pop();
	}
}