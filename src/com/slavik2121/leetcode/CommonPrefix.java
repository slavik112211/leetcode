package com.slavik2121.leetcode;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * November 21, 2021
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
class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer commonPrefix = new StringBuffer();
        Boolean stringsDiverged = false;
        Boolean currentCharIndexOutOfBounds = false;
        String currentCharLHS, currentCharRHS;

        // iteration over character index
        for (int i = 0; i < 200; i++) {
            if(strs[0].length() > i) {
                currentCharLHS = String.valueOf(strs[0].charAt(i));
            } else {
                currentCharLHS = "";
                currentCharIndexOutOfBounds = true;
            }

            // iteration over word index
            for (int j = 1; j < 200; j++) {
                if(!(strs.length > j)) break; // no additional words to compare first word to

                if(strs[j].length() > i) {
                    currentCharRHS = String.valueOf(strs[j].charAt(i));
                } else {
                    currentCharRHS = "";
                }

                if(!currentCharLHS.equals(currentCharRHS)) {
                    stringsDiverged = true;
                    break;
                }
            }

            if(stringsDiverged) {
                break;
            } else {
                commonPrefix.append(currentCharLHS);
            }
            if(currentCharIndexOutOfBounds) break;
        }
        return commonPrefix.toString();
    }

    public static void main(String[] args) {
        String[] strs;
        CommonPrefix commonPrefix = new CommonPrefix();

        strs = new String[]{"flower","flow","flight"};
        System.out.println(commonPrefix.longestCommonPrefix(strs));

        strs = new String[]{"flow","flow","flow"};
        System.out.println(commonPrefix.longestCommonPrefix(strs));

        strs = new String[]{"flight"};
        System.out.println(commonPrefix.longestCommonPrefix(strs));

        strs = new String[]{""};
        System.out.println(commonPrefix.longestCommonPrefix(strs));

        strs = new String[]{"flower","flow"};
        System.out.println(commonPrefix.longestCommonPrefix(strs));

        strs = new String[]{"dog","racecar","car"};
        System.out.println(commonPrefix.longestCommonPrefix(strs));
    }
}