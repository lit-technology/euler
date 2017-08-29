package main.scala.euler

object P009 {

  /**
    * Euler Problem 9. a < b < c, a cannot be greater than 1/3, b cannot be greater than 1/2. 
    * @param equals Sum of a,b,c to equals
    * @return Product of a,b,c
    */
  def specialPythagoreanTriplet(equals: Int = 1000): Int = {
    for(a <- 1 to equals/3) {
      for(b <- a + 1 to equals/2) {
        val c = equals - a - b
        if (a*a + b*b == c*c) {
          return a*b*c
        }
      }
    }
    0
  }
}
