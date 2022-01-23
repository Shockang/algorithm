package com.shockang.study.algorithm.java.leetcode.leetcode901_1000.leetcode977.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int[] sortedSquares(int[] A) {
		int n = A.length;
		int i = 0, j = n - 1;
		int[] R = new int[n];
		for (int k = n - 1; k >= 0; --k) {
			if (Math.abs(A[i]) > Math.abs(A[j])) {
				R[k] = A[i] * A[i];
				++i;
			} else {
				R[k] = A[j] * A[j];
				--j;
			}
		}
		return R;
	}
}