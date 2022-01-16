package com.shockang.study.algorithm.java.leetcode.leetcode601_700.leetcode692.solution2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Shockang
 */
public class Solution {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Long> map = Arrays.stream(words)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Set<String> set = new TreeSet<>((x1, x2) -> (int) (map.get(x1).equals(map.get(x2)) ?
				x1.compareTo(x2) :
				map.get(x2) - map.get(x1)));
		set.addAll(map.keySet());
		return new ArrayList<>(set).subList(0, k);
	}
}