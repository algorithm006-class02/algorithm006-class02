package com.sebar.algorithm;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/16
 * @Description
 */
public class Leetcode_70_566 {
    /**
     * 解决方案一
     * 爬最后一个台阶的方案是有 n-1和n-2同时决定的，则
     * f(n)=f(n-1)+f(n-2)
     *
     * @param n
     * @return
     */
    public int solutionOne(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; ++i) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public int solutionTwo(int n){
        double sqrt = Math.sqrt(5);
        double val = Math.pow((1 + sqrt) / 2, n + 1) - Math.pow((1 - sqrt) / 2, n + 1);
        return (int)(val/sqrt);
    }
}
