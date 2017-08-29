package main.scala.euler

object P001 {

  /**
    * Euler Problem 1
    * @param limit Top limit for multiples
    * @return Sum of all 3/5 multiples from 0 -> Limit
    */
  def multiplesOf3And5(limit:Int):Int = {
    var threes: Int = 3
    var sum: Int = 0
    while (threes < limit) {
      sum += threes
      threes += 3
    }
    var fives: Int = 5
    while (fives < limit) {
      if (fives % 3 != 0) {
        sum += fives
      }
      fives += 5
    }
    sum
  }
}
