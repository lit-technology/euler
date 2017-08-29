package main.scala.euler

object P034 {

  /**
    * Euler Problem 34. The upper bound is calculated using 9! * 7 = 2540160 (7 digits)
    * and 9! * 8 = another 7 digit number.
    * @return
    */
  def digitFactorials(): Int = {
    var sum = 0
    var factorials = new Array[Int](10)
    var factorialsSum = 1
    factorials(0) = factorialsSum
    for (i <- 1 to 9) {
      factorialsSum *= i
      factorials(i) = factorialsSum
    }
    var factorialDigits = 0
    for (i <- 10 to 2540161) {
      factorialDigits = i.toString.toCharArray.foldLeft(0)((a, b) => a + factorials(b.toInt - 48).toInt)
      if (factorialDigits == i) {
        sum += factorialDigits
      }
    }
    sum
  }
}
