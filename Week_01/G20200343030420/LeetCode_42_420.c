int trap(int* height, int heightSize) {
    if ((NULL == height) || (heightSize < 3))
        return 0; 
    int i, area = 0; 
    int *lmax = calloc(heightSize, sizeof(int)); 
    int *rmax = calloc(heightSize, sizeof(int)); 

    lmax[0] = height[0]; 
    rmax[heightSize - 1] = height[heightSize - 1]; 
    for (i = 1; i < heightSize; i++)
        lmax[i] = (lmax[i - 1] > height[i]) ? lmax[i - 1] : height[i]; 
    for (i = heightSize - 2; i >= 0; i--) 
        rmax[i] = (rmax[i + 1] > height[i]) ? rmax[i + 1] : height[i]; 
    for (i = 1; i < heightSize - 1; i++)
        area += ((lmax[i] < rmax[i]) ? lmax[i] : rmax[i]) - height[i]; 
    free(lmax); 
    free(rmax); 
    return area; 
}

int trap_2(int* height, int heightSize) {
    if ((NULL == height) || (heightSize < 3))
        return 0; 
    int l = 0, r = heightSize - 1, lmax = height[0], rmax = height[heightSize - 1], area = 0; 
    while (l < r) {
        lmax = (lmax > height[l]) ? lmax : height[l]; 
        rmax = (rmax > height[r]) ? rmax : height[r]; 
        if (lmax < rmax) 
            area += lmax - height[l++]; 
        else 
            area += rmax - height[r--]; 
    }
    return area; 
}
