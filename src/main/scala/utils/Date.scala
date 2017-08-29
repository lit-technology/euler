package main.scala.utils

object Date {

  def isLeapYear(year:Int): Boolean = {
    year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)
  }
}
