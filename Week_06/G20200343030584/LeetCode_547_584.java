package week6;

import java.util.Arrays;
import java.util.Stack;

/**
 * 547. 朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
 * 你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * 示例 1:
 * 输入:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。第2个学生自己在一个朋友圈。所以返回2。
 * <p>
 * 注意：
 * 1.N 在[1,200]的范围内。
 * 2.对于所有学生，有M[i][i] = 1。
 * 3.如果有M[i][j] = 1，则有M[j][i] = 1。
 */
public class FriendCircle {
    public static void test() {
        int[][] circle = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int[][] circle = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println("朋友圈个数：" + new FriendCircle().findCircleNum(circle));
    }

    public int findCircleNum(int[][] M) {
        // 深度优先搜索
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            // N*N，其实总共就N个人，因为一个人可以独自成圈，所以至少有1个圈
            if (visited[i] == 0) {
                System.out.println("i:" + i);
                // 首先选择一个节点，访问任一相邻的节点。然后再访问这一节点的任一相邻节点。
                // 这样不断遍历到没有未访问的相邻节点时，回溯到之前的节点进行访问。
                dfsHelper(i, M, visited);
                count++;
            }
        }
        return count;
    }

    private void dfsHelper(int row, int[][] M, int[] visited) {
        for (int j = 0; j < M.length; j++) {
            System.out.println("row:" + row + ", j:" + j);
            if (M[row][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                // 注意这里的传的是j，不是 row+1
                dfsHelper(j, M, visited);
            }
        }
    }

//    i:0
//    row:0, j:0
//    row:0, j:0
//    row:0, j:1
//    row:1, j:0
//    row:1, j:1
//    row:1, j:2
//    row:0, j:2
//    row:0, j:1
//    row:0, j:2
//    i:2
//    row:2, j:0
//    row:2, j:1
//    row:2, j:2
//    row:2, j:0
//    row:2, j:1
//    row:2, j:2

    public int findCircleNum2(int[][] M) {
        // 广度优先搜索
        int[] visited = new int[M.length];
        int count = 0;
        Stack<Integer> queue = new Stack<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.push(i);
                while (!queue.isEmpty()) {
                    int row = queue.pop();
                    visited[row] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[row][j] == 1 && visited[j] == 0)
                            queue.push(j);
                    }
                }
                count++;
            }
        }
        return count;
    }

    public int findCircleNum3(int[][] M) {
        // 并查集
        int length = M.length;
        int[] parent = new int[length];
        Arrays.fill(parent, -1);
        // 组合出一个并查集数据结构
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (parent[i] == -1) count++;
        }
        return count;
    }

    private void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);
        if (x != y) {
            parent[x] = y;
        }
    }

    private int find(int[] parent, int p) {
        int target = p;
        while (parent[target] != -1) {
            target = parent[target];
        }
        return target;
    }
}
