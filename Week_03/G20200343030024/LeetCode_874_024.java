import java.util.HashMap;

class Solution {

    // 解题重点：方向的转换，
    // 剩下每走一步就判断是否遇到障碍，如果遇到障碍，就得停止，
    // 剩下优化方案应该是减少障碍的判断
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int[] dx = new int[]{0 , 1,  0, -1};
        int[] dy = new int[]{1 , 0, -1, 0};
        // 0,1  -1  =>  0,-1   0 => 3
        // 0,1  -2  =>  1, 0   0 => 1   
        HashMap<String, Boolean> obstacleMapping = new HashMap<String, Boolean>();
        for (int[] o : obstacles){
            obstacleMapping.put(o[0] + "-" + o[1], true);
        }

        int di = 0;
        int result = 0;
        for (int c : commands){
            // 方向转动
            if (c == -1) {
               di = (di + 1) % 4;
            }

            if (c == -2){
                di = (di + 3) % 4;
            }

            if (c > 0){
                for (int i = 0; i < c; i++){
                    int newX = x + dx[di];
                    int newY = y + dy[di];
                    if (obstacleMapping.containsKey(newX  + "-"+ newY)){
                        break;
                    }
                    x = newX;
                    y = newY;
                    result = Math.max(result, x * x + y * y);
                }
                
            }
        }

        return result;
    }
}