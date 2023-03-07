package com.slavik2121.leetcode.problem002;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * March 6, 2023
 *
 * 1309. Decrypt String from Alphabet to Integer Mapping
 * Difficulty: Easy
 *
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 *
 * It's guaranteed that a unique mapping will always exist.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * Example 2:
 *
 * Input: s = "1326#"
 * Output: "acz"
 * Example 3:
 *
 * Input: s = "25#"
 * Output: "y"
 * Example 4:
 *
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] only contains digits letters ('0'-'9') and '#' letter.
 * s will be valid string such that mapping is always possible.
 */
class DecryptString2 {
    private Map<Integer, String> alphabet;
    private static String hashTag = "#";
    public DecryptString2(){
        alphabet = new HashMap<>();
        alphabet.put(1, "a");
        alphabet.put(2, "b");
        alphabet.put(3, "c");
        alphabet.put(4, "d");
        alphabet.put(5, "e");
        alphabet.put(6, "f");
        alphabet.put(7, "g");
        alphabet.put(8, "h");
        alphabet.put(9, "i");
        alphabet.put(10, "j");
        alphabet.put(11, "k");
        alphabet.put(12, "l");
        alphabet.put(13, "m");
        alphabet.put(14, "n");
        alphabet.put(15, "o");
        alphabet.put(16, "p");
        alphabet.put(17, "q");
        alphabet.put(18, "r");
        alphabet.put(19, "s");
        alphabet.put(20, "t");
        alphabet.put(21, "u");
        alphabet.put(22, "v");
        alphabet.put(23, "w");
        alphabet.put(24, "x");
        alphabet.put(25, "y");
        alphabet.put(26, "z");
    }

    public String freqAlphabets(String s) {
        StringBuffer output = new StringBuffer();
        StringBuffer currentChar = new StringBuffer();
        int i = 0;

        while (i < s.length()) {
            if((i+2) < s.length() && String.valueOf(s.charAt(i+2)).equals(hashTag)) { // this char is double-digit char
                currentChar.append(s.charAt(i));
                currentChar.append(s.charAt(i+1));
                i = i+3;
            } else { // this char is single-digit char
                currentChar.append(s.charAt(i));
                i = i+1;
            }
            output.append(alphabet.get(Integer.parseInt(currentChar.toString())));
            currentChar.setLength(0);
        }

        return output.toString();
    }
}