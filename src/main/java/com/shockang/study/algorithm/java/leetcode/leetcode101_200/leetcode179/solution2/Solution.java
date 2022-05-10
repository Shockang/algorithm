package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode179.solution2;

import java.util.PriorityQueue;

/**
 * @author Shockang
 */
public class Solution {
	public String largestNumber(int[] nums) {
		PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
		for (int x : nums) heap.offer(String.valueOf(x));
		String res = "";
		while (heap.size() > 0) res += heap.poll();
		if (res.charAt(0) == '0') return "0";
		return res;
	}
}