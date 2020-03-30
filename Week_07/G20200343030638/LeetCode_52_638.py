class Solution:
    def totalNQueens(self, n: int) -> int:
        if n < 1: return []
        self.count = 0
        self.DFS(n, 0, 0, 0, 0)
        return self.count
    
    def DFS(self, n, row, cols, pie, na):
        # 递归终止条件
        if row >= n:
            self.count += 1
            return
        
        # 处理当前层
        # 列 撇 捺 表示之前的皇后占据了哪些列 撇 捺的位置，或在一起，就得到了所有被皇后所打掉的格子。然后再取反，就表示那些没有占的格子就被赋为1了。然后再 与 上 这个东西，把n皇后的n之前的那些全部赋值为0，只剩下8个1放在这里。如果是8皇后，8个二进制的1放在这里
        bits = ( ~(cols | pie | na)) & ((1 << n) - 1) # 得到当前所有的空位

        while bits:
            p = bits & -bits # 取到最低位的1
            bits = bits & (bits - 1) # 表示在p位置上放入皇后
            self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)

        # 在当前层里面扩散出新一层
        # 新一层设置好判重的数组，如果需要的话，要revert当前的状态