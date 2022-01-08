package com.shockang.study.algorithm.scala.archive.stack

object Main extends App {
  //var stack: Stack[Int] = new ArrayStack(5)
  var stack: Stack[Int] = new LinkedListStack()
  out(stack)
  try {
    stack.pop()
  } catch {
    case e: Exception => println(e)
  }
  stack.push(0)
  stack.push(1)
  stack.push(2)
  stack.push(3)
  stack.push(4)
  out(stack)
  stack.push(5)
  out(stack)
  println(stack.pop())
  println(stack.pop())
  out(stack)
  stack.clear()
  out(stack)

  def out(stack: Stack[Int]): Unit = {
    println("************************************************")
    try {
      println(stack.size)
      println(stack.isEmpty)
      println(stack)
      println(stack.peek())
    } catch {
      case e: Exception => println(e)
    }
    println("************************************************")
  }

}
