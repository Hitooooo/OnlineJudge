package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is: [ "((()))", "(()())", "(())()",
 * "()(())", "()()()" ]
 * 
 * @author hitomeng
 * @date 2019/09/03
 */
public class GenerateParentheses {

    /**
     * DFS,递归的思想不要纠结具体的执行流程，
     */
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        helper(resultList, "", 0, 0, n);
        return resultList;
    }

    /**
     * if (左右括号都已用完) {
     *   加入解集，返回
     * }
     * //否则开始试各种选择
     * if (还有左括号可以用) {
     *   加一个左括号，继续递归
     * }
     * if (右括号小于左括号) {
     *   加一个右括号，继续递归
     * }
     * @param str   承载满足条件的结果
     * @param open  （个数
     * @param close )个数
     * @param n     括号对数
     */
    private void helper(List<String> resultList, String str, int open, int close, int n) {
        if (open == n && close == n) {
            resultList.add(str);
            return;
        }

        if (open < n) {
            helper(resultList, str + "(", open + 1, close, n);
        }
        if (open > close) {
            helper(resultList, str + ")", open, close + 1, n);
        }
    }

    @Test
    public void test(){
        List<String> result  = generateParenthesis(3);
        System.out.println(result);
        /*
            0:"((()))"
            1:"(()())"
            2:"(())()"
            3:"()(())"
            4:"()()()"
        */
    }
}