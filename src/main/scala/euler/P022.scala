package main.scala.euler

import scala.io.Source

object P022 {

  /**
    * Euler Problem 22. Could be optimized further for reading / sorting names 
    * @param fileName
    * @return
    */
  def namesScore(fileName: String): Long = {
    var file = Source.fromURL(getClass.getResource(fileName))
    var names = file.mkString.replaceAll("\"", "").split(",").sortBy(name => name)
    var sum: Long = 0
    for (i <- names.indices) {
      sum += (i + 1) * nameScore(names(i))
    }
    sum
  }

  def nameScore(s: String): Long = {
    var sum = 0
    for (c <- s.toCharArray) {
      sum += (c - 64)
    }
    sum
  }
}
