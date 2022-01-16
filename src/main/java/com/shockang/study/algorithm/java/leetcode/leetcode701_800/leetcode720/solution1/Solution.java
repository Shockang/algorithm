package com.shockang.study.algorithm.java.leetcode.leetcode701_800.leetcode720.solution1;

/**
 * 字典树
 *
 * @author Shockang
 */
public class Solution {
	public String longestWord(String[] words) {
		Trie root = new Trie();
		for (String word : words) {
			root.insert(word);
		}
		return root.dfs();
	}
}

class Trie {
	private boolean isStr;
	private Trie[] next;

	public Trie() {
		next = new Trie[26];
	}

	public void insert(String word) {
		Trie root = this;
		char[] w = word.toCharArray();
		for (int i = 0; i < w.length; ++i) {
			if (root.next[w[i] - 'a'] == null) root.next[w[i] - 'a'] = new Trie();
			root = root.next[w[i] - 'a'];
		}
		root.isStr = true;
	}

	public String dfs() {
		String res = "";
		for (int i = 0; i < 26; i++) {
			if (next[i] != null && next[i].isStr) {
				String s = (char) (i + 'a') + next[i].dfs();
				if (s.length() > res.length()) {
					res = s;
				}
			}
		}
		return res;
	}
}
