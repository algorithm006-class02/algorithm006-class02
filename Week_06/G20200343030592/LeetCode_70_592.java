package com.gsf.geekbang_demo.arithmetic.leetCode.week06;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯(递归去重) 
 */
public class Demo70 {
    //f(n) = f(n - 1) + f(n - 2);

    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if (n <= 2) return n;
        if (!map.containsKey(n)) {
            map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        System.err.println(new Demo70().climbStairs(4));
    }
}
