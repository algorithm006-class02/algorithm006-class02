class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        # 如果遇见障碍物则不能使用dp[i+1][j]+dp[i][j+1], 直接将该障碍物的到达终点的步数设置为0 即可
        # 思路1:使用自低向上的写法
        if not obstacleGrid:
            return 0
        row=len(obstacleGrid)
        col=len(obstacleGrid[0])
        dp=[1]*col
        i=col-1
        while i>-1:
            if obstacleGrid[-1][i]==1:
                for j in range(i+1):
                    dp[j]=0
                break
            i-=1
        obs=False 
        for i in range(row-2,-1,-1):
            if not obs and obstacleGrid[i][col-1]!=1 :
                left=1
            else:
                left=0
                obs=True
            for j in range(col-2,-1,-1):
                if obstacleGrid[i][j]==1:
                    dp[j],left=0,0
                else:
                    dp[j]=left+dp[j]
                    left=dp[j]

        return 0 if obstacleGrid[0][0]==1 or obstacleGrid[-1][-1]==1  else dp[0]