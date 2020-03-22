class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if not matrix: return 0
        m, n = len(matrix), len(matrix[0])
        dp = [[1 if ch == '1' else 0 for ch in row] for row in matrix]

        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == '1':
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])+1
        
        return max(max(row) for row in dp) ** 2