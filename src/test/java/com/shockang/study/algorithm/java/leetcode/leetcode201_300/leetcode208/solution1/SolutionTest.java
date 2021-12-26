package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode208.solution1;

import org.junit.jupiter.api.Test;

/**
 * @author Shockang
 */
public class SolutionTest {
	@Test
	public void test() {
		Trie obj = new Trie();
		obj.insert("abc");
		obj.insert("abd");
		obj.insert("acd");
		assert obj.search("abd");
		assert obj.startsWith("ac");
	}
}
