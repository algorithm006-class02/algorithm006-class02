
### 思路
```json
1. if obstacleGrid[0][0] == 1, then return 0;
2. if obstacleGrid[0][0] == 0, then set obstacleGrid[0][0]=1
3. 迭代第一行, obstacleGrid[0][j] = (obstacleGrid[0][j]==0&obstacleGrid[0][j-1]==1)? 1:0 (j>0)
4. 迭代第一列，obstacleGrid[i][0] = (obstacleGrid[i][0]==0&obstacleGrid[i-1][0]==1)? 1:0 (i>0)
5. 从obstacleGrid[1][1]开始迭代处理，obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1]
6. if obstacleGrid[i][j] == 1, then set obstacleGrid[i][j] == 0
```

### Solution
```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;

        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[R - 1][C - 1];
    }
}
```
