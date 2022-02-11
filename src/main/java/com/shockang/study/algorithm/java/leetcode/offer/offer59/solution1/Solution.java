package com.shockang.study.algorithm.java.leetcode.offer.offer59.solution1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Shockang
 */
public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		Deque<Integer> deque = new LinkedList<>();
		int n = nums.length, index = 0;
		int[] res = new int[n - k + 1];
		for (int i = 0; i < n; i++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
				deque.pollLast();
			}
			deque.addLast(i);
			if (deque.peekFirst() == i - k) {
				deque.pollFirst();
			}
			if (i >= k - 1) {
				res[index++] = nums[deque.peekFirst()];
			}
		}
		return res;
	}
}