package main.scala.euler

object P048 {

  /**
    * 
    * @param digits N digits
    * @param pow 
    * @return
    */
  def selfPowers(digits: Int = 10, pow: Int = 1000): Long = {
    val upper = Math.pow(10, digits).toLong
    var sum: Long = 0
    var currentPow: Long = 0
    for (i <- 1 to pow) {
      currentPow = i
      for (j <- 1 until i) { // Does the power and modulos whenever.
        currentPow *= i
        if (currentPow >= Long.MaxValue / 1000) {
          currentPow %= upper
        }
      }
      sum = (sum + currentPow) % upper
    }
    sum
  }
}
