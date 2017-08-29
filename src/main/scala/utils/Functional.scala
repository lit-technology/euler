package main.scala.utils

object Functional {

  def sumUpperChars(chars: Array[Char]): Int = {
    chars.foldLeft(0)(_ + _.toInt - 64)
  }
}
