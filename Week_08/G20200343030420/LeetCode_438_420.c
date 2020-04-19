/**
 * a:0, b:1, c:2......
 */
int* findAnagrams(char * s, char * p, int* returnSize) {
    *returnSize = 0; 
    if ((!s) || (!p))
        return NULL; 
    int i, sLen = strlen(s), pLen = strlen(p); 
    if (sLen < pLen)
        return NULL; 
    int *res = calloc(sLen, sizeof(int)); 
    int *sHash = calloc(26, sizeof(int)); 
    int *pHash = calloc(26, sizeof(int)); 
    for (i = 0; i < pLen; i++) {
        sHash[s[i] - 'a']++; 
        pHash[p[i] - 'a']++; 
    }
    for (i = 0; i < sLen - pLen + 1; i++) {
        if (i > 0 ) {
            sHash[s[i - 1] - 'a']--;
            sHash[s[i - 1 + pLen] - 'a']++;
        } 
        if (0 == memcmp(sHash, pHash, sizeof(int) * 26)) {
            res[*returnSize] = i; 
            (*returnSize)++; 
        } 
    }
    return res; 
}
