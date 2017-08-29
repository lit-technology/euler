package main.scala.euler

import main.scala.utils.Date

object P019 {

  /**
    * Euler Problem 19. 
    * @param dayOfWeek Day of week starting from Sunday = 1 -> Sunday = 7   
    * @param fDay First Day
    * @param fMonth First Month
    * @param fYear First Year
    * @param lDay Last Day
    * @param lMonth Last Month
    * @param lYear Last Year
    * @return Number of Sundays that resides on First Day of a Month
    */
  def countingSundays(dayOfWeek: Int,  fDay:Int, fMonth:Int, fYear:Int, lDay:Int, lMonth:Int, lYear:Int): Long = {
    var date = dayOfWeek // 1,2,3,4,5,6,7
    var day = fDay
    var month = fMonth
    var year = fYear
    var months = Map(
      1 -> 31,
      2 -> 28, // This is changed every year
      3 -> 31,
      4 -> 30,
      5 -> 31,
      6 -> 30,
      7 -> 31,
      8 -> 31,
      9 -> 30,
      10 -> 31,
      11 -> 30,
      12 -> 31
    )
    var count = 0
    while (day != lDay || month != lMonth || year != lYear) {
      if (day == 1 && date == 1) {
        count += 1
      }
      date += 1
      if (date > 7) {
        date = 1
      }
      day += 1
      if (day > months(month)) {
        day = 1
        month += 1
      }
      if (month > 12) {
        month = 1
        year += 1
        if (Date.isLeapYear(year)) {
          months += (2 -> 29)
        } else {
          months += (2 -> 28)
        }
      }
    }
    count
  }
}
