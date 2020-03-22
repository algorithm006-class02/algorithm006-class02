void dfs(char **board, int boardSize, int* boardColSize, int row, int col) {
    if ((row < 0) || (row >= boardSize) || (col < 0) || (col >= boardColSize[row])) 
        return; 

    /* 遍历到的如果不是E，说明已经遍历过，直接返回 */ 
    if ('E' != board[row][col]) 
        return; 

    /* 遍历顺序：右，右下，下，左下，左，左上，上，右上 */ 
    int dr[8] = {0, 1, 1, 1, 0, -1, -1, -1}; 
    int dc[8] = {1, 1, 0, -1, -1, -1, 0, 1}; 
    int tr, tc, i, num = 0; 
    /* 判断周围是否有M，有的话标记为M的数目，然后返回 */ 
    for (i = 0; i < 8; i++) {
        tr = row + dr[i]; 
        tc = col + dc[i]; 
        if ((tr >= 0) && (tr < boardSize) && (tc >= 0) && (tc < boardColSize[row]) && ('M' == board[tr][tc])) 
            num++; 
    }
    if (num > 0) {
        board[row][col] = num + 0x30; 
        return; 
    }
    /* 周围没有M，标记为B，继续遍历八个方向 */ 
    for (i = 0; i < 8; i++) {
        board[row][col] = 'B'; 
        dfs(board, boardSize, boardColSize, row + dr[i], col + dc[i]);  
    } 
}
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
/**
 * 用户能点击的只能是M或者E，如果点击到M，将M变为X，退出；
 * 如果点击到E，将所有跟该位置相连的E都找出来，要么是B，要么是数字。数字周围的M或者E不能递归 
 */ 
char** updateBoard(char** board, int boardSize, int* boardColSize, int* click, int clickSize, int* returnSize, int** returnColumnSizes) {
    if ((!board) || (boardSize < 1) || (!click) || (clickSize < 2)) 
        return NULL; 

    int i, row = click[0], col = click[1]; 
    char **res = calloc(boardSize, sizeof(char*)); 
    *returnSize = boardSize; 
    *returnColumnSizes = calloc(boardSize, sizeof(int)); 
    for (i = 0; i < boardSize; i++) {        
        (*returnColumnSizes)[i] = boardColSize[i]; 
        res[i] = calloc(boardColSize[i], sizeof(char)); 
        memcpy(res[i], board[i], boardColSize[i] * sizeof(char));
    }

    /* 点击的如果是M */ 
    if ('M' == res[row][col]) {
        res[row][col] = 'X'; 
        return res; 
    }

    /* 点击的肯定是E */ 
    dfs(res, boardSize, boardColSize, row, col); 

    return res; 
}
