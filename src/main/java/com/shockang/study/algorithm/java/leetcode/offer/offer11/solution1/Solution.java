package com.shockang.study.algorithm.java.leetcode.offer.offer11.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int minArray(int[] numbers) {
		int low = 0;
		int high = numbers.length - 1;
		while (low < high) {
			int pivot = low + (high - low) / 2;
			if (numbers[pivot] < numbers[high]) {
				high = pivot;
			} else if (numbers[pivot] > numbers[high]) {
				low = pivot + 1;
			} else {
				high -= 1;
			}
		}
		return numbers[low];
	}
}