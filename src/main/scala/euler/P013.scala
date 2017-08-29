package main.scala.euler

object P013 {

  /**
    * Euler Problem 13. Sums the first x+1th digits together, then turns sum to string of x length to number
    * @param digits Digits to add together See 
    * @param x First x digits to find of digits sum
    * @return X digits of sum of all parameter digits
    */
  def largeSum(digits: List[String], x: Int = 10): Long = {
    var sum: Long = 0
    for(digit <- digits) {
      val xDigits = digit.substring(0, x)
      sum += xDigits.toLong
    }
    sum.toString.substring(0, x-1).toLong
  }
}
