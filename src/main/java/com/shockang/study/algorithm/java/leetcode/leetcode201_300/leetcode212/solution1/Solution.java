package com.shockang.study.algorithm.java.leetcode.leetcode201_300.leetcode212.solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shockang
 */
public class Solution {
	//二维字符网络
	private char[][] b;
	//二维字符网络的高/宽度
	private int m, n;
	//结果集，即同时在二维网络和字典中出现的单词
	private List<String> res = new ArrayList<>();

	public List<String> findWords(char[][] board, String[] words) {
		//1.构建Trie树
		Trie root = new Trie();
		Trie node;
		for (String word : words) {
			node = root;
			for (char letter : word.toCharArray()) {
				//如果当前节点的子节点包含这个字符，则遍历到该子节点
				if (node.children.containsKey(letter)) {
					node = node.children.get(letter);
				} else {
					//如果当前节点的子节点不包含此字符，这时需要新增Trie节点
					Trie newNode = new Trie();
					node.children.put(letter, newNode);
					node = newNode;
				}
			}
			//单个字符串遍历完成需要把当前Trie节点挂载的字符串设置一下
			node.word = word;
		}
		//全局变量赋值
		b = board;
		m = b.length;
		n = b[0].length;
		//从每个单元格开始，如果字典中存在以单元格中的字母开头的单词,则我们开始回溯探索
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (root.children.containsKey(b[row][col])) {
					backtracking(row, col, root);
				}
			}
		}
		return res;
	}

	/**
	 * 回溯探索
	 *
	 * @param row    二维网络的行
	 * @param col    二维网络的列
	 * @param parent 表示字典树的父节点
	 */
	private void backtracking(int row, int col, Trie parent) {
		//当前遍历的字符
		char letter = b[row][col];
		//获取当前遍历字符对应的字典树节点
		Trie cur = parent.children.get(letter);
		//如果当前节点上挂载了字符串，说明此时遍历二维网络的过程中已经发现了一个字典中存在的单词，当然得放入结果集中
		if (cur.word != null) {
			res.add(cur.word);
			//把字典树当前挂载的字符串设置为null，防止重复计算
			cur.word = null;
		}
		//如果当前节点的子节点为空，说明此时已经遍历到字典树的叶子节点
		if (cur.children.isEmpty()) {
			parent.children.remove(letter);
			return;
		}
		//当前遍历完字符后需要设置为无效字符，防止重复计算
		b[row][col] = '#';
		// rowOffset，colOffset表示当前节点上下左右移动，这在小岛沉没问题里面也是比较常见的做法
		int[] rowOffset = {-1, 0, 1, 0};
		int[] colOffset = {0, 1, 0, -1};
		for (int i = 0; i < 4; i++) {
			//newRow，newCol表示当前节点上下左右移动后的新坐标
			int newRow = row + rowOffset[i];
			int newCol = col + colOffset[i];
			//二维网络的范围内，如果当前节点的子节点包含新的坐标，继续回溯
			if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && cur.children.containsKey(b[newRow][newCol])) {
				backtracking(newRow, newCol, cur);
			}
		}
		//上下左右移动判断完成后需要恢复之前的字符，方便后续其他情况下的遍历
		b[row][col] = letter;
	}
}

class Trie {
	//word表示当前节点挂载的单词字符串，可为空
	String word;
	//children表示当前节点的子节点中字符和节点的映射关系
	Map<Character, Trie> children = new HashMap<>();
}

