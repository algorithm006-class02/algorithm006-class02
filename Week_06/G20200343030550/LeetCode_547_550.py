def findCircleNum(M):
    """
    :type M: List[List[int]]
    :rtype: int
    """
    N = len(M)
    seen = set()
    def dfs(node):
        for nei, adj in enumerate(M[node]):
            if adj and nei not in seen:
                seen.add(nei)
                dfs(nei)
    
    ans = 0
    for i in xrange(N):
        if i not in seen:
            dfs(i)
            ans += 1
    return ans