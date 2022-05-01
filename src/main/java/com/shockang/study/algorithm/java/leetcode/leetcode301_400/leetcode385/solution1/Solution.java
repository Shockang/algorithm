package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode385.solution1;

import com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode385.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shockang
 */
public class Solution {
	public NestedInteger deserialize(String s) {
		if (s.charAt(0) != '[') {
			return new NestedInteger(Integer.parseInt(s));
		}
		Deque<NestedInteger> stack = new ArrayDeque<>();
		int num = 0;
		boolean negative = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '-') {
				negative = true;
			} else if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			} else if (c == '[') {
				stack.push(new NestedInteger());
			} else if (c == ',' || c == ']') {
				if (Character.isDigit(s.charAt(i - 1))) {
					if (negative) {
						num *= -1;
					}
					stack.peek().add(new NestedInteger(num));
				}
				num = 0;
				negative = false;
				if (c == ']' && stack.size() > 1) {
					NestedInteger ni = stack.pop();
					stack.peek().add(ni);
				}
			}
		}
		return stack.pop();
	}
}