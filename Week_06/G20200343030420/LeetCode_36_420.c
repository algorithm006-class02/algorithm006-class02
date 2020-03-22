#define GET_BIT_VAL(_x, _n)     ((_x) & (1 << (_n)))
bool isValidSudoku(char** board, int boardSize, int* boardColSize) {
    int *mask = calloc(boardSize, sizeof(int)); 
    int i, j, sub, val; 
    for (i = 0; i < boardSize; i++) 
        for (j = 0; j < boardColSize[i]; j++) 
            if ((board[i][j] >= '1') && (board[i][j] <= '9')) {
                val = board[i][j] - '1'; 
                sub = (i / 3) * 3 + j / 3; 
                if (GET_BIT_VAL(mask[i], val) || GET_BIT_VAL(mask[j], 9 + val) || GET_BIT_VAL(mask[sub], 18 + val))
                    return false; 
                mask[i] |= 1 << val; 
                mask[j] |= 1 << (9 + val); 
                mask[sub] |= 1 << (18 + val); 
            }
    free(mask); 
    return true; 
}
