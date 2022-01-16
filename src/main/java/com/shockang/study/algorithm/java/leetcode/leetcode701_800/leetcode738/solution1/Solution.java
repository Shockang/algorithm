package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode738.solution1;

/**
 * 贪心
 *
 * @author Shockang
 */
public class Solution {
	public int monotoneIncreasingDigits(int n) {
		char[] A = Integer.toString(n).toCharArray();
		int i = 1;
		while (i < A.length && A[i - 1] <= A[i]) i++;
		if (i < A.length) {
			while (i > 0 && A[i - 1] > A[i]) {
				A[i - 1]--;
				i--;
			}
			for (i++; i < A.length; ++i) A[i] = '9';
		}
		return Integer.parseInt(new String(A));
	}
}
