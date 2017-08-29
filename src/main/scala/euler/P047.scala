package main.scala.euler

import main.scala.utils.Primes

object P047 {

  /**
    * 
    * @param ps
    * @param target
    * @return
    */
  def distinctPrimeFactors(ps: Int = 4, target: Int = 4): Int = {
    val primes = PrimeSieve.primes(10000)
    var i = primes.slice(0, ps).product
    while (true) {
      if (Primes.numberOfPrimeFactors(i, primes) >= ps) {
        var count = 1
        var l = i - 1
        var r = i + 1
        while (Primes.numberOfPrimeFactors(l, primes) >= ps && count < target) {
          count += 1
          l -= 1
        }
        while (Primes.numberOfPrimeFactors(r, primes) >= ps && count < target) {
          count += 1
          r += 1
          i += 1 // Don't recalculate this on next I loop.
        }
        if (count == target) {
          // Last iteration of L loop would have decremented L by 1
          if (Primes.numberOfPrimeFactors(l + 1, primes) >= ps) {
            return l + 1
          } else {
            return i
          }
        }
      }
      // Skip by target -1
      // E.g 1..4 if target = 4. Inner loop will check 2,3,4,5,6,7 regardless.
      i += target - 1
    }
    0
  }
}
