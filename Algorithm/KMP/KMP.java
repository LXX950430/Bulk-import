package com.algorithm.KMP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The algorithm of KMP.
 * 
 * Note:
 * The core of the algorithm is to use the previously matched result,
 * that is, no longer backtracking, 
 * so that the O(M*N) of the brute force algorithm is reduced to O(M+N), 
 * The the matching process is the same as that of the next, and the matching is used the previously result.
 * @author willl 2019-6-16
 */
public class KMP {
	/**
	 * This method is used to get the index of firstly compared String.
	 * <p>
	 * The note of the KMP algorithm: 
	 * Firstly will compare each character of the string with the string of pattern. 
	 * Secondly if the string's character is not equals pattern string's character will get the pattern's firstly not equals
	 * character's index from next table. 
	 * 1) if next table's element equals -1 mean that current pattern string's index equals 0.
	 * 
	 * @param str     - The string of input.
	 * @param pattern - The string of pattern.
	 * @param next    - This is a table , which is used to store the index of pattern string.
	 * @return 		  - Returns the first matching subscript of the character to be matched.
	 */
	private static List<Integer> kmp(String str, String pattern, int next[]) {
		List<Integer> matchedList = new ArrayList<>();
		// The variable of str's index.
		int i = 0;
		// The variable of pattern string's index.
		int j = 0;
		while (i < str.length() && j < pattern.length()) {
			if (str.charAt(i) == pattern.charAt(j)) {
				j++;
				i++;
			} else {
				if (next[j] == -1) {
					i++;
					j = 0;
				} else {
					j = next[j];
				}
			}

			// if pattern string's each character match the part of the string , return the
			// index of firstly character of the matched string.
			if (j == pattern.length()) {
				matchedList.add(i - j);
				j = 0;
			}
		}
		// if the pattern string is not match the string will return -1 means that the
		// pattern string is not match the string.
		return matchedList;
	}

	/**
	 * This method is the core of KMP which is used to confirm the index for pattern's back tracking's index.
	 * @param next    - This array will record the index of the pattern string.
	 * @param pattern - The string of pattern.
	 * @return - Return next array.
	 */
	private static int[] getNext(int next[], String pattern) {
		// The index of pattern string and initialize with 0.
		int j = 0;
		// The index of next array and initialize with -1 mean that no matched
		// character.
		int t = -1;
		char[] patternArray = pattern.toCharArray();
		// Initialize the first element
		next[0] = -1;
		// Predicting the j+1th bit based on the known previous j-bit
		while (j < patternArray.length - 1) {
			if (t == -1 || patternArray[j] == patternArray[t]) {
				// The index of pattern is not back tracing.
				j++;
				t++;
				// Store the matched pattern character's index as next array's element.
				next[j] = t;
			} else {
				/**
				 * If pattern is not equal to the previously matched characters, then the next
				 * element that matched the last match is found back to match.
				 * 
				 */
				t = next[t];
			}
		}
		return next;
	}

	/**
	 * The method of main.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = "AABABABBDABABABBC";//input.next();
		//input.next();
		String pattern = "ABABABB";//input.next();
		int[] next = new int[pattern.length()];
		next = getNext(next, pattern);
		List matchedList = kmp(str, pattern, next);
		if(matchedList.size() > 0) {
			System.out.print(matchedList.size());
		}else {
			System.out.print("Pattern string is not match string!");
		}
		
	}

}
