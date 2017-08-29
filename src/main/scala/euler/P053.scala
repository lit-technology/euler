package main.scala.euler

import main.scala.utils.Factorials

import scala.util.control.Breaks.{break, breakable}

object P053 {

  def combinatoricSelections(c: Int = 100, limit: Int = 1000000): Int = {
    var factorials = Factorials.factorialsMap(c)
    var count = 0
    for (n <- 1 to 100) {
      breakable {
        for (r <- 1 until n) {
          if (factorials(n) / (factorials(r) * factorials(n - r)) > limit) {
            // 23 C 10 == 23 C 13. r*(n-r)
            // Or (10!*13!) == (13!*10!
            // 23 C 11 (1352078) > 23 C 10 (1144066). Hence 10..13 or +3.
            count += (n-r-r)
            // If factorials(n) > limit, factorials(n) choose 0 always true.
            // E.g 10000001 / 0! * 0! (Remember 0! == 1) 
            if (factorials(n) > limit) {
              count += 1
            }
            break
          }
        }
      }
    }
    count
  }

}
