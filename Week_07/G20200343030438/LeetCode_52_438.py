class Solution:
    vis=[0]*100
    sub=[0]*200
    add=[0]*200
    ans=0
    def totalNQueens(self, n: int) -> int:
        def dfs(i):
            if i==n+1:
                self.ans+=1
                return
            j=1
            while j<=n:
                if not self.vis[j] and not self.sub[i-j+100] and not self.add[i+j]:
                    self.vis[j]=self.sub[i-j+100]=self.add[i+j]=1
                    dfs(i+1)
                    self.sub[i-j+100]=self.add[i+j]=self.vis[j]=0
                j+=1
        dfs(1)
        return self.ans
