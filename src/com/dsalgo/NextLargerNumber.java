/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/NextLargerNumber.php.html
 */

package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class NextLargerNumber {

	/**
	 * given a number whose digits are unique find the next bigger number formed
	 * by those digits
	 *
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		System.out.println("5963=>" + getNextLarger(5963));
		System.out.println("3784=>" + getNextLarger(3784));
		System.out.println("9531=>" + getNextLarger(9531));
		System.out.println("1234=>" + getNextLarger(1234));
		System.out.println("3=>" + getNextLarger(3));
	}

	private static int getNextLarger(int decimalNumber) {
		List<Integer> digits = numberToDigits(decimalNumber);
		int rightBiggerIndex = -1;
		for (int i = digits.size() - 1; i > 0; i--) {
			if (digits.get(i) > digits.get(i - 1)) {
				rightBiggerIndex = i;
				break;
			}
		}
		if (rightBiggerIndex != -1) {
			swap(digits, rightBiggerIndex, rightBiggerIndex - 1);
			sort(digits, rightBiggerIndex, digits.size());
		}
		return digitsToNumber(digits);

	}

	private static List<Integer> numberToDigits(int number) {
		List<Integer> digits = new ArrayList<>();
		while (number > 0) {
			digits.add(0, number % 10);
			number /= 10;
		}
		return digits;
	}

	private static int digitsToNumber(List<Integer> digits) {
		int number = 0;
		for (Integer digit : digits) {
			number *= 10;
			number += digit;
		}
		return number;
	}

	private static void sort(List<Integer> digits, int startIndex, int endIndex) {
		if (startIndex == endIndex)
			return;
		for (int k = startIndex; k < endIndex - 1; ++k)
			for (int l = startIndex + 1; l < endIndex; ++l) {
				if (digits.get(k) > digits.get(l))
					swap(digits, k, l);
			}

	}

	private static void swap(List<Integer> digits, int i, int j) {
		Integer temp = digits.get(i);
		digits.set(i, digits.get(j));
		digits.set(j, temp);
	}
}
