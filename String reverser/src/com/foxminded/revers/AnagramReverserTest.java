/**
 *  TestCase for class StringReverser.
 *  
 *  Test its main functionality
 *  
 *  Asserts were created according to this convention
 *  	assertEquals(expected, actual)
 */
package com.foxminded.revers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Timur Mishagin
 * 
 *         Main TestCase
 */
class AnagramReverserTest {

	private AnagramReverser reverser;

	@BeforeEach
	void setUp() {
		reverser = new AnagramReverser();
	}

	@Test
	void reverseShouldReturnEmptyStringWhenInputStringIsEmpty() {
		assertEquals("", reverser.reverse(""));
	}

	@Test
	void reverseShouldThrowIllegalArgumentExceptionWhenInputStringHasOnlySpaces() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			reverser.reverse(" ");
			reverser.reverse("  ");
			reverser.reverse("      ");
		});
		assertEquals("String has no words", exception.getMessage());
	}

	@Test
	void reverseShouldThrowIllegalArgumentExceptionWhenInputStringIsNull() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			reverser.reverse(null);
		});
		assertEquals("Input string can't be null", exception.getMessage());
	}

	@Test
	void reverseShouldReturnUnchangedStringWhenStringHasOneSymbol() {
		assertEquals("a", reverser.reverse("a"));
		assertEquals("2", reverser.reverse("2"));
	}

	@Test
	void reverseShouldReturnReversedStringWhenInputStringHasOnlyLetters() {
		assertEquals("cba", reverser.reverse("abc"));
		assertEquals("cba edc", reverser.reverse("abc cde"));
		assertEquals("aaaaaaa", reverser.reverse("aaaaaaa"));
		assertEquals("olleh", reverser.reverse("hello"));
		assertEquals("ym eman si rumit", reverser.reverse("my name is timur"));
		assertEquals("aaaAAaaaAaa", reverser.reverse("aaAaaaAAaaa"));
	}

	@Test
	void reverseShouldReturnReversedStringWhereNonLettersStayUnchangedWhenInputStringHasNonletters() {
		assertEquals("d1cba", reverser.reverse("a1bcd"));
		assertEquals("d1cba hgf!e", reverser.reverse("a1bcd efg!h"));
	}

	@Test
	void reverseShouldReturnUnchangedStringWhenInputStringHasOnlyNonLetters() {
		assertEquals("@#!$@8344", reverser.reverse("@#!$@8344"));
		assertEquals("12345634 8784274 24241", reverser.reverse("12345634 8784274 24241"));
	}

	@Test
	void reverseShouldInitializeAnagramReverserObjectWhenItRequired() {
		AnagramReverser reverser = new AnagramReverser() {
		};
	}
}
