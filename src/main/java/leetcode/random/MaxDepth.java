package leetcode.random;

import java.util.Stack;
/**
 * LeetCode 1614: Maximum Nesting Depth of the Parentheses

 * Given a valid parentheses string s, return the nesting depth of s.
 * The nesting depth is the maximum number of nested parentheses.

 * Example 1:
 * Input: s = "(1+(2*3)+((8)/4))+1"
 * Output: 3
 * Explanation:
 * Digit 8 is inside of 3 nested parentheses in the string.

 * Example 2:
 * Input: s = "(1)+((2))+(((3)))"
 * Output: 3
 * Explanation:
 * Digit 3 is inside of 3 nested parentheses in the string.

 * Example 3:
 * Input: s = "()(())((()()))"
 * Output: 3

 * Constraints:
 * 1 <= s.length <= 100
 * s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
 * It is guaranteed that parentheses expression s is a VPS.
 *
 * @author rathi.prakhar@outlook.com
 */
public class MaxDepth {

    /**
     * Use a stack. When c == '(' push onto the stack, else pop. return max of stack size.
     */
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack();
        int max = Integer.MIN_VALUE;

        for (char c: s.toCharArray()) {
            if (c == '(') stack.push(c);
            if (c == ')') stack.pop();

            max = Math.max(max, stack.size());
        }

        return max;
    }

    /**
     * No need for a stack, just keep the count of brackets.
     * if '(' increase count by 1 else if ')' decrease by 1 if count > 0
     */
    public int maxDepthCount (String s) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (char c: s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')' && count > 0) count--;

            max = Math.max(max, count);
        }

        return max;
    }

}
