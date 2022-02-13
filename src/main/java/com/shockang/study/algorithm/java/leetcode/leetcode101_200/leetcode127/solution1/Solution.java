package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode127.solution1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Shockang
 */
public class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
		qs.add(beginWord);
		if (dict.contains(endWord)) qe.add(endWord); // all transformed words must be in dict (including endWord)
		for (int len = 2; !qs.isEmpty(); len++) {
			Set<String> nq = new HashSet<>();
			for (String w : qs) {
				for (int j = 0; j < w.length(); j++) {
					char[] ch = w.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						if (c == w.charAt(j)) continue; // beginWord and endWord not the same, so bypass itself
						ch[j] = c;
						String nb = String.valueOf(ch);
						if (qe.contains(nb)) return len; // meet from two ends
						if (dict.contains(nb) && vis.add(nb)) nq.add(nb); // not meet yet, vis is safe to use
					}
				}
			}
			qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
			qe = (qs == nq) ? qe : nq;
		}
		return 0;
	}
}