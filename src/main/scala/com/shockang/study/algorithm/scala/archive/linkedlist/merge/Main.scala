package com.shockang.study.algorithm.scala.archive.linkedlist.merge

import com.shockang.study.algorithm.scala.archive.linkedlist.merge.s1.MergeList
import com.shockang.study.algorithm.scala.common.Node
import com.shockang.study.algorithm.scala.util.NodeUtil

object Main extends App {
  val node1: Node = NodeUtil.array2Node(Array(1, 3, 5))
  val node2: Node = NodeUtil.array2Node(Array(2, 4, 6))
  val node: Node = MergeList.merge(node1, node2)
  NodeUtil.printNode(node)
}
