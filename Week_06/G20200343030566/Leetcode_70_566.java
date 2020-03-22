package com.sebar.test.leetcode.one.practice.array;

/**
 * @author liguang
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

    public int solutionTwo(int n) {
        double sqrt = Math.sqrt(5);
        double val = Math.pow((1 + sqrt) / 2, n + 1) - Math.pow((1 - sqrt) / 2, n + 1);
        return (int) (val / sqrt);
    }

    public int recursiveSolution(int n) {
        int[] solution = new int[n + 1];
        return solutionWay(0, n, solution);
    }

    private int solutionWay(int i, int n, int[] solution) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (solution[i] > 0) {
            return solution[i];
        }

        solution[i] = solutionWay(i + 1, n, solution) + solutionWay(i + 2, n, solution);
        return solution[i];
    }

    public static void main(String[] args) {
        Leetcode_70_566 code = new Leetcode_70_566();
        int i = code.recursiveSolution(4);
        System.out.println(i);
    }
}
