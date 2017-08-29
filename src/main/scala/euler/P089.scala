package main.scala.euler

import scala.util.control.Breaks.{break, breakable}

object P089 {

  val romanNumerals = List(("M", 1000),("CM", 900), ("D", 500), ("CD", 400), ("C", 100), ("XC", 90),
    ("L", 50), ("XL",40), ("X", 10), ("IX", 9), ("V", 5), ("IV", 4), ("I", 1))
  /**
    * Euler Problem 89. Converts number to Roman then number then compares the length of strings respectively
    * @param list
    * @return
    */
  def romanNumerals(list: Array[String]): Long = {
    var sum: Long = 0
    for(romanNumeral <- list) {
      sum += numberToRoman(romanToNumber(romanNumeral)).length - romanNumeral.length
    }
    sum
  }

  def romanToNumber(str: String): Long = {
    var s = str
    var sum:Long = 0
    while (!s.isEmpty) {
      breakable {
        for (romanNumeral <- romanNumerals) {
          if (s.startsWith(romanNumeral._1)) {
            s = s.replaceFirst(romanNumeral._1, "")
            sum += romanNumeral._2
            break
          }
        }
      }
    }
    sum
  }


  def numberToRoman(num: Long): String = {
    var n = num
    var s = new StringBuilder
    while (n > 0) {
      for (romanNumeral <- romanNumerals) {
        if (n >= romanNumeral._2) {
          s ++= (romanNumeral._1 * (n / romanNumeral._2).toInt)
          n %= romanNumeral._2
        }
      }
    }
    s.toString
  }
  
  //TODO: Refactor
}
