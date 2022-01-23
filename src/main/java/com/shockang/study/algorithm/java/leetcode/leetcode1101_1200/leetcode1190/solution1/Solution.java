package com.shockang.study.algorithm.java.leetcode.leetcode1101_1200.leetcode1190.solution1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Shockang
 */
public class Solution {
	public String reverseParentheses(String s) {
		Deque<String> stack = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(sb.toString());
				sb.setLength(0);
			} else if (ch == ')') {
				sb.reverse();
				sb.insert(0, stack.pop());
			} else {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}