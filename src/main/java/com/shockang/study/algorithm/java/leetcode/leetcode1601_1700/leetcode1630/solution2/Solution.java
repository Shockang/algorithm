package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1630.solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {

	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		int m = l.length;
		List<Boolean> res = new ArrayList<>(m);
		for (int i = 0; i < m; i++) {
			res.add(check(nums, l[i], r[i]));
		}
		return res;
	}

	private boolean check(int[] src, int start, int end) {
		if (start + 1 > end) {
			return false;
		} else if (start + 1 == end) {
			return true;
		}
		int n = end - start + 1;
		int[] target = new int[n];
		System.arraycopy(src, start, target, 0, n);
		Arrays.sort(target);
		int v = target[1] - target[0];
		for (int i = 2; i < n; i++) {
			if (target[i] - target[i - 1] != v) {
				return false;
			}
		}
		return true;
	}
}