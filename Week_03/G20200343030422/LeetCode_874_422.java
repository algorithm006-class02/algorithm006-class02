import java.util.HashSet;
import java.util.Set;

public class LeetCode_874_422 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dir = {{0, 1},
                {-1, 0},
                {0, -1},
                {1, 0}};
        int i = 0, j = 0, di = 0, eDist = 0;
        Set<String> obs = new HashSet<String>();

        for (int[] ob : obstacles) {
            int a = ob[0];
            int b = ob[1];
            obs.add(a + " " + b);
        }

        int ind = 0;

        while (ind < commands.length) {
            int act = commands[ind];
            ind++;
            if (act == -2) {
                di = (di + 1) % 4;
            } else if (act == -1) {
                di = (di + 3) % 4;
            } else {
                while (act > 0) {
                    int ti = i + dir[di][0];
                    int tj = j + dir[di][1];
                    if (!obs.contains(ti + " " + tj)) {
                        i += dir[di][0];
                        j += dir[di][1];
                    }
                    act--;
                }
            }

            eDist = Math.max(eDist, i * i + j * j);
        }

        return eDist;
    }

    public int robotSimCnLeetCode(int[] commands, int[][] obstacles){
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        Set<Long> obstacleSet = new HashSet<Long>();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd: commands) {
            if (cmd == -2) {
                di = (di + 3) % 4;
            } else if (cmd == -1) {
                di = (di + 1) % 4;
            } else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }
}
