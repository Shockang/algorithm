package com.shockang.study.algorithm.scala.archive.array

object Main extends App {
  val list: MySimpleArrayList[Int] = new MySimpleArrayList[Int](4)
  list.add(0)
  list.add(1)
  list.add(2)
  // scalastyle:off println
  println(list.size)
  println(list.toString)
  list.add(3)
  list.add(4)
  list.add(5)
  println(list.size)
  println(list.toString)
  list.add(6)
  list.add(7)
  println(list.size)
  println(list.toString)
  list.insert(21, 3)
  println(list.size)
  println(list.toString)
  println(list.get(3))
  list.delete(3)
  println(list.size)
  println(list.toString)
  println(list.get(3))
  list.delete(10)
  // scalastyle:on println
}
