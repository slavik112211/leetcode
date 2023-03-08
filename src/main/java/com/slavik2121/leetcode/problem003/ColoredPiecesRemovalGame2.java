package com.slavik2121.leetcode.problem003;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 * March 4, 2023
 *
 * 2038. Remove Colored Pieces if Both Neighbors are the Same Color
 * Difficulty: Medium
 *
 * There are n pieces arranged in a line, and each piece is colored either by 'A' or by 'B'. You are given a string colors of length n where colors[i] is the color of the ith piece.
 *
 * Alice and Bob are playing a game where they take ColoredPiecesRemovalGamealternating turns removing pieces from the line. In this game, Alice moves first.
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
class ColoredPiecesRemovalGame2 {
    public boolean winnerOfGame(String colors) {
        final Character aliceChar = 'A';
        final boolean aliceCharBool = false;
        final boolean bobCharBool = true;

        // To speed-up the comparisons, transform input from text to bool array
        // i.e. from "AABBBBAAAA" to "0011110000"
        Boolean[] input = new Boolean[colors.length()];
        for (int i=0; i<colors.length(); i++) {
            input[i] = Character.valueOf(colors.charAt(i)).compareTo(aliceChar) == 0 ? false : true;
        }

        Boolean[] turnCompleted = new Boolean[colors.length()];
        Arrays.fill(turnCompleted, Boolean.FALSE);

        boolean aliceTurnSuccess = false;
        boolean bobTurnSuccess = false;
        boolean output = true;

        while(true) {

            // Alice turn
            aliceTurnSuccess = false;
            aliceTurnSuccess = gameTurn(input, turnCompleted, aliceCharBool);
            if (!aliceTurnSuccess) {
                output = false;
                break;
            }

            // Bob turn
            bobTurnSuccess = false;
            bobTurnSuccess = gameTurn(input, turnCompleted, bobCharBool);
            if (!bobTurnSuccess) {
                output = true;
                break;
            }
        }

        return output;
    }

    boolean gameTurn(Boolean[] input, Boolean[] turnCompleted, boolean characterBool) {
        boolean turnSuccess = false;
        for(int i = 0; i < input.length; i++) {
            if(input[i] == characterBool &&
                    0 <= i - 1 && i - 1 < input.length &&
                    0 <= i + 1 && i + 1 < input.length &&
                    input[i - 1] == characterBool &&
                    input[i + 1] == characterBool &&
                    turnCompleted[i] != true)
            {
                turnSuccess = true;
                turnCompleted[i] = true;
                break;
            }
        }

        return turnSuccess;
    }
}