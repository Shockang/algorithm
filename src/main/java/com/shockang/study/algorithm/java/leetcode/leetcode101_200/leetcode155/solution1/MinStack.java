package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode155.solution1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Shockang
 */
public class MinStack {
	Deque<Integer> xStack;
	Deque<Integer> minStack;

	public MinStack() {
		xStack = new LinkedList<>();
		minStack = new LinkedList<>();
		minStack.push(Integer.MAX_VALUE);
	}

	public void push(int x) {
		xStack.push(x);
		minStack.push(Math.min(minStack.peek(), x));
	}

	public void pop() {
		xStack.pop();
		minStack.pop();
	}

	public int top() {
		return xStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
