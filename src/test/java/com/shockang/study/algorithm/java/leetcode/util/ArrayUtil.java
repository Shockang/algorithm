package com.shockang.study.algorithm.java.leetcode.util;

import java.util.StringJoiner;

public class ArrayUtil {
	public static int[] stringToIntArray(String s) {
		s = s.trim();
		// [2,7,11,15]
		s = s.substring(1, s.length() - 1);
		String[] splits = s.split(",");
		int n = splits.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = Integer.parseInt(splits[i]);
		}
		return res;
	}

	public static String intArrayToString(int[] a) {
		StringJoiner sj = new StringJoiner(",", "[", "]");
		for (int i : a) {
			sj.add(String.valueOf(i));
		}
		return sj.toString();
	}
}
