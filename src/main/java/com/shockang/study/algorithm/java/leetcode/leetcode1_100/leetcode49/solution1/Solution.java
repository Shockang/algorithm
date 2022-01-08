package com.shockang.study.algorithm.java.leetcode.leetcode1_100.leetcode49.solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 质数数组+map
 *
 * @author Shockang
 */
public class Solution {
	private int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<Long, List<String>> map = new HashMap<>();
		for (String str : strs) {
			long tmp = 1L;
			for (char c : str.toCharArray()) {
				tmp *= primes[c - 'a'];
			}
			if (map.containsKey(tmp)) {
				map.get(tmp).add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(tmp, list);
			}
		}
		return new ArrayList<>(map.values());
	}
}