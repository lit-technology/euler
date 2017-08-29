package main.scala.euler

object P020 {

  /**
    * Euler Problem 20.
    * @param exponent
    * @return
    */
  def factorialDigitSum(exponent:Int = 100): BigInt = {
    var sum: BigInt = 1
    for (i <- 2 to exponent) {
      sum *= i
    }
    sum.toString.map(_.toInt - 48).sum
  }
}
