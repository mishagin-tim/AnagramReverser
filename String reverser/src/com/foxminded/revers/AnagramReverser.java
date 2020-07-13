/**
 * The StringReverser class provides a functionality
 * to reverse a string.
 * 
 * If a string contains non-letter symbols (like numbers,
 * slashes, commas and etc) it saves their position after a reverse.
 * 
 * If a string is a composition of words, you can reverse it
 * word by word using specific delimiter. See examples (2) and (3)
 * 
 * Examples:
 * 1) "abc" => "cba"
 * 2) "abcd efgh" => "dcba hgfe"
 * 3) "a1bcd efg!h" => "d1cba hgf!e" (Focus on non-letters)
 */
package com.foxminded.revers;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;


public class AnagramReverser {

	private final String REGEX_ALL_EXCEPT_LATINS = "[^a-zA-Z]";
	private final String DEFAULT_DELIMITER = " ";

	public String reverse(String str) {

		if (str == null) {
			throw new NullPointerException("Input string can't be null");
		}

		String[] stringArray = str.split(DEFAULT_DELIMITER);

		if (stringArray.length == 0) {
			throw new IllegalArgumentException("String has no words");
		}

		for (int i = 0; i < stringArray.length; i++) {
			List<Pair<Character, Integer>> listSymbolIndex = getNonLettersIndexes(stringArray[i]);
			String stringOnlyLetters = removeNonLettersFromString(stringArray[i]);
			
			String reversedStringOnlyLetters = new StringBuilder(stringOnlyLetters).reverse().toString();

			String reversedStringMergedWithNonLetters = mergeStringWithCharIndexList(reversedStringOnlyLetters,
					listSymbolIndex);

			stringArray[i] = reversedStringMergedWithNonLetters;
		}

		String reversedString = String.join(DEFAULT_DELIMITER, stringArray);

		return reversedString;
	}

	private List<Pair<Character, Integer>> getNonLettersIndexes(String str) {
		List<Pair<Character, Integer>> list = new ArrayList<Pair<Character, Integer>>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (Character.isLetter(c) == false) {
				list.add(new Pair<Character, Integer>(c, i));
			}
		}

		return list;
	}

	private String removeNonLettersFromString(String str) {
		/* Regex matches all symbols except latin letters 
		 * Regular expression's meaning is "All except latin letters */
		return str.replaceAll(REGEX_ALL_EXCEPT_LATINS, "");
	}

	private String mergeStringWithCharIndexList(String str, List<Pair<Character, Integer>> list) {
		StringBuilder builder = new StringBuilder(str);

		for (Pair<Character, Integer> obj : list) {
			builder.insert(obj.getValue().intValue(), obj.getKey());
		}

		String mergedString = builder.toString();

		return mergedString;
	}
}
