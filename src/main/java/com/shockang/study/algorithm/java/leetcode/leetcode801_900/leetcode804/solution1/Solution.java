package com.shockang.study.algorithm.java.leetcode.leetcode801_900.leetcode804.solution1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	private String[] array = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

	public int uniqueMorseRepresentations(String[] words) {
		Set<String> set = new HashSet<>();
		for (String word : words) {
			StringBuilder sb = new StringBuilder();
			for (char c : word.toCharArray()) {
				sb.append(array[c - 'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
	}
}