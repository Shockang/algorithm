package com.shockang.study.algorithm.scala.archive.linkedlist.reverse

import com.shockang.study.algorithm.scala.archive.linkedlist.reverse.s1.ReverseList
import com.shockang.study.algorithm.scala.util.NodeUtil

object Main extends App {
  NodeUtil.printNode(ReverseList.reverse(NodeUtil.array2Node(Array(1, 2, 3, 4, 5, 6))))
}
