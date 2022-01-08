package com.shockang.study.algorithm.scala.archive.linkedlist.remove

import com.shockang.study.algorithm.scala.common.Node
import com.shockang.study.algorithm.scala.util.NodeUtil

object Main extends App {
  val node: Node = NodeUtil.array2Node(Array(1, 2, 3, 4, 5, 6, 7, 8, 9))
  NodeUtil.printNode(Solution.removeNDesc(node, 5))
}
