package com.incubyte.function;

public class SumFunction {

	public void callAddFunction(String str) {
		AddNumbers addNumbers = new AddNumbers();

		try {
			int res = addNumbers.addNumbers(str);
			System.out.println("The numbers you entered have sum of " + res);
		} catch (Exception e) {
			System.out.println("Entry not allowed " + e.getMessage());
		}

	}
}
