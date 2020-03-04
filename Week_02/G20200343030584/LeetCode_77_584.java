package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/combinations
 */
public class Combinations {
    private List<List<Integer>> res = new ArrayList<>();

    public static void test() {
        List<List<Integer>> combine = new Combinations().combine(4, 2);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        // 回溯法：先选一个数字，然后进入递归继续选，满足条件后加到结果中，然后回溯到上一步，继续递归
        // https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        helper(n, k, 1, new Stack<>());
        return res;
    }

    private void helper(int n, int k, int begin, Stack<Integer> pre) {
//        System.out.println("helper " + begin);
        // 终结条件：达到目标个数
        if (pre.size() == k) {
//            System.out.println(pre);
            res.add(new ArrayList<>(pre));
            return;
        }

        // 控制遍历
        for (int i = begin; i <= n; i++) {
//            System.out.println("push " + i);
            // 当前层遍历数进栈
            pre.push(i);
            helper(n, k, i + 1, pre);
            // 当前层完了之后还得出栈，准备下一层
            pre.pop();
//            System.out.println("pop " + pop);
        }
    }

    // 剪枝优化版
    private void helper2(int n, int k, int begin, Stack<Integer> pre) {
        // 终结条件：达到目标个数
        if (pre.size() == k) {
            res.add(new ArrayList<>(pre));
            return;
        }

        // 控制遍历：剪枝优化点，在于减少不必要的遍历
        for (int i = begin; i <= n - (k - pre.size()) + 1; i++) {
            // 当前层遍历数进栈
            pre.push(i);
            helper(n, k, i + 1, pre);
            pre.pop();
        }
    }

//    日志打印记录
//    helper 1
//    push 1
//    helper 2
//    push 2
//    helper 3
//            [1, 2]
//    pop 2
//    push 3
//    helper 4
//            [1, 3]
//    pop 3
//    push 4
//    helper 5
//            [1, 4]
//    pop 4
//    pop 1
//    push 2
//    helper 3
//    push 3
//    helper 4
//            [2, 3]
//    pop 3
//    push 4
//    helper 5
//            [2, 4]
//    pop 4
//    pop 2
//    push 3
//    helper 4
//    push 4
//    helper 5
//            [3, 4]
//    pop 4
//    pop 3
//    push 4
//    helper 5
//    pop 4
}
