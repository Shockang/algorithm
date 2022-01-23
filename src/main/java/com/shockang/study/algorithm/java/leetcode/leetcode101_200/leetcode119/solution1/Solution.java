package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode119.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shockang
 */
public class Solution {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList<>(rowIndex + 1);
		ret.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			for (int j = i - 1; j >= 1; j--) {
				int tmp = ret.get(j - 1) + ret.get(j);
				ret.set(j, tmp);
			}
			ret.add(1);
		}
		return ret;
	}
}