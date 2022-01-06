package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode316.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 贪心+单调栈
 *
 * @author Shockang
 */
public class Solution {
	public String removeDuplicateLetters(String s) {
		int n = s.length();
		char[] chars = s.toCharArray();
		int[] lastIndex = new int[26];
		for (int i = 0; i < n; i++) {
			lastIndex[chars[i] - 'a'] = i;
		}
		Deque<Character> stack = new ArrayDeque<>();
		boolean[] visited = new boolean[26];
		for (int i = 0; i < n; i++) {
			if (visited[chars[i] - 'a']) {
				continue;
			}
			while (!stack.isEmpty() && stack.peek() > chars[i] && lastIndex[chars[i] - 'a'] > i) {
				char c = stack.pop();
				visited[c - 'a'] = false;
			}
			stack.push(chars[i]);
			visited[chars[i] - 'a'] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}
}

