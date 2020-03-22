package com.example.leetCode.week5;


import java.util.Arrays;

public class LeetCode_621_386 {
///给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务
//都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
//
// 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
//
// 你需要计算完成所有任务所需要的最短时间。
//
// 示例 1：
//
//
//输入: tasks = ["A","A","A","B","B","B"], n = 2
//输出: 8
//执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
//
//
// 注：
//
//
// 任务的总个数为 [1, 10000]。
// n 的取值范围为 [0, 100]。
//
// Related Topics 贪心算法 队列 数组

    public int leastInterval(char[] tasks, int n) {
        // 题解地址：https://leetcode-cn.com/problems/task-scheduler/solution/621-ren-wu-diao-du-qi-java-jie-ti-zhu-shi-ying-gai/

        // 1. 先对所有字母分组
        // 2. 对分组进行排序，优先排列个数最多的，如果此时只看最多的这个任务的话，可以算出一个最小时间值
        //    retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
        // 3. 依次从后往前排序，如果依然等于最大的count数量，则直接在最后一行加1即可，时间上也是直接加1
        //    retCount++ ==> A->B->X->A->B->X->A->B
        // 4. 如果空位都插满了，还有需要插入的任务，则在每行的后面加上即可。
        //    所以，这里有一个思维上的转换：对于所有种类都已经排列过了，之后再有新种类，随便怎么放都可以，所以只需要判断总共的数量与已经留出空位的排好序的数量哪个大就取哪个即可

        if (tasks.length <= 1 || n < 1) {
            return tasks.length;
        }
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i] - 'A']++;
        }
        Arrays.sort(map);
        int maxCon = map[25];
        int minTime = (maxCon - 1) * (n + 1) + 1;
        int curr = 24;
        while (curr >= 0 && map[curr] == maxCon) {
            minTime++;
            curr--;
        }
        return Math.max(minTime, tasks.length);
    }

}
