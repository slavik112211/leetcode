package com.slavik2121.leetcode.problem002;

import java.util.AbstractMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * November 22, 2021
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
class DecryptString {
    public String freqAlphabets(String s) {
        final Integer N = 1000;
        final String delimiter = "#";
        StringBuffer output = new StringBuffer();

        Map<String, String> alphabet = Map.ofEntries(
                new AbstractMap.SimpleEntry<>("1", "a"),
                new AbstractMap.SimpleEntry<>("2", "b"),
                new AbstractMap.SimpleEntry<>("3", "c"),
                new AbstractMap.SimpleEntry<>("4", "d"),
                new AbstractMap.SimpleEntry<>("5", "e"),
                new AbstractMap.SimpleEntry<>("6", "f"),
                new AbstractMap.SimpleEntry<>("7", "g"),
                new AbstractMap.SimpleEntry<>("8", "h"),
                new AbstractMap.SimpleEntry<>("9", "i"),
                new AbstractMap.SimpleEntry<>("10", "j"),
                new AbstractMap.SimpleEntry<>("11", "k"),
                new AbstractMap.SimpleEntry<>("12", "l"),
                new AbstractMap.SimpleEntry<>("13", "m"),
                new AbstractMap.SimpleEntry<>("14", "n"),
                new AbstractMap.SimpleEntry<>("15", "o"),
                new AbstractMap.SimpleEntry<>("16", "p"),
                new AbstractMap.SimpleEntry<>("17", "q"),
                new AbstractMap.SimpleEntry<>("18", "r"),
                new AbstractMap.SimpleEntry<>("19", "s"),
                new AbstractMap.SimpleEntry<>("20", "t"),
                new AbstractMap.SimpleEntry<>("21", "u"),
                new AbstractMap.SimpleEntry<>("22", "v"),
                new AbstractMap.SimpleEntry<>("23", "w"),
                new AbstractMap.SimpleEntry<>("24", "x"),
                new AbstractMap.SimpleEntry<>("25", "y"),
                new AbstractMap.SimpleEntry<>("26", "z")
        );

        int i = 0;
        while(i < N) {
            if(i >= s.length()) break;

            //check if a double-digit letter (i.e. "25#")
            if((i + 2 < s.length()) && String.valueOf(s.charAt(i + 2)).equals(delimiter)) {
                output.append(alphabet.get(s.substring(i,i + 2)));
                i = i + 3;
            } else {
                output.append(alphabet.get(s.substring(i,i + 1)));
                i = i + 1;
            }
        }

        return output.toString();
    }
}