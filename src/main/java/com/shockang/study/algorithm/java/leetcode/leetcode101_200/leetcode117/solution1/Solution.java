
package com.shockang.study.algorithm.java.leetcode.leetcode101_200.leetcode117.solution1;

import com.shockang.study.algorithm.java.leetcode.common.Node;

/**
 * BFS
 *
 * @author Shockang
 */
public class Solution {
	public Node connect(Node root) {
		if (root == null) return root;
		//cur我们可以把它看做是每一层的链表
		Node cur = root;
		while (cur != null) {
			//遍历当前层的时候，为了方便操作在下一层前面添加一个哨兵（注意这里是访问当前层的节点，然后把下一层的节点串起来）
			Node dummy = new Node(0);
			//pre表示访下一层节点的前一个节点
			Node pre = dummy;
			//然后开始遍历当前层的链表
			while (cur != null) {
				if (cur.left != null) {
					//如果当前节点的左子节点不为空，就让pre节点的next指向他，也就是把它串起来
					pre.next = cur.left;
					//然后再更新pre
					pre = pre.next;
				}
				//同理参照左子树
				if (cur.right != null) {
					pre.next = cur.right;
					pre = pre.next;
				}
				//继续访问这一行的下一个节点
				cur = cur.next;
			}
			//把下一层串联成一个链表之后，让他赋值给cur，
			//后续继续循环，直到cur为空为止
			cur = dummy.next;
		}
		return root;
	}
}