package main.scala.euler

import scala.util.control.Breaks.{break, breakable}

object P046 {
  def goldbachsOtherConjecture(): Long = {
    var primes = PrimeSieve.primes(10000)
    var i: Long = 5
    var j: Int = 0
    var prime: Int = 0
    var isGoldbach: Boolean = false
    while (true) {
      j = 0
      prime = primes(j)
      isGoldbach = false
      breakable {
        while (i >= prime) {
          if (isDoubleSquare(i - prime)) {
            isGoldbach = true
            break
          }
          j += 1
          prime = primes(j)
        }
      }
      if (!isGoldbach) {
        return i
      }
      i += 2
    }
    0
  }

  def isDoubleSquare(n: Double): Boolean = {
    isSquare(n/2)
  }

  def isSquare(n: Double): Boolean = {
    var sqrt = Math.sqrt(n)
    sqrt == sqrt.toInt
  }
}
