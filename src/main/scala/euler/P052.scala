package main.scala.euler

import main.scala.utils.Primes
import scala.util.control.Breaks.{break, breakable}
object P052 {
  /**
    * Calculates a prime sum table for p1+p2..pn is the last prime before limit.
    * Using these values, it can find values for prime consecutive between k1 and k2 for 0..k1..k2..pn+1.
    * E.g 7..13 consecutive = 2..13 consecutive - 2..5 consecutive.
    * 7+11+13 = 31. 2+3+5+7+11+13 = 41 - 2+3+5 (10) = 31. 
    * Next, using a nested loop representing S = start prime sum and E = end prime sum, 
    * iterates the E prime index backwards for each S prime starting point.
    * If S..E consecutive - E consecutive is prime, set max consecutive as E index - S index.
    * The inner loop breaks if E - S index < max consecutive found.
    * @param limit
    */
  def consecutivePrimeSum(limit: Int = 1000000): Unit = {
    var primes = PrimeSieve.primes(limit)
    var primesSum = Primes.primesSumArray(primes, limit)
    var primesSet = primes.toSet
    var max = 0
    var maxPrimeConsecutiveSum = 0
    for (i <- primesSum.indices) { // Left Prime Index of consecutive sum
      breakable {
        for (j <- primesSum.length - 1 to 0 by -1) {
          // Right Prime Index of consecutive sum.
          if (j - i < max) {
            // If PrimeIndex j - PrimeIndex i > Max Prime Indexes
            //TODO: Break
          } else if (primesSet.contains(primesSum(j) - primesSum(i))) {
            max = j - i
            maxPrimeConsecutiveSum = primesSum(j) - primesSum(i)
          }
        }
      }
    }
    println(max)
    println(maxPrimeConsecutiveSum)
  }
}
