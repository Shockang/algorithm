package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode151.solution1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author Shockang
 */
public class Solution {
	public String reverseWords(String s) {
		if (s == null)
			return null;
		s = s.trim();
		if (s.isEmpty())
			return s;
		String[] array = s.split(" ");
		List<String> list = Arrays.stream(array).filter(x -> !x.isEmpty())
				.collect(Collectors.toList());
		Collections.reverse(list);
		StringJoiner joiner = new StringJoiner(" ");
		for (String str : list) {
			joiner.add(str);
		}
		return joiner.toString();
	}
}