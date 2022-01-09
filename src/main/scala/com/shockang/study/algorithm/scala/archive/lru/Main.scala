package com.shockang.study.algorithm.scala.archive.lru

object Main extends App {
  // val lru: ArrayLruCache[Int, String] = new ArrayLruCache(5)
  // val lru: LinkedListLruCache[Int, String] = new LinkedListLruCache(5)
  val lru: ListAndMapLruCache[Int, String] = new ListAndMapLruCache(5)
  lru.put(0, "0")
  lru.put(1, "1")
  lru.put(2, "2")
  // scalastyle:off println
  println(lru)
  println(lru.get(1))
  lru.put(1, "11")
  println(lru.get(1))
  println(lru)
  lru.put(3, "3")
  lru.put(4, "4")
  lru.put(5, "5")
  println(lru)
  println(lru.get(1))
  lru.put(1, "12")
  println(lru.get(1))
  println(lru)
  println(lru.get(3))
  lru.put(3, "31")
  println(lru.get(3))
  println(lru)
  lru.remove(1)
  println(lru)
  lru.remove(3)
  println(lru)
  // scalastyle:on println
}
