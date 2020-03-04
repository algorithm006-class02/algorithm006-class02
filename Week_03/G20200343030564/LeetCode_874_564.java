package week03;

import java.util.HashSet;

/**
 * 模拟行走机器人
 *
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 *
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * 返回从原点到机器人的最大欧式距离的平方。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 *
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 *
 */
public class LeetCode_874_564 {

    public static void main(String[] args) {
        LeetCode_874_564 leetCode = new LeetCode_874_564();
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles= {{2,4}};
        System.out.println(leetCode.robotSim(commands, obstacles));
    }

    /**
     * 思路：
     * 1.把障碍物的横纵坐标拼接起来放入到set集合中存储。
     * 2.再迭代commands数组，如果是-1就让d增加一位，d如果超出了3，就让d等于0；如果是-2就让减一位，如果d小于0，就让d等于3。
     * 因为-2：向左转 90 度，-1：向右转 90 度，旋转的时候就会退到或者增加到相邻的坐标中，int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}},
     * 如果当前是{1,0}在X的正半轴走一位，在-1的情况下，就变成了{0,-1}，旋转到了y的负半轴。
     * 3.判断commands里面的值减一后是否大于0，且x和y加移动的距离后是否在set集合中找到相同的数值，如果有则等待，如果没有则更新x和y的值。
     * 4.判断result的大小。
     *
     * 时间复杂度：O(N + M) 有两个不同的循环
     * 空间复杂度：O(M) 开辟了一个set集合
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        // 定义变量
        int x = 0, y = 0, d = 0, result = 0;
        // 面向北方出发
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        HashSet<String> set = new HashSet<String>();

        for (int[] temp : obstacles) {
            set.add(temp[0] + "" + temp[1]);
        }

        for (int temp : commands) {
            if (temp == -1) {
                d++;
                if (d == 4) d = 0;
            }else if (temp == -2) {
                d--;
                if (d == -1) d = 3;
            } else {
                while (temp-- > 0 && !set.contains(x + dirs[d][0] + "" + (y + dirs[d][1]))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }





}
