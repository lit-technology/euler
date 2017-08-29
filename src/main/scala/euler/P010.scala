package main.scala.euler

import main.scala.utils.Primes

object P010 {

  /**
    * Euler Problem 10.
    * @param limit Top limit for primes
    * @return Sum of all prime numbers below Limit
    */
  def summationOfPrimes(limit: Int): Long = {
    Primes.primesArray(limit).sum
  }
}
