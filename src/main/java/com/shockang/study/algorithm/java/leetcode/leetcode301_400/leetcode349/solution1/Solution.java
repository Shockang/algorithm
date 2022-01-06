package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode349.solution1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> res = new HashSet<>();
		Set<Integer> set = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}
		for (int num : nums2) {
			if (set.contains(num)) {
				res.add(num);
			}
		}
		List<Integer> list = new ArrayList<>(res);
		int[] r = new int[list.size()];
		for (int i = 0; i < r.length; i++) {
			r[i] = list.get(i);
		}
		return r;
	}
}