import java.util

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}




def primesArray(n: Int): Array[Int] = {
  var primes = new ArrayBuffer[Int]()
  primes += 2
  primes += 3
  val bits = new util.BitSet()
  for (prime <- primes) {
    for (i <- prime * prime to n by + prime) {
      bits.set(i, true)
    }
  }
  var prime = 3
  while (prime < n) {
    prime += 2
    while (bits.get(prime)) {
      prime += 2
    }
    var primeSq = prime * prime // Integer overflow
    if (primeSq > 0) {
      for (i <- primeSq to n by +prime) {
        bits.set(i, true)
      }
    }
    primes += prime
  }
  primes.toArray
}