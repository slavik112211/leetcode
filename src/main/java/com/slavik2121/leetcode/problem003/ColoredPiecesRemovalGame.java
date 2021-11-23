package com.slavik2121.leetcode.problem003;

/**
 * https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 * November 22, 2021
 *
 * 2038. Remove Colored Pieces if Both Neighbors are the Same Color
 * Difficulty: Medium
 *
 * There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'. You are given a string colors of length n where colors[i] is the color of the ith piece.
 *
 * Alice and Bob are playing a game where they take alternating turns removing pieces from the line. In this game, Alice moves first.
 *
 * Alice is only allowed to remove a piece colored 'A' if both its neighbors are also colored 'A'. She is not allowed to remove pieces that are colored 'B'.
 * Bob is only allowed to remove a piece colored 'B' if both its neighbors are also colored 'B'. He is not allowed to remove pieces that are colored 'A'.
 * Alice and Bob cannot remove pieces from the edge of the line.
 * If a player cannot make a move on their turn, that player loses and the other player wins.
 * Assuming Alice and Bob play optimally, return true if Alice wins, or return false if Bob wins.
 *
 *
 *
 * Example 1:
 *
 * Input: colors = "AAABABB"
 * Output: true
 * Explanation:
 * AAABABB -> AABABB
 * Alice moves first.
 * She removes the second 'A' from the left since that is the only 'A' whose neighbors are both 'A'.
 *
 * Now it's Bob's turn.
 * Bob cannot make a move on his turn since there are no 'B's whose neighbors are both 'B'.
 * Thus, Alice wins, so return true.
 * Example 2:
 *
 * Input: colors = "AA"
 * Output: false
 * Explanation:
 * Alice has her turn first.
 * There are only two 'A's and both are on the edge of the line, so she cannot move on her turn.
 * Thus, Bob wins, so return false.
 * Example 3:
 *
 * Input: colors = "ABBBBBBBAAA"
 * Output: false
 * Explanation:
 * ABBBBBBBAAA -> ABBBBBBBAA
 * Alice moves first.
 * Her only option is to remove the second to last 'A' from the right.
 *
 * ABBBBBBBAA -> ABBBBBBAA
 * Next is Bob's turn.
 * He has many options for which 'B' piece to remove. He can pick any.
 *
 * On Alice's second turn, she has no more pieces that she can remove.
 * Thus, Bob wins, so return false.
 *
 *
 * Constraints:
 *
 * 1 <= colors.length <= 100000
 * colors consists of only the letters 'A' and 'B'
 */
class ColoredPiecesRemovalGame {
    final Integer maxLength = 100000;
    final String aliceTurn = "A";

    public boolean winnerOfGame(String colors) {
        int totalAliceTurnsPossible = 0;
        int totalBobTurnsPossible = 0;
        int totalTurnsPossible = 0;
        int lengthOfSubstring = 0;

        int i = 0;
        while (i < maxLength) {
            if(i >= colors.length()) break;

            lengthOfSubstring = lengthOfSubstring(colors, i);

            //ignoring this substring, as turns are only possible with a sequence of minimum 3, i.e. "AAA"
            if(lengthOfSubstring < 3) {
                i = i + lengthOfSubstring;
                continue;
            }

            //total turns possible = lengthOfSubstring - 2, i.e. "AAAAA" = 3 turns possible, to reduce to "AA"
            totalTurnsPossible = lengthOfSubstring - 2;

            // Check if currentChar == "A", i.e. Alice's turn
            if(String.valueOf(colors.charAt(i)).equals(aliceTurn)) {
                totalAliceTurnsPossible = totalAliceTurnsPossible + totalTurnsPossible;
            } else { // colors.charAt(i) == "B", Bob's turn
                totalBobTurnsPossible = totalBobTurnsPossible + totalTurnsPossible;
            }

            i = i + lengthOfSubstring;
        }

        return (totalAliceTurnsPossible > totalBobTurnsPossible) ? true : false;
    }

    private Integer lengthOfSubstring(String colors, Integer startIndex) {
        int lengthOfSubstring = 1;
        String currentTurn = String.valueOf(colors.charAt(startIndex));
        String nextTurn;
        for(int i = startIndex; i < maxLength; i++) {
            if(i+1 >= colors.length()) break; // checking if next turn exists

            nextTurn = String.valueOf(colors.charAt(i+1));
            if(!currentTurn.equals(nextTurn)) {
                break;
            } else {
                lengthOfSubstring++;
            }
        }

        return lengthOfSubstring;
    }
}