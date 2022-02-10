package com.shockang.study.algorithm.java.leetcode.leetcode1601_1700.leetcode1630.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> list = new ArrayList<>();
		boolean f;
		for (int i = 0; i < l.length; i++) {
			f = true;
			int left = l[i];
			int right = r[i];
			int[] temp = Arrays.copyOfRange(nums, left, right + 1);
			Arrays.sort(temp);
			int a = (temp[right - left] - temp[0]) / (right - left);
			for (int j = right - left; j >= 0; j--) {
				if (j - 1 >= 0 && temp[j] - temp[j - 1] != a) {
					list.add(false);
					f = false;
					break;
				}
			}
			if (f) {
				list.add(true);
			}
		}
		return list;
	}
}