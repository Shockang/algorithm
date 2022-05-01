package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode388.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shockang
 */
public class Solution {
	public int lengthLongestPath(String input) {
		int n = input.length();
		int pos = 0;
		int ans = 0;
		Deque<Integer> stack = new ArrayDeque<>();

		while (pos < n) {
			/* 检测当前文件的深度 */
			int depth = 1;
			while (pos < n && input.charAt(pos) == '\t') {
				pos++;
				depth++;
			}
			/* 统计当前文件名的长度 */
			boolean isFile = false;
			int len = 0;
			while (pos < n && input.charAt(pos) != '\n') {
				if (input.charAt(pos) == '.') {
					isFile = true;
				}
				len++;
				pos++;
			}
			/* 跳过当前的换行符 */
			pos++;

			while (stack.size() >= depth) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				len += stack.peek() + 1;
			}
			if (isFile) {
				ans = Math.max(ans, len);
			} else {
				stack.push(len);
			}
		}
		return ans;
	}
}