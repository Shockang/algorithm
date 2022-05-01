package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode386.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> ret = new ArrayList<>();
		int number = 1;
		for (int i = 0; i < n; i++) {
			ret.add(number);
			if (number * 10 <= n) {
				number *= 10;
			} else {
				while (number % 10 == 9 || number + 1 > n) {
					number /= 10;
				}
				number++;
			}
		}
		return ret;
	}
}