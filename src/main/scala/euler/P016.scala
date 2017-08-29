package main.scala.euler

object P016 {

  /**
    * Euler Problem 16
    * @param base
    * @param exponent
    * @return
    */
  def powerDigitSums(base: Int = 2, exponent: Int = 1000): Int = {
    BigInt(base).pow(exponent).toString.map( _.toInt - 48).sum
  }
}
