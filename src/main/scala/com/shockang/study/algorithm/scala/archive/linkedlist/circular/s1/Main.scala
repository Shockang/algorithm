package com.shockang.study.algorithm.scala.archive.linkedlist.circular.s1

import com.shockang.study.algorithm.scala.util.NodeUtil

object Main extends App {
  val res: Boolean = Circular.isCircular(NodeUtil.array2Circular(Array(1, 2, 3, 4, 5)))
  println(res)
}
