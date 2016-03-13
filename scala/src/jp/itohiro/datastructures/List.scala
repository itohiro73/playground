package jp.itohiro.datastructures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1
    case Cons(0.0, xs) => 0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil // answer throws error i.e. sys.error("trail of empty list")
    case Cons(_, xs) => xs
  }

  def setHead[A](as: List[A], z: A): List[A] = as match {
    case Nil => Nil // answer throws error i.e. sys.error("setHead on empty list")
    case Cons(_, xs) => Cons(z, xs)
  }
}
