//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean isY = true;
    int[] directions = new int[]{1, 1, -1, -1};
    int idx = 0;

    int x = 0;
    int y = 0;

    int max = 0;

    Set<Long> set = new HashSet<>();

    public int robotSim(int[] commands, int[][] obstacles) {
        transfer(obstacles);

        if (commands.length == 0) {
            return 0;
        }
        for (int command : commands) {
            if (command >= 0) {
                for (int i = 0; i < command; i++) {
                    if (nextIsObstacle()) {
                        break;
                    }
                    if (isY) {
                        y += directions[idx];
                    }else {
                        x += directions[idx];
                    }

                    max = Math.max(max, x * x + y * y);
                }

            } else if (command == -1) {
                isY = !isY;
                idx = (idx + 1) % 4;
            } else {
                isY = !isY;
                idx = (idx + 3) % 4;
            }
        }
        return max;
    }

    private void transfer(int[][] obstacles) {
        for (int[] obstacle : obstacles) {
            // 由题目条件可得，x,y最小为-30000，1、将x,y转为非负数；2、将x扩大65536倍；3、与y相加；
            // 得到一个编码后的坐标值。
            set.add(((long)(obstacle[0] + 30000) << 16) + (long)(obstacle[1] + 30000));
        }
    }

    private boolean nextIsObstacle() {
        if (set.isEmpty()) {
            return false;
        }
        if (isY) {
            return set.contains(((long)(x + 30000) << 16) + ((long)y + directions[idx] + 30000));
        } else {
            return set.contains(((long)(x + directions[idx] + 30000) << 16) + ((long)y + 30000));
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
