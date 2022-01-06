package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode350.solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shockang
 */
public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				result.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}

		int[] r = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			r[i] = result.get(i);
		}

		return r;
	}
}
