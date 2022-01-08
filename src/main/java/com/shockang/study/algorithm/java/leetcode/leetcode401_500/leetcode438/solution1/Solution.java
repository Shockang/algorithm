package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode438.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		int[] a = new int[128];
		for (char c : p.toCharArray()) a[c]++;
		int l = 0, r = 0;
		List<Integer> res = new ArrayList<>();
		while (r < s.length()) {
			if (a[s.charAt(r)] > 0) {
				a[s.charAt(r++)]--;
				if (r - l == p.length()) res.add(l);
			} else {
				a[s.charAt(l++)]++;
			}
		}
		return res;
	}
}
