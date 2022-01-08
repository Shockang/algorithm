package com.shockang.study.algorithm.java.leetcode.leetcode401_500.leetcode401.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<String> readBinaryWatch(int num) {
		List<String> times = new ArrayList<>();
		for (int h = 0; h < 12; h++) {
			for (int m = 0; m < 60; m++) {
				if (Integer.bitCount((h << 6) + m) == num) {
					times.add(String.format("%d:%02d", h, m));
				}
			}
		}
		return times;
	}
}