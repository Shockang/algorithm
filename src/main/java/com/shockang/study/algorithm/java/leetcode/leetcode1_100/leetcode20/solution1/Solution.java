package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode20.solution1;

import java.util.ArrayDeque;

/**
 * @author Shockang
 */
public class Solution {
	public boolean isValid(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || c != stack.peek()) {
				return false;
			} else {
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
