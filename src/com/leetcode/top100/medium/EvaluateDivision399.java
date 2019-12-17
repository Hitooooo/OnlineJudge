package com.leetcode.top100.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

/**
 * @author hitomeng
 * @date 2019/11/19
 */
public class EvaluateDivision399 {
    /**
     * 构造一个双向图。a/b=1 b/c=2 构造 a->b = 1,
     * b->a=1,b->c=2,c->b=1/2。那么a->c=(a/b)*(b/c)=a到c路径上的值乘积
     * 
     * @param equations 等式
     * @param values    等式结果
     * @param queries   需要计算对
     * @return 计算结果
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> m = graph(equations, values);
        double[] r = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++){
            r[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, m, new HashSet<>());
        }
        return r;
    }

    /**
     * 构造图双向图
     */
    private Map<String, Map<String, Double>> graph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> grapha = new HashMap<>();
        if (values == null || values.length == 0) {
            return null;
        }

        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            grapha.putIfAbsent(equation.get(0), new HashMap<>());
            grapha.putIfAbsent(equation.get(1), new HashMap<>());
            grapha.get(equation.get(0)).put(equation.get(1), values[i]);
            grapha.get(equation.get(1)).put(equation.get(0), 1 / values[i]);
        }
        return grapha;
    }

    /**
     * 深度搜索确定值。 a->b的值= 路径上的值相乘
     */
    private double dfs(String s, String t, double r, Map<String, Map<String, Double>> m, Set<String> seen) {
        // 不满足搜索条件，直接返回
        if (!m.containsKey(s) || !seen.add(s)) {
            return -1;
        }
        // 搜索到底，返回入参中的上一层乘积即可
        if (s.equals(t)) {
            return r;
        }
        // 获取下一个数
        Map<String, Double> next = m.get(s);
        // 遍历下一个数可以到达的下一个字母
        for (String key : next.keySet()) {
            // 进入下一层
            double result = dfs(key, t, r * next.get(key), m, seen);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));
        double[] values = new double[]{2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","a"));
        queries.add(Arrays.asList("a","e"));
        queries.add(Arrays.asList("a","a"));
        queries.add(Arrays.asList("x","x"));

        double[] result = calcEquation(equations, values, queries);
        System.out.println(result);
    }
}