package com.crajas.codesignal.practice.arrays;

/**
 * 
 * Given a string s consisting of small English letters, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.
 * 
 * Example
 * 
 * For s = "abacabad", the output should be
 * solution(s) = 'c'.
 * 
 * There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.
 * 
 * For s = "abacabaabacaba", the output should be
 * solution(s) = '_'.
 * 
 * There are no characters in this string that do not repeat.
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] string s
 * 
 * A string that contains only lowercase English letters.
 * 
 * Guaranteed constraints:
 * 1 <= s.length <= 105.
 * 
 * [output] char
 * 
 * The first non-repeating character in s, or '_' if there are no characters that do not repeat.
 * 
 *  
 * 
 * @author rcmohan@gmail.com
 *
 */
public class FirstNonRepeatingCharacter {
	
	char solution(String s) {
	    int[]pos = new int[26];
	    
	    // Initialize -2 for all characters [a-z]
	    for(int i = 0; i < 26; ++i) pos[i] = -2;
	    
	    // -2 = character never appeared, -1 = character appeared more than once, > -1 = position the character appeared
	    for(int k = 0; k < s.length(); ++k) {
	        char c = s.charAt(k);
	        int j = c-'a';
	        int curr = pos[j];
	        if(curr > -2) {
	            pos[j] = -1;
	        } else {
	            pos[j] = k;
	        }
	    }
	    int min = Integer.MAX_VALUE;
	    int c = -1;
	    for(int k = 0; k < 26; ++k) {
	        if (pos[k] < min && pos[k] >= 0) {
	            min = pos[k];
	            c = k;
	        }
	    }
	    
	    return (c >= 0) ? (char)('a' + c) : '_';
	    
	}

}
