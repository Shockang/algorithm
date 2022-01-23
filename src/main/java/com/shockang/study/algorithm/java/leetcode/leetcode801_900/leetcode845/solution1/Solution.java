package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode845.solution1;

/**
 * @author Shockang
 */
public class Solution {
	public int longestMountain(int[] A) {
		int res = 0, up = 0, down = 0;
		for (int i = 1; i < A.length; ++i) {
			if ((down > 0 && A[i - 1] < A[i]) || A[i - 1] == A[i]) up = down = 0;
			if (A[i - 1] < A[i]) up++;
			if (A[i - 1] > A[i]) down++;
			if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
		}
		return res;
	}
}
