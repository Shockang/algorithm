package com.shockang.study.algorithm.java.leetcode.leetcode301_400.leetcode385;

import java.util.List;

/**
 * This is the interface that allows for creating nested lists.
 * <p>
 * You should not implement it, or speculate about its implementation
 *
 * @author Shockang
 */
public class NestedInteger {
	// Constructor initializes an empty nested list.
	public NestedInteger() {

	}

	// Constructor initializes a single integer.
	public NestedInteger(int value) {

	}

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger() {
		return false;
	}

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return null;
	}

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value) {

	}

	// Set this NestedInteger to hold a nested list and adds a nested integer to it.
	public void add(NestedInteger ni) {

	}

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		return null;
	}
}