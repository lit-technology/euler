package main.scala.euler

import main.scala.utils.Primes

object P007 {

  /**
    * Euler Problem 7.
    * @param x Positive number
    * @return xTh prime number
    */
  def primeX(x:Int = 10001): Int = {
    Primes.primesArray(x * x)(x)
  }
}
