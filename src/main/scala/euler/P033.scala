package main.scala.euler

import main.scala.utils.Factor

object P033 {

  /**
    * Euler Problem 33.
    * @return
    */
  def digitCancellingFractions(): Long = {
    var denominatorProduct: Int = 1
    var numeratorProduct: Int = 1
    for (i <- 1 to 10) {
      for (denominator <- 1 to i) {
        for (numerator <- 1 to denominator) {
          if ((numerator * 10 + 1) * denominator == (denominator * 10 + 1) * numerator) {
            numeratorProduct *= numerator
            denominatorProduct *= denominator
          }
        }
      }
    }
    Factor.gcd(denominatorProduct, numeratorProduct)
  }
}
