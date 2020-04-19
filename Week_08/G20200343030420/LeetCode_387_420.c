int firstUniqChar(char * s) {
    if (!s) 
        return -1; 
    int *count = calloc(26, sizeof(int)); 
    int i, len = strlen(s), res = -1; 
    for (i = 0; i < len; i++) 
        count[s[i] - 'a']++; 
    for (i = 0; i < len; i++) 
        if (1 == count[s[i] - 'a']) {
            res = i; 
            break; 
        }
    free(count); 
    return res; 
}
