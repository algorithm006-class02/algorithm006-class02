class Solution:
def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:

    trie = {}
    for word in words:
        node = trie
        for char in word:
            node = node.setdefault(char, {})
        # end mark
        node['#'] = True
    
    def search(i: int, j: int, node, prefix, visited):

        if "#" in node:
            # find result
            res.add(prefix)
        for (dx, dy) in [(-1, 0), (1, 0), (0, -1), (0 , 1)]:
            _i, _j = i + dx, j + dy
            if -1 < _i < w and -1 < _j < h and (board[_i][_j] in node) and ((_i, _j) not in visited):
                # dfs
                search(_i, _j, node[board[_i][_j]], prefix+board[_i][_j], visited | {(_i, _j)})

    res, w, h = set(), len(board), len(board[0])
    for i in range(w):
        for j in range(h):
            if board[i][j] not in trie:
                continue
            search(i, j, trie[board[i][j]], board[i][j], {(i, j)})

    return list(res)
