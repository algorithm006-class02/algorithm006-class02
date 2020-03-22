from typing import List, Set


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = {'#': False}
        for word in words:
            node = trie
            for c in word:
                node = node.setdefault(c, {})
            node['#'] = True
        
        def dns(node, h, w, board, pre, result):
            if ('#' in node) and node['#']:
                result.add(pre)
            if (h < 0) or (w < 0) or (h >= row) or (w >= col):
                return
            c = board[h][w]
            if c in node:
                pre += c
                node = node[c]
                #上下左右
                step = [[h, w - 1], [h, w + 1], [h - 1, w], [h + 1, w]]
                board[h][w] = '@'
                for n in step:
                    dns(node, n[0], n[1], board, pre, result)
                board[h][w] = c

        result = set()
        row = len(board)
        col = len(board[0])
        for h in range(row):
            for w in range(col):
                dns(trie, h, w, board, '', result)
        return list(result)
      

print(Solution().findWords([["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],["oath","pea","eat","rain"]))