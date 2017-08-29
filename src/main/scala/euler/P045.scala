package main.scala.euler

object P045 {
  def triangularPentagonalHexagonal(t: Int = 285, p: Int = 165, h: Int = 143):Long = {
    var h2: Int = h + 1
    var sum: Long = 0
    while (true) {
      // All hexagonals are triangulars. Need to check for pentagonal.
      sum = h2 * (2 * h2 - 1)
      if (isPentagonal(sum)) {
        return sum
      }
      h2+= 1
    }
    0
  }

  def isPentagonal(n: Long): Boolean = {
    var penTest = (Math.sqrt(1 + 24 * n) + 1.0) / 6.0
    penTest == penTest.toInt
  }
}
