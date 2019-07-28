package com.leetcode.top100.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * @author HitoM
 * @date 2019/3/25 0:01
 */
public class ValidParentheses {
    public static boolean solution(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!stack.empty() && check(stack.peek(), chars[i])) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.empty();
    }

    private static boolean check(char c1, char c2) {
        boolean result = false;
        switch (c1) {
            case '(':
                result = c2 == ')';
                break;
            case '[':
                result = c2 == ']';
                break;
            case '{':
                result = c2 == '}';
                break;
            default:
                break;
        }
        return result;
    }
}
