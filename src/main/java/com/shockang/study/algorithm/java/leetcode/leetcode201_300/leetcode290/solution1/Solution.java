package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode290.solution1;

import java.util.HashMap;
import java.util.Map;

/**
 * 2个Map
 *
 * @author Shockang
 */
public class Solution {
		public boolean wordPattern(String pattern, String str) {
				Map<String, Character> str2ch = new HashMap<>();
				Map<Character, String> ch2str = new HashMap<>();
				int m = str.length(), i = 0;
				for (int p = 0; p < pattern.length(); ++p) {
						char ch = pattern.charAt(p);
						if (i >= m) return false;
						int j = i;
						while (j < m && str.charAt(j) != ' ') j++;
						String tmp = str.substring(i, j);
						if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) return false;
						if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) return false;
						str2ch.put(tmp, ch);
						ch2str.put(ch, tmp);
						i = j + 1;
				}
				return i >= m;
		}
}
