package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode208.solution1;

/**
 * @author Shockang
 */
public class Trie {
	private boolean isStr;
	private Trie[] next;

	public Trie() {
		isStr = false;
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

	public boolean search(String word) {
		Trie root = this;
		char[] w = word.toCharArray();
		for (int i = 0; i < w.length; ++i) {
			if (root.next[w[i] - 'a'] == null) return false;
			root = root.next[w[i] - 'a'];
		}
		return root.isStr;
	}

	public boolean startsWith(String prefix) {
		Trie root = this;
		char p[] = prefix.toCharArray();
		for (int i = 0; i < p.length; ++i) {
			if (root.next[p[i] - 'a'] == null) return false;
			root = root.next[p[i] - 'a'];
		}
		return true;
	}
}