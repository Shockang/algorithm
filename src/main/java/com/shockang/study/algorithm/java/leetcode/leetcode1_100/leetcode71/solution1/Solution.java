package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode71.solution1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public String simplifyPath(String path) {
		Deque<String> stack = new ArrayDeque<>();
		List<String> skip = Arrays.asList("..", ".", "");
		for (String dir : path.split("/")) {
			if (dir.equals("..") && !stack.isEmpty()) stack.pop();
			else if (!skip.contains(dir)) stack.push(dir);
		}
		String res = "";
		for (String dir : stack) res = "/" + dir + res;
		return res.isEmpty() ? "/" : res;
	}
}