package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode842.solution1;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/jiang-shu-zu-chai-fen-cheng-fei-bo-na-qi-ts6c/
 *
 * @author Shockang
 */
public class Solution {
	public List<Integer> splitIntoFibonacci(String S) {
		List<Integer> list = new ArrayList<Integer>();
		backtrack(list, S, S.length(), 0, 0, 0);
		return list;
	}

	public boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
		if (index == length) {
			return list.size() >= 3;
		}
		long currLong = 0;
		for (int i = index; i < length; i++) {
			if (i > index && S.charAt(index) == '0') {
				break;
			}
			currLong = currLong * 10 + S.charAt(i) - '0';
			if (currLong > Integer.MAX_VALUE) {
				break;
			}
			int curr = (int) currLong;
			if (list.size() >= 2) {
				if (curr < sum) {
					continue;
				} else if (curr > sum) {
					break;
				}
			}
			list.add(curr);
			if (backtrack(list, S, length, i + 1, prev + curr, curr)) {
				return true;
			} else {
				list.remove(list.size() - 1);
			}
		}
		return false;
	}
}
