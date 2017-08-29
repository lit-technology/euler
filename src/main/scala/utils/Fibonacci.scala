package main.scala.utils

object Fibonacci {

  def thousandDigitFibonacciNumber(digits: Int = 1000): Int = {
    var i,a,b,tmp = 1
    while (a.toString.length >= digits) {
      tmp = b
      b = a + b
      a = tmp
      i+= 1
    }
    i
  }
}
