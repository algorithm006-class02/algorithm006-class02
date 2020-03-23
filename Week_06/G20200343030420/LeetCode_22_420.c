/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
void dfs(int n, int left, int right, char *cache, char **res, int *returnSize) {
    if ((left == n) && (right == n)) {
        res[*returnSize] = calloc(2 * n + 1, sizeof(char)); 
        strncpy(res[*returnSize], cache, 2 * n); 
        (*returnSize)++; 
        return; 
    }
    if (left < n) {
        cache[left + right] = '('; 
        dfs(n, left + 1, right, cache, res, returnSize);
    }
    if (right < left) {
        cache[left + right] = ')'; 
        dfs(n, left, right + 1, cache, res, returnSize);
    }
}
char ** generateParenthesis(int n, int* returnSize) {
    char **res = calloc(10240, sizeof(char*)); 
    char *cache = calloc(2 * n + 1, sizeof(char));
    *returnSize = 0; 
    dfs(n, 0, 0, cache, res, returnSize); 
    free(cache); 
    return res; 
}
