package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode187.solution1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
		for (int i = 0; i + 9 < s.length(); i++) {
			String ten = s.substring(i, i + 10);
			if (!seen.add(ten)) repeated.add(ten);
		}
		return new ArrayList(repeated);
	}
}