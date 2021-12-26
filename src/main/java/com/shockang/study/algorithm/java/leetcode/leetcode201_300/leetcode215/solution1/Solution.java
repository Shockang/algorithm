package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode215.solution1;

import java.util.PriorityQueue;

/**
 * 优先队列
 *
 * @author Shockang
 */
public class Solution {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (int num : nums) {
			priorityQueue.add(num);
		}
		int n = nums.length;
		for (int i = 0; i < n - k; i++) {
			priorityQueue.poll();
		}
		return priorityQueue.peek();
	}
}