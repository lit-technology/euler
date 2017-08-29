package main.java;

import java.util.Arrays;
import java.util.BitSet;

/**
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * 
 */
public class PrimeSieve {
	
	private int[] primes;
	private final BitSet bits;
	
	public PrimeSieve(int max, int size) {
		this.primes = new int[] {2, 3};
		bits = new BitSet(size);
		for (int prime : primes) {
			// Need to only filter from p squared. 
			sieve(prime, size);
		}
		resize(max);
	}
	
	/**
	 * Gets the specified nth Prime.
	 * @param n
	 * @return Prime Number.
	 */
	public int get(int n) {
		resize(n + 1);
		return primes[n];
	}
	
	/**
	 * Returns all the Primes from 0..n
	 * @param n
	 * @return Array of Primes.
	 */
	public int[] primes(int n) {
		resize(n + 1);
		return primes;
	}
	
	private void resize(int size) {
		int i = primes.length;
		if (i < size) {
			primes = Arrays.copyOf(primes, size);
			while (i < size) {
				int prime = primes[i - 1] + 2;
				while (bits.get(prime)) {
					prime += 2;
				}
				sieve(prime);
				primes[i] = prime;
				i += 1;
			}
		}
	}
	
	private void sieve(int prime) {
		for (int i = prime * prime; i < bits.length(); i += prime) {
			bits.set(i, true);
		}
	}
	
	private void sieve(int prime, int size) {
		for (int i = prime * prime; i < size; i += prime) {
			bits.set(i, true);
		}
	}
	
	public void reSieve(int size) {
		int originalSize = bits.length();
		for (int prime: primes) {
			for (int i = originalSize; i < size; i+= prime) {
				bits.set(i, true);
			}
		}
	}
}
