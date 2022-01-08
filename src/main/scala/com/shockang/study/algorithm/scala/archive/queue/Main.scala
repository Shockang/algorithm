package com.shockang.study.algorithm.scala.archive.queue

object Main extends App {
  //val queue: Queue[Int] = new ArrayQueue[Int](10)
  //val queue: Queue[Int] = new LinkedListQueue[Int]()
  val queue: Queue[Int] = new CircularQueue[Int](5)
  out()
  try {
    queue.dequeue()
  } catch {
    case e: Exception => println(e)
  }
  queue.enqueue(0)
  queue.enqueue(1)
  queue.enqueue(2)
  queue.enqueue(3)
  queue.enqueue(4)
  queue.enqueue(5)
  queue.enqueue(6)
  queue.enqueue(7)
  queue.enqueue(8)
  queue.enqueue(9)
  out()
  queue.enqueue(10)
  out()
  println(queue.dequeue())
  out()
  println(queue.dequeue())
  println(queue.dequeue())
  println(queue.dequeue())
  println(queue.dequeue())
  println(queue.dequeue())
  println(queue.dequeue())
  println(queue.dequeue())
  println(queue.dequeue())
  println(queue.dequeue())
  out()
  println(queue.dequeue())
  out()
  try {
    println(queue.dequeue())
  } catch {
    case e: Exception => println(e)
  }
  queue.clear()
  out()

  def out(): Unit = {
    println("************************************************")
    try {
      println(queue.size)
      println(queue.isEmpty)
      println(queue)
    } catch {
      case e: Exception => println(e)
    }
    println("************************************************")
  }
}
