package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode413.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int numberOfArithmeticSlices(int[] A) {
		int count = 0;
		int sum = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				count++;
			} else {
				sum += (count + 1) * count / 2;
				count = 0;
			}
		}
		return sum + count * (count + 1) / 2;
	}
}