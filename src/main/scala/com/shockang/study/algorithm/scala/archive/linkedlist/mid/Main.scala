package com.shockang.study.algorithm.scala.archive.linkedlist.mid

import com.shockang.study.algorithm.scala.common.Node
import com.shockang.study.algorithm.scala.util.NodeUtil

object Main extends App {
  val node1: Node = NodeUtil.array2Node(Array(1, 2, 3, 4, 5, 6, 7, 8, 9))
  val node2: Node = NodeUtil.array2Node(Array(1, 2, 3, 4, 5, 6, 7, 8))
  println(Solution.midOfListNode(node1).v)
  println(Solution.midOfListNode(node2).v)
}
