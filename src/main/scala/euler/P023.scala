package main.scala.euler

import main.scala.utils.{Factor, Primes}

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

object P023 {

  /**
    * Euler Problem 23. Not done.
    * Abundant number = Divisors > current Number.
    * @param min 12
    * @param max 28123
    * @return
    */
  def nonAbundantSums(min: Long = 12, max: Long = 28123): Long = {
    var primes = ListBuffer[Long]()
    var abundantNums = ListBuffer[Long]()
    for (i <- 2L to max) {
      if (Primes.isPrime(i.toInt)) {
        primes += i
      }
      if (Factor.sumOfFactors(i, primes.toList) > i) {
        abundantNums += i
      }
    }
    var abundantIndexes = Array.fill(max.toInt)(false)
    breakable {
      for (i <- min to max) {
        for (j <- i to max) {
          val abundantSum = abundantNums(i.toInt) + abundantNums(j.toInt)
          if (abundantSum <= max) {
            abundantIndexes(abundantSum.toInt) = true
          } else {
            break
          }
        }
      }
    }
    var sum: Long = 0
    for (i <- min to max) {
      if (abundantIndexes(i.toInt)) {
        sum += i
      }
    }
    sum
  }
}
