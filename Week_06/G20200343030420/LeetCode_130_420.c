int *makeS(int size) {
    int *parent = calloc(size, sizeof(int));
    for (int i = 0; i < size; i++) 
        parent[i] = i; 
    return parent; 
}
/* 可以借助递归实现路径压缩 */ 
int findS(int *parent, int x) {
    while (parent[x] != x) 
        x = parent[x];      
    return x; 
}
int unionS(int *parent, int x, int y) {
    int hx = findS(parent, x), hy = findS(parent, y); 
    parent[hy] = hx; 
    return hx; 
}
/**
 * 遍历边界上所有为'O'的点，分别扩散；最后遍历整个二维，未被扩散到的'O'改为'X.
 * 扩散的话有四种方式：dfs递归，dfs非递归（借助stack），bfs非递归（借助queue），bfs递归（这种不常用）
 * 还有一种方法是用并查集，所有边界上的'O'以及和边界上'O'能连通的'O'都放入一个集合。
 */
int ndoePos(int i, int j, int colSize) {
    return i * colSize + j; 
}
void solve(char** board, int boardSize, int* boardColSize) {
    if ((!board) || (0 == boardSize) || (!boardColSize))
        return; 

    int rowSize = boardSize, colSize = boardColSize[0]; 
    int *parent = makeS(rowSize * colSize + 1); 
    int i, j, pos, dummy = rowSize * colSize;   //dummy为虚拟结点，就是makeS多的1
    for (i = 0; i < rowSize; i++) 
        for (j = 0; j < colSize; j++) 
            if ('O' == board[i][j]) {
                pos = ndoePos(i, j, colSize); 
                if ((i == 0) || (j == 0) || (i == rowSize - 1) || (j == colSize - 1)) 
                    unionS(parent, dummy, pos); 
                else {
                    //上，右，下，左的顺序
                    if ((i > 0) && ('O' == board[i - 1][j])) 
                        unionS(parent, pos, ndoePos(i - 1, j, colSize)); 
                    if ((j + 1 < colSize) && ('O' == board[i][j + 1])) 
                        unionS(parent, pos, ndoePos(i, j + 1, colSize)); 
                    if ((i + 1 < rowSize) && ('O' == board[i + 1][j])) 
                        unionS(parent, pos, ndoePos(i + 1, j, colSize)); 
                    if ((j > 0) && ('O' == board[i][j - 1])) 
                        unionS(parent, pos, ndoePos(i, j - 1, colSize)); 
                }
            }
    dummy = findS(parent, dummy); 
    for (i = 0; i < rowSize; i++) 
        for (j = 0; j < colSize; j++) {
            if (dummy == findS(parent, ndoePos(i, j, colSize)))
                board[i][j] = 'O'; 
            else 
                board[i][j] = 'X'; 
        }
}
