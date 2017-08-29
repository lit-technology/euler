package main.scala.euler

object P029 {

  /**
    * Euler Problem 29.
    * @param a
    * @param b
    * @return
    */
  def distinctPowers(a: Int = 100, b: Int = 100): Int = {
    var distinctPows = Set[Double]()
    for (i <- 2 to a) {
      for (j <- 2 to b) {
        distinctPows += math.pow(i, j)
      }
    }
    distinctPows.size
  }
}
