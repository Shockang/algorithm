package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode34.solution2;

/**
 * @author Shockang
 */
public class Solution {
	private int[] A, res = new int[]{-1, -1};
	private int t, n;

	public int[] searchRange(int[] nums, int target) {
		A = nums;
		t = target;
		n = nums.length;
		if (n == 0) return res;
		findFirst();
		findLast();
		return res;
	}

	private void findFirst() {
		int l = 0, r = n - 1;
		while (l <= r) {
			int m = l + ((r - l) >> 1);
			if (A[m] >= t) {
				if (isFirst(m)) {
					res[0] = m;
					break;
				}
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
	}

	private void findLast() {
		int l = 0, r = n - 1;
		while (l <= r) {
			int m = l + ((r - l) >> 1);
			if (A[m] <= t) {
				if (isLast(m)) {
					res[1] = m;
					break;
				}
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
	}

	private boolean isFirst(int m) {
		return A[m] == t && (m == 0 || A[m - 1] != t);
	}

	private boolean isLast(int m) {
		return A[m] == t && (m == n - 1 || A[m + 1] != t);
	}
}
