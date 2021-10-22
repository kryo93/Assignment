package com.incubyte.app;

import com.incubyte.function.SumFunction;

public class App {

	public static void main(String[] args) {
		String str = "//,|;|p\n2;3p4;5";
		SumFunction sumFunction = new SumFunction();
		sumFunction.callAddFunction(str);
	}
}
