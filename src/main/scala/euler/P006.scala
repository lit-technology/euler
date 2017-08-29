package main.scala.euler

object P006 {

  /**
    * Euler Problem 6. Brute forced
    * @param count Number of squaring to do
    * @return (0+1+..count) squared - (1)squared + ... + (count)squared
    */
  def sumSquareDifference(count:Int):Long = {
    var sumSquare = 0
    var squareSum = 0
    for(i <- 1 to count) {
      sumSquare += i * i
      squareSum += i
    }
    squareSum = squareSum * squareSum
    squareSum - sumSquare
  }
}
