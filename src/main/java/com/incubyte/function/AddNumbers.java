package com.incubyte.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.incubyte.exception.NegativeNumberException;

public class AddNumbers {

	public int addNumbers(String str) throws Exception {
		int sum = 0;
		if (Objects.isNull(str) || str.isEmpty()) {
			return sum;
		}
		String delimiter = ",|\n";
		String originalString = str;
		if (str.startsWith("//")) {
			int startIndex = str.indexOf("//") + 2;
			int endIndex = str.indexOf("\n");
			delimiter = str.substring(startIndex, endIndex);
			originalString = str.substring(str.indexOf("\n") + 1);
		}
		return add(originalString, delimiter);
	}

	private int add(String str, String delimiter) throws Exception {
		int sum = 0;
		List<Integer> negativeNumbers = new ArrayList<>();
		String[] numbers = str.split(delimiter);
		for (String number : numbers) {
			if (!number.trim().isEmpty()) {
				int curr = Integer.parseInt(number.trim());
				if (curr < 0) {
					negativeNumbers.add(curr);
				} else {
					sum += curr;
				}
			}
		}
		if (negativeNumbers.size() > 0) {
			throw new NegativeNumberException("negatives values " + negativeNumbers);
		}
		return sum;
	}

}
