package com.shockang.study.algorithm.java.leetcode.leetcode501_600.leetcode503.solution2;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author Shockang
 */
public class Solution {
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] array = new int[2 * n], tmp = new int[2 * n];
		System.arraycopy(nums, 0, array, 0, n);
		System.arraycopy(nums, 0, array, n, n);
		Arrays.fill(tmp, -1);
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < 2 * n; i++) {
			while (!stack.isEmpty() && array[i] > array[stack.peek()]) {
				tmp[stack.pop()] = array[i];
			}
			stack.push(i);
		}
		System.arraycopy(tmp, 0, nums, 0, n);
		return nums;
	}
}
