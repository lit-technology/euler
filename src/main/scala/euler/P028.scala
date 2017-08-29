package main.scala.euler

object P028 {

  /**
    * Euler Problem 28. 
    * @param count
    * @return
    */
  def numberSpiralDiagonals(count:Int = 1001): Long = {
    var sum: Long = 1
    var n: Long = 1
    for (i <- 1 to count/2) {
      for (j <- 1 to 4) {
        n += i * 2
        sum += n
      }
    }
    sum
  }
}
