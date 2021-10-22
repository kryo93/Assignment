package com.incubyte.function;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.incubyte.exception.NegativeNumberException;

public class AddNumbersTest {

	private AddNumbers addNumbers;

	@Before
	public void setup() {
		addNumbers = new AddNumbers();
	}

	/**
	 * Test for case when a string of numbers is sent using delimiters as "," .
	 */
	@Test
	public void successCaseTest() throws Exception {
		Assert.assertEquals(addNumbers.addNumbers("1,2,3"), 6);
	}

	/**
	 * Test for case when a string of numbers is sent using delimiters as "," or
	 * "\n".
	 */
	@Test
	public void successCaseForNewLineTest() throws Exception {
		Assert.assertEquals(addNumbers.addNumbers("1,2\n3"), 6);
	}

	/**
	 * Test for case when a prohibited character is sent.
	 */
	@Test(expected = NumberFormatException.class)
	public void notAllowedEntryTest() throws Exception {
		addNumbers.addNumbers("1,2,x");
	}

	/**
	 * Test for case when a string sent is empty or null.
	 */
	@Test
	public void emptyOrNullCaseTest() throws Exception {
		Assert.assertEquals(addNumbers.addNumbers(""), 0);
		Assert.assertEquals(addNumbers.addNumbers(null), 0);
	}

	/**
	 * Test for case when a string of numbers sent have unwanted white spaces.
	 */
	@Test
	public void whiteSpacesIncludedTest() throws Exception {
		Assert.assertEquals(addNumbers.addNumbers(" "), 0);
		Assert.assertEquals(addNumbers.addNumbers(" 2,3"), 5);
	}

	/**
	 * Test for case when a string of numbers is sent using changed delimiters. I am
	 * allowing multiple delimiters separated by | regex until "\n" is found.
	 */
	@Test
	public void changeDelimiterTest() throws Exception {
		Assert.assertEquals(addNumbers.addNumbers("//,|;|p\n2;3p4;5"), 14);
		Assert.assertEquals(addNumbers.addNumbers("//,|;|_\n2;3_4;5"), 14);
	}

	/**
	 * Test for case when a string of numbers sent have negative values.
	 */
	@Test
	public void negativeNumbersTest() {
		NegativeNumberException exception = null;
		try {
			addNumbers.addNumbers("1,2,-4,-8");
		} catch (Exception e) {
			exception = (NegativeNumberException) e;
		}

		Assert.assertNotNull(exception);
		Assert.assertEquals("negatives values [-4, -8]", exception.getMessage());

	}
}
