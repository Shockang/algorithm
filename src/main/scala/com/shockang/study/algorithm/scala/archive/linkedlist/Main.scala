package com.shockang.study.algorithm.scala.archive.linkedlist

object Main extends App {
  val list: MyLinkedList[Int] = new MyLinkedList[Int]()
  out(list)
  // 新增
  list.add(0)
  list.add(1)
  list.add(2)
  list.add(3)
  out(list)
  list.add(4)
  list.add(5)
  list.add(6)
  out(list)
  list.add(7)
  list.add(8)
  list.add(9)
  out(list)
  list.add(4, 31)
  out(list)
  list.addFirst(-1)
  out(list)
  list.addLast(10)
  out(list)
  list.offer(9)
  out(list)
  list.offerFirst(-2)
  out(list)
  list.push(-3)
  out(list)
  // 修改
  list.set(4, 10)
  out(list)
  // 删除
  list.remove
  out(list)
  // scalastyle:off println
  println(list.removeFirstOccurrence(10))
  out(list)
  println(list.removeLastOccurrence(9))
  out(list)
  println(list.removeFirst())
  out(list)
  println(list.removeLast())
  out(list)
  println(list.pop)
  out(list)
  list.clear()
  out(list)
  // scalastyle:on println

  def out(list: MyLinkedList[Int]): Unit = {
    println("****************************************")
    try {
      println(list.size)
      println(list.getFirst)
      println(list.getLast)
      println(list.get(list.size - 2))
      println(list.contains(-1))
      println(list.peek)
      println(list.toString)
    } catch {
      case x: Exception => println(x)
    }
    println("****************************************")
  }
}
