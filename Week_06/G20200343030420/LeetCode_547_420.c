int *makeS(int size) {
    int *parent = calloc(size, sizeof(int));
    for (int i = 0; i < size; i++) 
        parent[i] = i; 
    return parent; 
}
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
/* 跟岛屿数量问题本质是相同的，但这里我们用并查集来实现 */ 
int findCircleNum(int** M, int MSize, int* MColSize) {
    int i, j, res = 0; 
    int *stat = calloc(MSize, sizeof(int));  
    int *parent = makeS(MSize); 
    for (i = 0; i < MSize; i++) 
        for (j = i; j < MColSize[i]; j++) 
            if (1 == M[i][j])
                unionS(parent, i, j); 
    for (i = 0; i < MSize; i++) {
        j = findS(parent, i); 
        if (0 == stat[j])
            res++; 
        stat[j]++; 
    } 
    free(parent); 
    free(stat); 
    return res; 
}
