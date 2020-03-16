# =====================================
# No.221 最大正方形
# 解题思路：dp[i][j]表示以第ii行，第jj列处为右下角的最大正方形的边长。
# 仅当该位置为11时，才有可能存在正方形。且递推公式为：
# dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1dp[i][j]=min(dp[i−1][j−1],dp[i−1][j],dp[i][j−1])+1
# =====================================

class Solution:
    def maximalSquare(self, matrix):
        if(not matrix):
            return 0
        m=len(matrix)
        n=len(matrix[0])
        res=0
        dp=[[0]*(n+1) for _ in range(m+1)]
        for i in range(1,m+1):
            for j in range(1,n+1):
                if(matrix[i-1][j-1]=="1"):
                    dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
                    res=max(dp[i][j],res)
        return res*res


if __name__ == '__main__':
    solution = Solution()
    test_1 =  [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    count1=solution.maximalSquare(test_1)
    print(count1)
