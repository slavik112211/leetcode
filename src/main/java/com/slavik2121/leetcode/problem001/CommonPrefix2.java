package com.slavik2121.leetcode.problem001;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * March 6, 2023
 *
 * 14. Longest Common Prefix
 * Difficulty: Easy
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
class CommonPrefix2 {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer commonPrefix = new StringBuffer();

        // Determine shortest word in the list
        int shortestWordIndex = 0;
        int shortestWordLength = 1000;
        String currentWord;
        for(int i = 0; i < strs.length; i++) {
            currentWord = strs[i];
            if(currentWord.length() < shortestWordLength) {
                shortestWordIndex = i;
                shortestWordLength = currentWord.length();
            }
        }

        // Determine longest common prefix
        char currentCharLHS, currentCharRHS;
        for(int i = 0; i < shortestWordLength; i++) {
            boolean allCharsMatch = true;
            currentCharLHS = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                currentCharRHS = Character.valueOf(strs[j].charAt(i));
                if(Character.valueOf(currentCharLHS).compareTo(currentCharRHS) != 0) {
                    allCharsMatch = false;
                    break;
                }
            }
            if(allCharsMatch) {
                commonPrefix.append(currentCharLHS);
            } else {
                break;
            }
        }

        return commonPrefix.toString();
    }
}