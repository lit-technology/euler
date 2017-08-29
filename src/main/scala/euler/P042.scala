package main.scala.euler

object P042 {

  /**
    * Euler Problem 42
    * @param words Array of capitalized words
    * @return Count of Triangular Words
    */
  def codedTriangleNumbers(words: Array[String]): Int = {
    var count = 0
    var n = 1
    var current = 0
    var triangleNumbers = Set[Int]()
    for (word <- words) {
      val v = word.toCharArray.foldLeft(0)(_ + _.toInt - 64)
      while (current < v) {
        current = n * (n + 1) / 2
        triangleNumbers += current
        n += 1
      }
      if (triangleNumbers.contains(v)) {
        count += 1
      }
    }
    count
  }
}
