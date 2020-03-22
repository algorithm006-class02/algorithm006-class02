package algorithm.leetCode.week03.No50;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author ltw
 * on 2020-02-25.
 */
class Solution {
    // solution1: 暴力法 超时 时间复杂度 O(n)
//    public double myPow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//        if (n < 0) {
//            return 1 / myPow(x, -n);
//        }
//        double result = x;
//        for (int i = 1; i < n; i++) {
//            result *= x;
//        }
//        return result;
//    }

    //solution2:分治

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        return (n % 2 == 0) ? half * half : half * half * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000, 10));
    }
}

