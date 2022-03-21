package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode159.solution1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shockang
 */
public class Solution {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int n = s.length();
		if (n < 3) return n;

		// sliding window left and right pointers
		int left = 0, right = 0;
		// hashmap character -> its rightmost position
		// in the sliding window
		Map<Character, Integer> hashmap = new HashMap<>();

		int maxLen = 2;

		while (right < n) {
			// slidewindow contains less than 3 characters
			if (hashmap.size() < 3)
				hashmap.put(s.charAt(right), right++);

			// slidewindow contains 3 characters
			if (hashmap.size() == 3) {
				// delete the leftmost character
				int delIdx = Collections.min(hashmap.values());
				hashmap.remove(s.charAt(delIdx));
				// move left pointer of the slidewindow
				left = delIdx + 1;
			}

			maxLen = Math.max(maxLen, right - left);
		}
		return maxLen;
	}
}